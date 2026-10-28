package services.common;

import com.airtel.helper.common.BaseManager;
import com.typesafe.config.Config;
import config.ConfigLoader;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class WireMockService extends BaseManager {

    public static final String MOCK_POST_PATH = "/mock/clm/ping";

    private final Config conf = ConfigLoader.load();

    public String wiremockBaseUrl() {
        return conf.getString("wiremockUrl");
    }

    /**
     * Creates a WireMock stub for POST /mock/clm/ping using framework WiremockHelper.
     *
     * @return stub uuid/id
     */
    public String createPostPingStub(String responseBodyJson) {
        Map<String, Object> responseHeaders = new HashMap<>();
        responseHeaders.put("Content-Type", "application/json");

        String stubId = createStubMapping(
                wiremockBaseUrl(),
                1,
                null,
                null,
                null,
                MOCK_POST_PATH,
                "POST",
                200,
                responseHeaders,
                responseBodyJson,
                false
        );
        log.info("Created WireMock POST stub | path={} | stubId={}", MOCK_POST_PATH, stubId);
        return stubId;
    }

    /**
     * Hits the mocked POST endpoint on the WireMock server.
     */
    public Response hitMockedPostPing(String requestBodyJson) {
        List<Header> headers = Arrays.asList(new Header("Content-Type", "application/json"));
        String url = wiremockBaseUrl() + MOCK_POST_PATH;
        Response response = postResponseWithHeaders(requestBodyJson, headers, ContentType.JSON, url);
        log.info("Hit mocked POST | url={} | status={} | body={}",
                url, response.getStatusCode(), response.asString());
        return response;
    }

    public void deleteStub(String stubId) {
        if (stubId == null || stubId.isBlank()) {
            return;
        }
        deleteSpecificStubMapping(wiremockBaseUrl(), stubId);
        log.info("Deleted WireMock stub | stubId={}", stubId);
    }
}
