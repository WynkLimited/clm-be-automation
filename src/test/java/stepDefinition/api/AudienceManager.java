package stepDefinition.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.response.clm.partner.PartnerInfoItem;
import model.response.clm.partner.PartnerInfoResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import services.clm.AudienceManagerService;

import java.util.List;
import java.util.stream.Collectors;

import static helpers.ApiHelper.parseResponse;


public class AudienceManager {

    @Steps
    AudienceManagerService audienceService;

    private PartnerInfoResponse partnerInfo;

    @When("Hit audience manager info API")
    public void hitAudienceManagerInfoApi() {
        Response partnerInfoResponse = audienceService.getPartnerInfo();
        Serenity.recordReportData().withTitle("Partner info response")
                .andContents(partnerInfoResponse.asString());

        Assert.assertEquals(
                "Partner info API failed. body=" + partnerInfoResponse.asString(),
                200,
                partnerInfoResponse.getStatusCode()
        );

        partnerInfo = parseResponse(partnerInfoResponse, PartnerInfoResponse.class);
        Assert.assertNotNull("Partner info response data is null", partnerInfo.getData());
        Assert.assertNotNull("partnerInfo list is null", partnerInfo.getData().getPartnerInfo());
        Assert.assertFalse("partnerInfo list is empty", partnerInfo.getData().getPartnerInfo().isEmpty());

        String ids = partnerInfo.getData().getPartnerInfo().stream()
                .map(item -> item.getPartnerKey() + "=" + item.getId())
                .collect(Collectors.joining(", "));
        Serenity.recordReportData().withTitle("Partner IDs from info API").andContents(ids);
    }

    @Then("Validate audience manager info response has partners")
    public void validateAudienceManagerInfoResponseHasPartners() {
        Assert.assertNotNull("Hit partner info API first", partnerInfo);
        List<PartnerInfoItem> partners = partnerInfo.getData().getPartnerInfo();

        for (PartnerInfoItem partner : partners) {
            Assert.assertNotNull("partner id is null for " + partner.getPartnerKey(), partner.getId());
            Assert.assertFalse("partner id is blank for " + partner.getPartnerKey(), partner.getId().isBlank());
            Assert.assertNotNull("partnerKey is null", partner.getPartnerKey());
            Assert.assertFalse("partnerKey is blank", partner.getPartnerKey().isBlank());
            Assert.assertNotNull("displayName is null for " + partner.getPartnerKey(), partner.getDisplayName());
            Assert.assertNotNull("deliveryMechanism is null for " + partner.getPartnerKey(), partner.getDeliveryMechanism());
            Assert.assertFalse("deliveryMechanism is empty for " + partner.getPartnerKey(),
                    partner.getDeliveryMechanism().isEmpty());
        }
    }

    @Then("Validate audience manager info contains partner key {string}")
    public void validateAudienceManagerInfoContainsPartnerKey(String partnerKey) {
        Assert.assertNotNull("Hit partner info API first", partnerInfo);
        boolean found = partnerInfo.getData().getPartnerInfo().stream()
                .anyMatch(item -> partnerKey.equalsIgnoreCase(item.getPartnerKey()));
        Assert.assertTrue(
                "Expected partnerKey=" + partnerKey + " in response. Actual="
                        + partnerInfo.getData().getPartnerInfo().stream()
                        .map(PartnerInfoItem::getPartnerKey)
                        .collect(Collectors.toList()),
                found
        );
    }
}
