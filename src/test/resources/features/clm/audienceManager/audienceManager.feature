Feature: CLM Audience Manager Info API
  Validate audience-admin partner info endpoint.


@clm
  Scenario : Get partner info and validate partner list
    When Hit audience manager info API
    Then Validate audience manager info response has partners
    And Validate audience manager info contains partner key "CLM_PULL"
    And Validate audience manager info contains partner key "CLM_PUSH"


