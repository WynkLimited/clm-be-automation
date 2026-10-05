package factory;

public class PayloadFactory {

    public static String getPayload(String type){
        return switch (type) {
            case "arsenal_Collection" -> "src/test/resources/data/json/collection.json";
            case "origami" -> "src/test/resources/data/json/collection1.json";
            case "feed_service_build" -> "src/test/resources/data/json/feedService/feedBuildTemplate.json";
            default -> "";
        };
    }
}
