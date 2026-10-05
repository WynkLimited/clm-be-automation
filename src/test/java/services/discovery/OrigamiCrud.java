package services.discovery;

import io.restassured.response.Response;
import utilities.BaseServiceClient;

import java.util.HashMap;
import java.util.Map;

public class OrigamiCrud extends BaseServiceClient {

    private final String ORIGAMI_CRUD = "/origami-crud/v1";

    private String getUrl(String endPoint) {
        return ORIGAMI_CRUD + endPoint;
    }

    // ********************* Templates *********************
    public Response getTemplateSearch(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/config/templates/search"));
    }

    public Response getAllTemplates() {
        return get(Map.of("realm", appName), getUrl("/config/templates"));
    }

    // ********************** Fields ************************
    public Response getFieldsSearch(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/config/fields"));
    }

    public Response getAttributeFields() {
        return get(Map.of("realm", appName), getUrl("/config/fields/attributes"));
    }

    public Response deleteFields(String id) {
        return delete(Map.of("realm", appName), getUrl("/config/fields/" + id));
    }

    // ********************  Attributes  ************************
    public Response getAttribute(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/attributes"));
    }

    public Response getAttributeFlattened(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/attributes/flattened"));
    }

    public Response getAttributeById(String id) {
        return get(Map.of("realm", appName), "/attributes/" + id);
    }

    // ************************ Modules **********************
    public Response getModules(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/modules"));
    }

    public Response getAllModules() {
        return get(Map.of("realm", appName), getUrl("/modules/all"));
    }

    public Response getModulesById(String id) {
        return get(Map.of("realm", appName), getUrl("/modules/" + id));
    }

    // ************************* Pages ***********************
    public Response getPages(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/pages"));
    }

    public Response getAllPages() {
        return get(Map.of("realm", appName), getUrl("/pages/all"));
    }

    public Response getPagesById(String id) {
        return get(Map.of("realm", appName), getUrl("/pages/" + id));
    }

    public Response getPagesByAdapterKey(String adapterKey) {
        return get(Map.of("realm", appName), getUrl("/pages/adapter/" + adapterKey));
    }

    public Response getPagesByKey(String key) {
        return get(Map.of("realm", appName), getUrl("/pages/key/" + key));
    }

    // ********************** Section *************************
    public Response getSectionVariants(String Key) {
        return get(Map.of("realm", appName), getUrl("/sections/variants/" + Key));
    }

    public Response getSections(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/sections"));
    }

    // *********************** Segment ************************
    public Response getDefaultSegments() {
        return get(Map.of("realm", appName), getUrl("/segments/default"));
    }

    public Response getSegmentById(String id) {
        return get(Map.of("realm", appName), getUrl("/segments/" + id));
    }

    public Response deleteSegmentById(String id) {
        return delete(Map.of("realm", appName), getUrl("/segments/" + id));
    }

    public Response getSegments(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/segments"));
    }


    // ********************* config *************************
    public Response getClients(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/config/clients"));
//        return baseApiUrl("baseApiUrl").queryParams(query).get(ORIGAMI_CRUD + "/config/clients");
    }

}
