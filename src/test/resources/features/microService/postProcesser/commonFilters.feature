Feature: Filters use to get filtered content
  We use filters to filter content on different basis like cp, subscription, adultContent etc.

#  input_filter_type
#  filter_subscriptionBannerBoosting
#  filter_minimum_daily_user
#  filter_maximum_daily_user

#  filter_maximum_popularity
#  filter_minimum_popularity
#  input_filter_sportsContent

#  input_filter_maxContentLimit
#  filter_reduceToParent
#  filter_insightSorting
#  filter_description
#  filter_new_episodes_released_in_window
#  filter_upcomingTrailer
#  filter_parentGenres

#  filter_ageRating
#  filter_upsellSubscription
#  filter_minContentLanguageStrategyScore
#  filter_minContentDefaultStrategyScore
#  filter_minimum_maxPopularity
#  filter_maximum_maxPopularity

#  filter_recent
#  filter_onboarding_day_range

  Scenario: Verify included adultContent filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_adultContent |
      | true                |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_adultContent" should be "included" in the response

  Scenario: Verify exclude adultContent filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_adultContent |
      | true                        |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_adultContent" should be "excluded" in the response

  Scenario: Verify exclude adultContent filter is false then all content should be same in response
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_adultContent |
      | false                       |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify included sportsContent filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_sportsContent |
      | true                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_sportsContent" should be "included" in the response

  Scenario: Verify exclude sportsContent filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_sportsContent |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_sportsContent" should be "excluded" in the response

  Scenario: Verify exclude sportsContent filter is false then all content should be same in response
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_sportsContent |
      | false                        |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify included type filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_type |
      | movie       |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_type" whose value is "movie" should be "included" in the response

  Scenario: Verify exclude type filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_type |
      | movie               |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_type" whose value is "movie" should be "excluded" in the response

  Scenario: Verify included cpId filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_cpId  |
      | AMAZON_PRIME |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_cpId" whose value is "AMAZON_PRIME" should be "included" in the response

  Scenario: Verify exclude cpId filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_cpId |
      | AMAZON_PRIME        |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_cpId" whose value is "AMAZON_PRIME" should be "excluded" in the response

  Scenario: Verify included genres filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_genres |
      | Drama         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_genres" whose value is "Drama" should be "included" in the response

  Scenario: Verify exclude genres filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_genres |
      | Drama                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_genres" whose value is "Drama" should be "excluded" in the response

  Scenario: Verify included allGenres filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_allGenres |
      | Drama            |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_allGenres" whose value is "Drama" should be "included" in the response

  Scenario: Verify exclude allGenres filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_allGenres |
      | Drama                    |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_allGenres" whose value is "Drama" should be "excluded" in the response

  Scenario: Verify included downloadable filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_downloadable |
      | true                |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_downloadable" whose value is "true" should be "included" in the response

  Scenario: Verify exclude downloadable filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_downloadable |
      | true                        |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_downloadable" whose value is "true" should be "excluded" in the response

  Scenario: Verify included state filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_state |
      | LIVE         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_state" whose value is "LIVE" should be "included" in the response

  Scenario: Verify exclude state filter working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_state |
      | LIVE                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_state" whose value is "LIVE" should be "excluded" in the response

  Scenario: Verify include state filter DOWN working as included
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_state |
      | DOWN         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_state" whose value is "DOWN" should be "included" in the response

  Scenario: Verify include state filter DOWN working as expected
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | exclude_filter_state |
      | DOWN                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all "_state" whose value is "DOWN" should be "excluded" in the response


  Scenario: Verify content recent filter working to filter content based on recency of content
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with params
      | filter_recent |
      | 1             |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to arsenal collection request with
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | SONYLIV_VOD_LIVE_SPORT_1090487553                                     | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | SONYLIV_VOD_LIVE_SPORT_1090487467                                     | 8        |
    And fetch response for postprocessor request
    Then Verify content should be "include" filter for "adultContent"