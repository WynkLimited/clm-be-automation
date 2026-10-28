Feature: WireMock POST stub smoke check
  Create a POST stub via WiremockHelper and verify the mock server returns the stubbed response.

  @wiremock
  Scenario: Create and verify WireMock POST mock is working
    When Create WireMock POST stub for clm ping API
    When Hit the mocked WireMock POST clm ping API
    Then Validate mocked WireMock POST response is successful
    Then Delete the WireMock POST stub
