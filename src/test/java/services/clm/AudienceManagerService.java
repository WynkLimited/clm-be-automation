package services.clm;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import stepDefinition.api.ApiEndpoints;
import utilities.BaseServiceClient;

import java.util.Map;

public class AudienceManagerService  extends BaseServiceClient  implements ApiEndpoints{



    private Headers partnerHeaders() {
        return new Headers(
                new Header("Authorization", "Bearer " + getCollectionUrls("uclmAuth")),
                new Header("Accept", "application/json"),
                new Header("Content-Type", "application/json")
        );
    }

    public Response getPartnerInfo() {
        return get("", null, PARTNER_INFO_ENDPOINT, partnerHeaders());
    }
}
