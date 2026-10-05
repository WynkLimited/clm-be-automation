package services.discovery;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import model.Common.arsenalCollection.ArsenalCollection;
import services.discovery.endpoints.DownstreamEndpoint;
import utilities.BaseServiceClient;
import utilities.Utils;

import java.util.HashMap;
import java.util.Map;

public class DownStreamService extends BaseServiceClient {
    static String aut = getEnv().equalsIgnoreCase("prod") ? "discovery\n" : "discovery";
    private static final Headers discoveryHeader = new Headers(

            new Header("Authorization","Basic "+Utils.generateAuth(aut,aut)),
            new Header("content-type", "application/json"),
            new Header("Accept", "*/*")
    );

    private Map<String, String> prepareQuery(Map<String, String> query) {
        Map<String, String> updatedQuery = new HashMap<>(query);
        updatedQuery.put("debug", "true");
        updatedQuery.put("realm", appName);
        return updatedQuery;
    }

    public Response applyDownStreamApi(ArsenalCollection request, Map<String, String> query, DownstreamEndpoint endPoint) {
        return post(
                prepareQuery(query),
                parseToJson(request),
                endPoint.path(),
                discoveryHeader
        );
    }

    public Response applyUserContent(ArsenalCollection request, Map<String, String> query) {
        return post(
                prepareQuery(query),
                parseToJson(request),
                "/user-content/v1/content"
        );
    }

    public Response getUserOnboardingDetails(Map<String, String> query) {
        return get(
                prepareQuery(query),
                "/user-content/v1/user/xstream/onboarding/details"
        );
    }
}
