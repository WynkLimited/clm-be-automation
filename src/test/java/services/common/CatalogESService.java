package services.common;

//import io.restassured.response.Response;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import utilities.BaseServiceClient;

public class CatalogESService extends BaseServiceClient {

    private static final Headers elasticHeaders = new Headers(
            new Header("Authorization", "Basic ZWxhc3RpYzpRVWZzOHZhPVV3VmE1Vjd5X1Q1Qg=="),
            new Header("content-type", "application/json"),
            new Header("Accept", "*/*")
    );

    public  Response getMeta(String contentId) {
        return baseApiUrl("elasticSearchUrl", elasticHeaders).get("/prod_atv_playable_content/_doc"+contentId);
    }

    public  Response getContentByQuery(String body) {
        return baseApiUrl("elasticSearchUrl", elasticHeaders).body(body).post("prod_atv_playable_content/_search");
    }


}
