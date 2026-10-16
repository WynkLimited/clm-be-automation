Feature: CLM Audience Manager Info API
  Validate audience-admin partner info and create audience APIs.

  Background:
    Given Generate JWT auth token for CLM APIs

  @clm
  Scenario: Create audience with CLM_PULL partner from partner info
    When Hit audience manager info API and validate response has partners
    When Hit tag catalog API and fetch audience tags
    When Create audience with partner key "CLM_PULL" and validate audience is created successfully
