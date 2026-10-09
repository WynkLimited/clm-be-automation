package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.typesafe.config.Config;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import config.ConfigLoader;

import java.net.URI;
import io.restassured.http.Headers;
import io.restassured.http.ContentType;
import java.util.Map;
import java.util.List;
import constants.RequestType;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Arrays;

public class ApiHelper {

    public Logger log = LoggerFactory.getLogger(ApiHelper.class);
    private static final Config conf = ConfigLoader.load();


    // public static final String appName = conf.getString("appName");
    // private static String auth = conf.getString("auth");
    public static Gson gson;

    private static final Headers defaultHeaders = new Headers(
            new Header("Content-Type", "application/json"),
            new Header("accept", "*/*")
    );

    protected static RequestSpecification baseApiUrl(String baseUrl) {
        return given().baseUri(conf.getString(baseUrl))
                .log().all().headers(defaultHeaders);
    }

    public static String getEnv() {
        return ConfigLoader.getEnv();
    }

    protected static RequestSpecification baseApiUrl(String baseUrl, Headers headers) {
        return given().baseUri(conf.getString(baseUrl))
                .log().all().headers(headers);
    }

    //Specify all one time default Gson config
    private static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    private static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }

    public static <T> T parseResponse(Response response, Class<T> classOfT) {
        return gson().fromJson(response.asString(), classOfT);
    }

    public static <T> T parseResponse(String response, Class<T> classOfT) {
        return gson().fromJson(response, classOfT);
    }

    public static <T> String parseToJson(T object) {
        return gson().toJson(object);
    }

    // public static void setAuth(String auth){
    //     ApiHelper.auth = auth;
    // }

    // public static String getAuth(){
    //     return ApiHelper.auth ;
    // }

    public static String getCollectionUrls(String urlKey){
        return conf.getString(urlKey);
    }

    /**
	 * Generic method to fetch response for different type of API request
	 *
	 * @param requestUrl
	 * @param requestType
	 * @param body
	 * @param queryParams
	 * @param headers
	 * @param checkStatus
	 * @return
	 */
	public Response fetchApiResponse(String requestUrl, String requestType, String body,
        Map<String, String> queryParams, List<Header> headers, ContentType contentType, boolean checkStatus,
        Map<String, String> formParams) {

    
    Response apiResponse = null;
    String requestLog = null;
    String queryParamLog = "";
    RequestSpecification apiRequest = prepareRequestParams(queryParams, headers, body, contentType, formParams);

    requestLog = "Request body: " + body;

    String headerData = "";

    if (headers != null) {
        for (Header h : headers) {
            headerData = headerData + h.getName() + " : " + h.getValue();
        }
    }

    if (queryParams != null) {
        requestLog = requestLog + "Query Params:" + queryParams.toString();
        queryParamLog = queryParams.toString();
    }
    try {
        switch (RequestType.valueOf(requestType.toUpperCase())) {
        case GET:
            apiResponse = apiRequest.get(requestUrl);
            break;
        case POST:
            apiResponse = apiRequest.post(requestUrl);
            break;
        case PUT:
            apiResponse = apiRequest.put(requestUrl);
            break;
        case PATCH:
            apiResponse = apiRequest.patch(requestUrl);
            break;
        case DELETE:
            apiResponse = apiRequest.delete(requestUrl);
            break;
        default:
            apiResponse = apiRequest.head(requestUrl);
            break;
        }
    } catch (Exception e) {
        e.printStackTrace();
      

        return apiResponse;
    }

    long responseTime = apiResponse.getTime();
    String responseBody = apiResponse != null ? apiResponse.asString() : "null";
    int statusCode = apiResponse != null ? apiResponse.getStatusCode() : -1;

    log.info("API response | url={} | type={} | status={} | time={}ms | body={}",
            requestUrl, requestType, statusCode, responseTime, responseBody);
    System.out.println("API response | status=" + statusCode + " | body=" + responseBody);

    List<Integer> SUCCESS_CODE = new ArrayList<>(Arrays.asList(200, 201, 202, 204));
    if (checkStatus && !SUCCESS_CODE.contains(statusCode)) {
        Assert.fail("HTTP status not in 2xx"
                + "\nURL: " + requestUrl
                + "\nMethod: " + requestType
                + "\nExpected: " + SUCCESS_CODE
                + "\nActual: " + statusCode
                + "\nBody: " + responseBody);
    }
    return apiResponse;
}

private RequestSpecification prepareRequestParams(Map<String, String> queryParams, List<Header> headers,
			String body, ContentType contentType, Map<String, String> formParams) {
		RequestSpecification request = RestAssured.given().relaxedHTTPSValidation().redirects().follow(false);
		if (null != queryParams) {
			request.queryParams(queryParams);
		}

		if (null != formParams) {
			request.formParams(formParams);
		}
		if (headers != null)
			request.headers(new Headers(headers));
		if (body != null && !body.isEmpty()) {
			request.body(body);
		}
		if (contentType != null)
			request.contentType(contentType);
		return request;
	}



    protected static Response get(String baseUrl, Map<String, String> param, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .get(endPoint);
    }


    protected Response get(String baseUrl, Map<String, String> param, String endPoint, List<Header> headers, ContentType contentType, boolean checkStatus) {
        String endpointPath = baseUrl + endPoint;
        return fetchApiResponse(endpointPath, RequestType.GET.name(), null, param, headers, contentType, checkStatus, null);
    }

    protected  Response post(String baseUrl, Map<String, String> param, String body, String endPoint,ContentType contentType, boolean checkStatus) {
        String endpointPath = baseUrl + endPoint;
        return fetchApiResponse(endpointPath, RequestType.POST.name(), body, param, null, contentType, checkStatus, null);
    }

    protected  Response patch(String baseUrl, Map<String, String> param, List<Header> headers,String body, ContentType contentType,String endPoint, boolean checkStatus) {
        String endpointPath = baseUrl + endPoint;
        return fetchApiResponse(endpointPath, RequestType.PATCH.name(), body, param, headers, contentType, checkStatus, null);
    }
}