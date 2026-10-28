package stepDefinition.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.ObjectUtils;
import services.common.WireMockService;
import utilities.BaseAssertion;

public class WireMockSteps extends BaseAssertion {

    private static final String MOCK_RESPONSE_BODY =
            "{\"status\":\"OK\",\"message\":\"wiremock post mock working\",\"source\":\"clm-be-automation\"}";

    private static final String MOCK_REQUEST_BODY =
            "{\"ping\":\"true\",\"from\":\"clm-be-automation\"}";

    @Steps
    WireMockService wireMockService;

    private String stubId;
    private Response mockedPostResponse;

    @When("Create WireMock POST stub for clm ping API")
    public void createWireMockPostStubForClmPingApi() {
        stubId = wireMockService.createPostPingStub(MOCK_RESPONSE_BODY);
        assertFalse(ObjectUtils.isEmpty(stubId), "WireMock stub id is null/empty - stub was not created");
        Serenity.recordReportData().withTitle("WireMock stub created")
                .andContents("stubId=" + stubId
                        + "\nbaseUrl=" + wireMockService.wiremockBaseUrl()
                        + "\npath=" + WireMockService.MOCK_POST_PATH
                        + "\nexpectedResponse=" + MOCK_RESPONSE_BODY);
    }

    @When("Hit the mocked WireMock POST clm ping API")
    public void hitTheMockedWireMockPostClmPingApi() {
        mockedPostResponse = wireMockService.hitMockedPostPing(MOCK_REQUEST_BODY);
        Serenity.recordReportData().withTitle("Mocked POST response")
                .andContents(mockedPostResponse.asString());
    }

    @Then("Validate mocked WireMock POST response is successful")
    public void validateMockedWireMockPostResponseIsSuccessful() {
        assertNotNull(mockedPostResponse, "Mocked POST was not called");
        assertStatusCode(mockedPostResponse, 200);
        assertResponseContains(mockedPostResponse, "wiremock post mock working");
        assertResponseContains(mockedPostResponse, "\"status\":\"OK\"");
    }

    @Then("Delete the WireMock POST stub")
    public void deleteTheWireMockPostStub() {
        wireMockService.deleteStub(stubId);
        Serenity.recordReportData().withTitle("WireMock stub deleted")
                .andContents("stubId=" + stubId);
    }
}
