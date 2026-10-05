package factory;
import com.aerospike.client.Record;
import utilities.AerospikeUtil;

public class aerospike {

   





    public static void main(String[] args) {
        String set = args.length > 0 ? args[0] : AerospikeUtil.getSet();
        String key = args.length > 1 ? args[1] : "p-cWmUEqg4MGRdaJp0";

        try {
            System.out.println("Fetching Aerospike record: namespace=" + AerospikeUtil.getNamespace()
                    + ", set=" + set + ", key=" + key);

            Record record = AerospikeUtil.get(set, key, AerospikeUtil.getBin());
            if (record == null) {
                System.out.println("Record not found. Tried keys like "
                        + key + ":tray and " + key + ":pending in ns="
                        + AerospikeUtil.getNamespace() + " set=" + set);
                return;
            }

            System.out.println("generation=" + record.generation);
            System.out.println("expiration=" + record.expiration);
            System.out.println("bins=" + record.bins);

            String resolvedBin = AerospikeUtil.resolveBinName(record, AerospikeUtil.getBin());
            Object tray = record.getValue(resolvedBin);
            System.out.println(resolvedBin + "=" + tray);
        } finally {
            AerospikeUtil.close();
        }
    }
}

    

