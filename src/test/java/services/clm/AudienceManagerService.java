package services.clm;

import constants.TokenConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import stepDefinition.api.ApiEndpoints;
import utilities.BaseServiceClient;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AudienceManagerService extends BaseServiceClient implements ApiEndpoints {

    private List<Header> authHeaders() {
        String token = Serenity.sessionVariableCalled(TokenConstants.AUTH_TOKEN_SESSION_KEY);
        if (token == null || token.isBlank()) {
            throw new IllegalStateException(
                    "JWT auth token not found in session. Run 'Generate JWT auth token for CLM APIs' first.");
        }
        return Arrays.asList(new Header("Authorization", "Bearer " + token));
    }

    public Response getPartnerInfo(boolean checkStatus) {
        return get(BASE_URL, null, PARTNER_INFO_ENDPOINT, authHeaders(), ContentType.JSON, checkStatus);
    }

    public Response getTagCatalog(boolean checkStatus) {
        Map<String, String> query = Map.of("scope", "AUDIENCE_CATALOG");
        return get(BASE_URL, query, TAG_CATALOG_LIST_ENDPOINT, authHeaders(), ContentType.JSON, checkStatus);
    }

    public Response createAudience(String body, Map<String, String> queryParams, boolean checkStatus) {
        Response response = patch(BASE_URL, queryParams, authHeaders(), body, ContentType.JSON, AUDIENCE_SAVE_ENDPOINT, checkStatus);
        System.out.println("response: " + response.getBody().asString());
        return response;
    }
}
