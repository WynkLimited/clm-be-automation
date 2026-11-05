package stepDefinition.api;

import com.airtel.helper.data.JsonParser;
import com.airtel.helper.report.ChainTestUtil;
import com.aventstack.chaintest.plugins.ChainTestListener;

import constants.TokenConstants;
import factory.CreateAudiencePayloadFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.request.clm.CreateAudienceRequest;
import model.response.clm.partner.PartnerInfoItem;
import model.response.clm.partner.PartnerInfoResponse;
import model.response.clm.tag.TagCatalogItem;
import model.response.clm.tag.TagCatalogResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.bson.Document;
import services.clm.AudienceManagerService;
import utilities.BaseAssertion;
import utilities.JwtTokenUtil;
import utilities.TestSession;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AudienceManager extends BaseAssertion {

    private final JsonParser jsonParser = new JsonParser();
    private final AudienceManagerService audienceService = new AudienceManagerService();

    private PartnerInfoResponse partnerInfo;
    private List<String> audienceTags;
    private Response createAudienceResponse;
    private CreateAudienceRequest createAudienceRequest;

    @Given("Generate JWT auth token for CLM APIs")
    public void generateJwtAuthTokenForClmApis() {
        String token = JwtTokenUtil.createToken();
        assertFalse(ObjectUtils.isEmpty(token), "Generated JWT token is null/empty");
        TestSession.set(TokenConstants.AUTH_TOKEN_SESSION_KEY, token);
        ChainTestUtil.log("JWT auth token generated for CLM API calls");
       
    }

    @When("Hit audience manager info API and validate response has partners")
    public void hitAudienceManagerInfoApiAndValidateResponseHasPartners() {
        Response partnerInfoResponse = audienceService.getPartnerInfo(true);

        partnerInfo = jsonParser.convertFromJson(partnerInfoResponse.asString(), PartnerInfoResponse.class);
        assertFalse(ObjectUtils.isEmpty(partnerInfo.getData()), "Partner info data is null/empty");
        assertFalse(ObjectUtils.isEmpty(partnerInfo.getData().getPartnerInfo()), "partnerInfo list is null/empty");
    }

    @When("Hit tag catalog API and fetch audience tags")
    public void hitTagCatalogApiAndFetchAudienceTags() {
        Response tagCatalogResponse = audienceService.getTagCatalog(true);

        TagCatalogResponse tagCatalog = jsonParser.convertFromJson(tagCatalogResponse.asString(), TagCatalogResponse.class);
        assertFalse(ObjectUtils.isEmpty(tagCatalog.getData()), "Tag catalog data is null/empty");
        assertFalse(ObjectUtils.isEmpty(tagCatalog.getData().getTags()), "Tag catalog tags list is null/empty");

        audienceTags = tagCatalog.getData().getTags().stream()
                .map(TagCatalogItem::getKey)
                .filter(key -> key != null && !key.isBlank())
                .limit(2)
                .collect(Collectors.toList());

        assertFalse(ObjectUtils.isEmpty(audienceTags), "No valid tags found in tag catalog");
        ChainTestUtil.log("Tags selected for create audience: " + audienceTags);
    }

    @When("Create audience with partner key {string} and validate audience is created successfully")
    public void createAudienceWithPartnerKeyAndValidate(String partnerKey) {
        PartnerInfoItem sourcePartner = partnerInfo.getData().getPartnerInfo().stream()
                .filter(item -> partnerKey.equalsIgnoreCase(item.getPartnerKey()))
                .findFirst()
                .orElse(null);

        assertNotNull(sourcePartner, "Partner key not found in partner info: " + partnerKey);

        createAudienceRequest = CreateAudiencePayloadFactory.buildRequest(sourcePartner, audienceTags);
        String requestBody = jsonParser.convertToJson(createAudienceRequest);
        Map<String, String> query = CreateAudiencePayloadFactory.saveQueryParams();

        ChainTestUtil.log("Partner object id used: " + partnerKey + "=" + sourcePartner.getId());

        createAudienceResponse = audienceService.createAudience(requestBody, query, true);

        assertResponseContains(createAudienceResponse, createAudienceRequest.getName());
    }

    @Then("Validate created audience exists in Mongo")
    public void validateCreatedAudienceExistsInMongo() {
        assertNotNull(createAudienceResponse, "Create audience response is null; create step must run first");
        String audienceId = createAudienceResponse.jsonPath().getString("data.id");
        String audienceName = createAudienceResponse.jsonPath().getString("data.name");
        assertFalse(ObjectUtils.isEmpty(audienceId), "Create audience response missing data.id");

        Document mongoDoc = audienceService.validateCreatedAudienceInMongo(audienceId, audienceName);
        assertNotNull(mongoDoc, "Audience Mongo document is null");
    }
}
