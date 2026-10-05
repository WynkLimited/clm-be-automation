Feature: Subscription Boosting
  Subscription boosting for cold start users based on User Selected Language (USL).

  Scenario: Verify the Cold start user having only USL as hindi with free first episodes
    Given We are using "158xE6jGDdAyMnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi        |
    And create body for postprocessor request with below content
      | contentId                     | position |
      | SONYLIV_VOD_TVSHOW_1700000741 | 1        |
      | HOTSTAR_DTH_TVSHOW_1271631984 | 2        |
      | SONYLIV_VOD_TVSHOW_1700000659 | 3        |
      | HOTSTAR_DTH_TVSHOW_1271643838 | 4        |
    When post process request with
      | enableDeduplication | strategy             |
      | true                | PLAYABILITY_LANGUAGE_RECENCY |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language
