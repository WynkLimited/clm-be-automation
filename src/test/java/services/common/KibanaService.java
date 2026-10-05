package services.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Header;
import io.restassured.http.Headers;


import io.restassured.response.Response;
import org.junit.Assert;
import utilities.BaseServiceClient;

import java.util.List;
import java.util.stream.Collectors;

public class KibanaService extends BaseServiceClient {

    JsonNode contentMetaList;
    ObjectMapper mapper = new ObjectMapper();

    private static final Headers kibanaHeaders = new Headers(
            new Header("kbn-version", "7.1.1"),
            new Header("authority", "catalog-kibana.wynk.in"),
            new Header("accept", "text/plain, */*; q=0.01"),
            new Header("accept-encoding", "gzip, deflate, br"),
            new Header("content-type", "application/json"),
            new Header("accept-encoding", "gzip, deflate, br"),
            new Header("accept-encoding", "gzip, deflate, br")
    );

    private static final Headers headers = new Headers(
            new Header("Content-Type", "application/json"),
            new Header("accept", "*/*")
    );

    private String getJsonBody(String uid) {
        return "{"
                + "\"size\":20,"
                + "\"query\":{"
                + "\"bool\":{"
                + "\"must\":["
                + "{\"term\":{\"transactionName.keyword\":\"origamiRequest\"}},"
                + "{\"term\":{\"uid.keyword\":\"" + uid + "\"}},"
                + "{\"term\":{\"pageId.keyword\":\"homepage2\"}}"
                + "]"
                + "}"
                + "},"
                + "\"_source\":["
                + "\"startTime\",\"endTime\",\"@timestamp\",\"pageId\",\"uid\",\"transactionName\",\"message\",\"origamiRequest\""
                + "],"
                + "\"sort\":["
                + "{\"@timestamp\":{\"order\":\"desc\"}}"
                + "]"
                + "}";
    }

    public static String getJsonBodyForContentList(List<String> contentIds) {

        String ids = contentIds.stream()
                .map(id -> "\"" + id + "\"")
                .collect(Collectors.joining(",\n"));

        return """
        {
          "size": 50,
          "query": {
            "bool": {
              "must": [
                {
                  "terms": {
                    "_id": [
                      %s
                    ]
                  }
                }
              ]
            }
          }
        }
        """.formatted(ids);
    }


    public Response getUserLogs(String arg0) {
        return baseApiUrl("logstashUrl", headers)
                .header("Authorization", "Basic ZGV2LWRlYnVnOklQMW9uRHQ3MDNLZA==")
                .body(getJsonBody(arg0)).post("/atv-package-layout-service-prd-logstash-*/_search");
    }


    public Response getContentMeta(String contentId) {
        return baseApiUrl("catalogElastic", headers).auth()
                .preemptive()
                .basic("elastic", "QUfs8va=UwVa5V7y_T5B")
                .get("/prod_atv_playable_content/_doc/"+contentId);
    }

    public Response getContentsMeta(List<String> contentIds) {
        return baseApiUrl("catalogElastic", headers).auth()
                .preemptive()
                .basic("elastic", "QUfs8va=UwVa5V7y_T5B")
                .body(getJsonBodyForContentList(contentIds))
                .post("/prod_atv_playable_content/_search");
    }

    public JsonNode getContentMetaList(List<String> contentIds) throws JsonProcessingException {
        Response response4 = getContentsMeta(contentIds);
        Assert.assertEquals(200, response4.getStatusCode());
        contentMetaList = mapper.readTree(response4.getBody().asString());

        return contentMetaList.get("hits").get("hits");
    }
}
