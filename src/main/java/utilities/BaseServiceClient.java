package utilities;

import helpers.ApiHelper;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseServiceClient extends ApiHelper {

    protected static Response get(String baseUrl, Map<String, String> param, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .get(endPoint);
    }


    protected static Response get(Map<String, String> param, String endPoint) {
        return baseApiUrl("baseApiUrl")
                .queryParams(param)
                .get(endPoint);
    }

    protected static Response post(String baseUrl, Map<String, String> param, String body, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    protected static Response post(Map<String, String> param, String body, String endPoint) {
        return baseApiUrl("baseApiUrl")
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    protected static Response post(String body, String endPoint) {
        return baseApiUrl("baseApiUrl")
                .body(body)
                .post(endPoint);
    }

    protected static Response delete(Map<String, String> param, String endPoint) {
        return baseApiUrl("baseApiUrl")
                .queryParams(param)
                .delete(endPoint);
    }

    protected static Response delete(String baseUrl, Map<String, String> param, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .delete(endPoint);
    }

    protected static Response put(String baseUrl, Map<String, String> param, String body, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }

    protected static Response put(Map<String, String> param, String body, String endPoint) {
        return baseApiUrl("baseApiUrl")
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }

    protected static Response get(String baseUrl, Map<String, String> param, String endPoint, Headers headers) {
        return baseApiUrl(baseUrl,headers)
                .queryParams(param)
                .get(endPoint);
    }



    protected static Response get(String baseUrl, Map<String, String> param, String endPoint, List<Header> headers) {

        return baseApiUrl(baseUrl,new Headers(headers))
                .queryParams(param)
                .get(endPoint);
    }


    protected static Response get(Map<String, String> param, String endPoint, Headers headers) {
        return baseApiUrl("baseApiUrl",headers)
                .queryParams(param)
                .get(endPoint);
    }

    protected static Response post(String baseUrl, Map<String, String> param, String body, String endPoint, Headers headers) {
        return baseApiUrl(baseUrl,headers)
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    protected static Response post(Map<String, String> param, String body, String endPoint, Headers headers) {
        return baseApiUrl("baseApiUrl",headers)
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    protected static Response post(String body, String endPoint, Headers headers) {
        return baseApiUrl("baseApiUrl",headers)
                .body(body)
                .post(endPoint);
    }

    protected static Response delete(Map<String, String> param, String endPoint, Headers headers) {
        return baseApiUrl("baseApiUrl",headers)
                .queryParams(param)
                .delete(endPoint);
    }

    protected static Response delete(String baseUrl, Map<String, String> param, String endPoint, Headers headers) {
        return baseApiUrl(baseUrl,headers)
                .queryParams(param)
                .delete(endPoint);
    }

    protected static Response put(String baseUrl, Map<String, String> param, String body, String endPoint, Headers headers) {
        return baseApiUrl(baseUrl,headers)
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }

    protected static Response put(Map<String, String> param, String body, String endPoint, Headers header) {
        return baseApiUrl("baseApiUrl",header)
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }

    public static String getEnv() {
        return ApiHelper.getEnv();
    }
}
