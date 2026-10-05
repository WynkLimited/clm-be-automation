package utilities;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Host;
import com.aerospike.client.Info;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.ClientPolicy;
import com.typesafe.config.Config;
import config.ConfigLoader;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class AerospikeUtil {

    private static final Config conf = ConfigLoader.load();


   
    private static AerospikeClient client;

    private AerospikeUtil() {}

    public static synchronized AerospikeClient getClient() {
        if (client == null || !client.isConnected()) {
            ClientPolicy policy = new ClientPolicy();
           

            policy.user = conf.getString("aerospikeUser");
            policy.password = conf.getString("aerospikePassword");
            policy.clusterName = conf.getString("aerospikeClusterName");

            String[] hostNames = conf.getString("aerospikeHosts").split(",");
            Host[] hosts = new Host[hostNames.length];
            int index = 0;
            for (String hostName : hostNames) {
                String trimmedHost = hostName.trim();
                if (!trimmedHost.isEmpty()) {
                    hosts[index++] = new Host(trimmedHost, conf.getInt("aerospikePort"));
                }
            }
            hosts = Arrays.copyOf(hosts, index);

            System.out.println("Connecting to Aerospike hosts=" + Arrays.toString(hosts)
                    + ", cluster=" + policy.clusterName
                    + ", namespace=" + getNamespace());
            client = new AerospikeClient(policy, hosts);
            System.out.println("Aerospike connected: " + client.isConnected());
        }
        return client;
    }

    public static String getNamespace() {
        return conf.getString("aerospikeNamespace");
    }

    public static String getSet() {
        return conf.getString("aerospikeSet");
    }

    public static String getBin() {
        return conf.getString("aerospikeBin");
    }

    public static Record get(String userKey) {
        return get(getSet(), userKey);
    }

    public static Record get(String set, String userKey) {
        return get(set, userKey, null);
    }

    public static Record get(String set, String userKey, String binName) {
        AerospikeClient aerospikeClient = getClient();
        for (String candidateKey : buildCandidateKeys(userKey, binName)) {
            try {
                Key key = new Key(getNamespace(), set, candidateKey);
                Record record = aerospikeClient.get(null, key);
                if (record != null) {
                    return record;
                }
            } catch (AerospikeException e) {
                throw new IllegalStateException(
                        "Aerospike lookup failed for namespace=" + getNamespace()
                                + ", set=" + set
                                + ", key=" + candidateKey
                                + (binName == null ? "" : ", bin=" + binName)
                                + " :: " + e.getMessage(),
                        e
                );
            }
        }
        return null;
    }

    public static Object getSimilarContent(String userKey) {
        return getBin(getSet(), userKey, getBin());
    }

    public static Object getBin(String set, String userKey, String binName) {
        Record record = get(set, userKey, binName);
        if (record == null) {
            return null;
        }
        for (String candidateBin : buildCandidateBins(binName)) {
            Object value = record.getValue(candidateBin);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    /**
     * Lists set names from Aerospike info (optionally filtered by configured namespace).
     */
    public static Set<String> listSets() {
        AerospikeClient aerospikeClient = getClient();
        String info = Info.request(aerospikeClient.getNodes()[0], "sets");
        String namespace = getNamespace();

        Set<String> sets = new LinkedHashSet<>();
        if (info == null || info.isBlank()) {
            return sets;
        }

        // Format: ns=discovery:set=recommendations:objects=...:...;ns=discovery:set=other:...
        for (String part : info.split(";")) {
            String setName = null;
            String nsName = null;
            for (String token : part.split(":")) {
                if (token.startsWith("ns=")) {
                    nsName = token.substring(3);
                } else if (token.startsWith("set=")) {
                    setName = token.substring(4);
                }
            }
            if (setName != null && (namespace == null || namespace.equals(nsName))) {
                sets.add(setName);
            }
        }
        return sets;
    }

    public static void delete(String userKey) {
        delete(getSet(), userKey);
    }

    public static void delete(String set, String userKey) {
        Key key = new Key(getNamespace(), set, userKey);
        getClient().delete(null, key);
    }

    public static boolean exists(String userKey) {
        return exists(getSet(), userKey);
    }

    public static boolean exists(String set, String userKey) {
        Key key = new Key(getNamespace(), set, userKey);
        return getClient().exists(null, key);
    }

    public static String resolveRecordKey(String set, String userKey, String binName) {
        for (String candidateKey : buildCandidateKeys(userKey, binName)) {
            if (exists(set, candidateKey)) {
                return candidateKey;
            }
        }
        return userKey;
    }

    public static String resolveBinName(Record record, String binName) {
        if (record == null) {
            return binName;
        }
        for (String candidateBin : buildCandidateBins(binName)) {
            if (record.bins != null && record.bins.containsKey(candidateBin)) {
                return candidateBin;
            }
        }
        return binName;
    }

    /**
     * Feed-service {@code MdKeyspace} writes string keys as {@code {uid}:tray} / {@code {uid}:delivered}
     * in namespace {@code md}, set {@code feed}. Arsenal also uses {@code {uid}:pending} for a pending
     * tray. The on-disk tray bin is {@code t} (see ServeCacheCodec.TRAY_BIN).
     *
     * <p>The Aerospike browser reads the stored string key as-is
     * ({@code new Key(namespace, set, keyId)}), so lookups try those shapes before the raw uid.
     */
    private static Set<String> buildCandidateKeys(String userKey, String binName) {
        Set<String> candidateKeys = new LinkedHashSet<>();
        if (userKey == null || userKey.isBlank()) {
            return candidateKeys;
        }

        if (userKey.contains(":")) {
            candidateKeys.add(userKey);
        }

        if (binName != null && !binName.isBlank()) {
            candidateKeys.add(userKey + ":" + binName);
            for (String candidateBin : buildCandidateBins(binName)) {
                candidateKeys.add(userKey + ":" + candidateBin);
            }
            if ("tray".equalsIgnoreCase(binName) || "t".equalsIgnoreCase(binName)) {
                candidateKeys.add(userKey + ":pending");
            }
        }

        candidateKeys.add(userKey);
        return candidateKeys;
    }

    private static Set<String> buildCandidateBins(String binName) {
        Set<String> candidateBins = new LinkedHashSet<>();
        if (binName == null || binName.isBlank()) {
            return candidateBins;
        }

        candidateBins.add(binName);

        Map<String, String> aliases = new LinkedHashMap<>();
        aliases.put("tray", "t");
        aliases.put("delivered", "d");

        String alias = aliases.get(binName);
        if (alias != null) {
            candidateBins.add(alias);
        }
        return candidateBins;
    }

    public static synchronized void close() {
        if (client != null) {
            client.close();
            client = null;
        }
    }

}
