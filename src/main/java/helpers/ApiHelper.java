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

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public Logger log = LoggerFactory.getLogger(ApiHelper.class);
    private static final Config conf = ConfigLoader.load();


    public static final String appName = conf.getString("appName");
    private static String auth = conf.getString("auth");
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

    public static void setAuth(String auth){
        ApiHelper.auth = auth;
    }

    public static String getAuth(){
        return ApiHelper.auth ;
    }

    public static String getCollectionUrls(String urlKey){
        return conf.getString(urlKey);
    }
}