package stepDefinition.api;

import factory.CreateAudiencePayloadFactory;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.request.clm.CreateAudienceRequest;
import model.response.clm.partner.PartnerInfoItem;
import model.response.clm.partner.PartnerInfoResponse;
import model.response.clm.tag.TagCatalogItem;
import model.response.clm.tag.TagCatalogResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.ObjectUtils;
import services.clm.AudienceManagerService;
import utilities.BaseAssertion;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static helpers.ApiHelper.parseResponse;
import static helpers.ApiHelper.parseToJson;
import static net.serenitybdd.core.Serenity.*;

public class AudienceManager extends BaseAssertion {

    @Steps
    AudienceManagerService audienceService;

    private PartnerInfoResponse partnerInfo;
    private List<String> audienceTags;
    private Response createAudienceResponse;
    private CreateAudienceRequest createAudienceRequest;

    @When("Hit audience manager info API and validate response has partners")
    public void hitAudienceManagerInfoApiAndValidateResponseHasPartners() {
        Response partnerInfoResponse = audienceService.getPartnerInfo(true);
        Serenity.recordReportData().withTitle("Partner info response")
                .andContents(partnerInfoResponse.asString());

        partnerInfo = parseResponse(partnerInfoResponse, PartnerInfoResponse.class);
        assertFalse(ObjectUtils.isEmpty(partnerInfo.getData()), "Partner info data is null/empty");
        assertFalse(ObjectUtils.isEmpty(partnerInfo.getData().getPartnerInfo()), "partnerInfo list is null/empty");
    }

    @When("Hit tag catalog API and fetch audience tags")
    public void hitTagCatalogApiAndFetchAudienceTags() {
        Response tagCatalogResponse = audienceService.getTagCatalog(true);
        Serenity.recordReportData().withTitle("Tag catalog response")
                .andContents(tagCatalogResponse.asString());

        TagCatalogResponse tagCatalog = parseResponse(tagCatalogResponse, TagCatalogResponse.class);
        assertFalse(ObjectUtils.isEmpty(tagCatalog.getData()), "Tag catalog data is null/empty");
        assertFalse(ObjectUtils.isEmpty(tagCatalog.getData().getTags()), "Tag catalog tags list is null/empty");

        audienceTags = tagCatalog.getData().getTags().stream()
                .map(TagCatalogItem::getKey)
                .filter(key -> key != null && !key.isBlank())
                .limit(2)
                .collect(Collectors.toList());

        assertFalse(ObjectUtils.isEmpty(audienceTags), "No valid tags found in tag catalog");
        Serenity.recordReportData().withTitle("Tags selected for create audience")
                .andContents(audienceTags.toString());
    }

    @When("Create audience with partner key {string} and validate audience is created successfully")
    public void createAudienceWithPartnerKeyAndValidate(String partnerKey) {
        PartnerInfoItem sourcePartner = partnerInfo.getData().getPartnerInfo().stream()
                .filter(item -> partnerKey.equalsIgnoreCase(item.getPartnerKey()))
                .findFirst()
                .orElse(null);

        assertNotNull(sourcePartner, "Partner key not found in partner info: " + partnerKey);

        createAudienceRequest = CreateAudiencePayloadFactory.buildRequest(sourcePartner, audienceTags);
        String requestBody = parseToJson(createAudienceRequest);
        Map<String, String> query = CreateAudiencePayloadFactory.saveQueryParams();

        Serenity.recordReportData().withTitle("Create audience request").andContents(requestBody);
        Serenity.recordReportData().withTitle("Partner object id used")
                .andContents(partnerKey + "=" + sourcePartner.getId());

        createAudienceResponse = audienceService.createAudience(requestBody, query, true);
        Serenity.recordReportData().withTitle("Create audience response")
                .andContents(createAudienceResponse.asString());
        assertResponseContains(createAudienceResponse, createAudienceRequest.getName());
    }
}
