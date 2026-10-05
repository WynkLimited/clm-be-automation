package services.discovery;

import io.restassured.response.Response;
import utilities.BaseServiceClient;

import java.util.Map;

public class OrigamiService extends BaseServiceClient {
    public Response getDiscoveryOrigamiLayoutDebug(String page, Map<String,String> params) {
        return get(params,"/origami-service/v1/layout/debug/"+page);
    }

    public Response getDiscoveryOrigamiLayout(String page, Map<String,String> params) {
        return get(params, "/origami-service/v1/layout/"+page);
//        return baseApiUrl("baseApiUrl").queryParams(params).get("/origami-service/v1/layout/"+page);
    }
}
