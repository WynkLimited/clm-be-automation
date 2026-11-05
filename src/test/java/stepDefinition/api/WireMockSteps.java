package stepDefinition.api;

import com.airtel.helper.exception.GenericException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.commons.lang3.ObjectUtils;
import services.common.WireMockService;
import utilities.BaseAssertion;

public class WireMockSteps extends BaseAssertion {

    private static final String MOCK_RESPONSE_BODY =
            "{\"status\":\"OK\",\"message\":\"wiremock post mock working\",\"source\":\"clm-be-automation\"}";

    private static final String MOCK_REQUEST_BODY =
            "{\"ping\":\"true\",\"from\":\"clm-be-automation\"}";

    private final WireMockService wireMockService = new WireMockService();

    private String stubId;
    private Response mockedPostResponse;

    @When("Create WireMock POST stub for clm ping API")
    public void createWireMockPostStubForClmPingApi() throws GenericException {
        stubId = wireMockService.createPostPingStub(MOCK_RESPONSE_BODY);
        assertFalse(ObjectUtils.isEmpty(stubId), "WireMock stub id is null/empty - stub was not created");
    }

    @When("Hit the mocked WireMock POST clm ping API")
    public void hitTheMockedWireMockPostClmPingApi() throws GenericException {
        mockedPostResponse = wireMockService.hitMockedPostPing(MOCK_REQUEST_BODY);
    }

    @Then("Validate mocked WireMock POST response is successful")
    public void validateMockedWireMockPostResponseIsSuccessful() {
        assertNotNull(mockedPostResponse, "Mocked POST was not called");
        assertStatusCode(mockedPostResponse, 200);
        assertResponseContains(mockedPostResponse, "wiremock post mock working");
        assertResponseContains(mockedPostResponse, "\"status\":\"OK\"");
    }

    @Then("Delete the WireMock POST stub")
    public void deleteTheWireMockPostStub() throws GenericException {
        wireMockService.deleteStub(stubId);
    }
}
