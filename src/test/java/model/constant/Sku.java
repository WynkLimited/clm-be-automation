package model.constant;

import lombok.Data;


import java.util.*;

@Data
public class Sku {

    private static final Map<String, String> packMap = new LinkedHashMap<>();

    static {

        // Prime Lite Mappings
        packMap.put("amazon_prime:claimed", "amazon_prime");
        packMap.put("amazon_prime:claim_in_progress", "amazon_prime");
        packMap.put("amazon_prime:pending_activation", "amazon_prime");

        packMap.put("jiohotstar:claimed", "hotstar_dth");
        packMap.put("jiohotstar:claim_in_progress", "hotstar_dth");
        packMap.put("jiohotstar:pending_activation", "hotstar_dth");

        // Zee Mappings
        packMap.put("zeefive:claimed", "zeefive");
        packMap.put("zeefive:claim_in_progress", "zeefive");
        packMap.put("zeefive:pending_activation", "zeefive");

        // Xstream Premium (Standard) Mappings
        packMap.put("xstreampremium:claimed", "standard");
        packMap.put("xstreampremium:claim_in_progress", "standard");
        packMap.put("xstreampremium:pending_activation", "standard");

        // Netflix Mappings
        packMap.put("netflix:claimed", "netflix");
        packMap.put("netflix:claim_in_progress", "netflix");
        packMap.put("netflix:pending_activation", "netflix");

        // Old - Xstream Premium (Standard) Mappings
        packMap.put("xstreampremium_paid", "standard");
        packMap.put("xstreampremium_telco_paid", "standard");
    }

    private static final List<String> STANDARD_CONTENT_PARTNERS =
            Arrays.asList(
                    "livetv",
                    "distrotv",
                    "sonyliv_vod",
                    "sunnxt",
                    "fancode",
                    "manoramamax",
                    "epicon",
                    "playflix",
                    "erosnow",
                    "shemaroome",
                    "hungama",
                    "minitv",
                    "lionsgateplay",
                    "hoichoi",
                    "chaupal",
                    "aha",
                    "klikk",
                    "rajtv",
                    "stage",
                    "docubay",
                    "altbalaji",
                    "ultra",
                    "dollywood",
                    "shortstv",
                    "nammaflix",
                    "kancchalanka",
                    "xstreamads",
                    "creator",
                    "mwtv",
                    "addatimes",
                    "vrott",
                    "chanajor",
                    "etvwin"
            );

    public static List<String> getStandardContentPartners(){
        return STANDARD_CONTENT_PARTNERS;
    }


    public static List<String> getCpFromPackId(String packId) {
        if (packId == null || packId.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String[] packIdArray = packId.split(",");
        Set<String> enabledCps = new HashSet<>();

        for (String id : packIdArray) {
            if (id == null || id.trim().isEmpty()) {
                continue;
            }

            String normalizedId = id.trim().toLowerCase();
            String product = packMap.get(normalizedId);

            if (product != null && !product.trim().isEmpty()) {
                if ("standard".equalsIgnoreCase(product)) {
                    enabledCps.addAll(STANDARD_CONTENT_PARTNERS);
                } else {
                    enabledCps.add(product);
                }
            }
        }

        return new ArrayList<>(enabledCps);
    }
}
