Feature: Xstream Autostatic & Merged Collection Ranking Strategies Validation

  Dominant Language: "click_persona_dominant_lang" or "xstream__dominant_language__daily" or "dth_dominant_language_name"
  Significant Language: "click_persona_significant_lang" or "xstream__significant_language__daily" or "dth_significant_language_names"
  Consumed Language: "Dominant Language" and "Significant Language"
  User Selected Language: live_attribute "languages"
  User Language: "Consumed Language" and "User Selected Language"

  Engaged User: If users’ Last_30_days_streamtime >=20 mins

# GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE
  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE strategy when user has no consumed language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE |
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
    Then Verify content list in same order as request

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE strategy when user has no dominant language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE strategy when user has no significant language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE
  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE strategy when user has no consumed language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE strategy when user has no User selected language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE strategy when user has no User selected language and no significant language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE strategy when user has no User selected language and no consumed language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE strategy when user has no User selected language, no consumed language and no onboarding
    Given We are using "158xE6jGDdcdcdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE |
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
    Then Verify content list in same order as request

# CONTENT_POPULARITY
  Scenario: Verify CONTENT_POPULARITY strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | partnerStatus |
      |               |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy           |
      | true                | CONTENT_POPULARITY |
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
    Then Verify content list is ordered by user consume language

# CONTENT_USL_BOOSTING
  Scenario: Verify CONTENT_USL_BOOSTING strategy when USL is hi,en
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy             |
      | true                | CONTENT_USL_BOOSTING |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify CONTENT_USL_BOOSTING strategy when USL only hi
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi        |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy             |
      | true                | CONTENT_USL_BOOSTING |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify CONTENT_USL_BOOSTING strategy when no USL present
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi        |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy             |
      | true                | CONTENT_USL_BOOSTING |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify CONTENT_USL_BOOSTING strategy when no USL and onboarding language present
    Given We are using "158xE6jGdjcfrnDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy             |
      | true                | CONTENT_USL_BOOSTING |
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
    Then Verify content list in same order as request

# CONTENT_RECENCY
  Scenario: Verify CONTENT_RECENCY strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy        |
      | true                | CONTENT_RECENCY |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify CONTENT_RECENCY strategy when all contents are old
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy        |
      | true                | CONTENT_RECENCY |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW (DISCO-2062)
  Scenario: Verify GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                             |
      | true                | GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW strategy when user has no consumed language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                             |
      | true                | GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW strategy when user has no user selected language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                             |
      | true                | GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW strategy when user has no consumed language and user selected language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                             |
      | true                | GROUP_BY_USER_LANG_THEN_FREE_TO_VIEW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED (DISCO-2062)
  Scenario: Verify GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED strategy for free users non engaged
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | partnerStatus |
      |               |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                       |
      | true                | GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED strategy for free users engaged
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | partnerStatus |
      |               |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                       |
      | true                | GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED strategy for non free user
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | partnerStatus                                                             |
      | xstreampremium:claimed,jiohotstar:claimed,netflix:claimed,zeefive:claimed |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                       |
      | true                | GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify firstEpisodeFree should not be the part of free bucket in GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | partnerStatus                                                             |
      | xstreampremium:claimed,jiohotstar:claimed,netflix:claimed,zeefive:claimed |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                       |
      | true                | GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify firstSeasonFree should be the part of free bucket in GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | partnerStatus                                                             |
      | xstreampremium:claimed,jiohotstar:claimed,netflix:claimed,zeefive:claimed |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                       |
      | true                | GROUP_BY_FREE_TO_VIEW_PROMOTE_FREE_FOR_ENGAGED |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY
  Scenario: Verify GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY |
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
    Then Verify content list is ordered in RR by content language and content partner prefferences order

  Scenario: Verify GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY strategy when all contents have same language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY |
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
    Then Verify content list is ordered by content partner prefferences order only

# GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE
  Scenario: Verify GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                            |
      | true                | GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE |
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
    Then Verify content list is ordered in RR by content language and content partner should be shuffelled within same language group

  Scenario: Verify GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE strategy when all contents have same language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                            |
      | true                | GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE |
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
    Then Verify content list is ordered in RR by content language and content partner prefferences order

# GROUP_BY_STRATEGY_SOURCE_THEN_SORT_BY_SCORE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_STRATEGY_SOURCE_THEN_SORT_BY_SCORE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                                  |
      | true                | GROUP_BY_STRATEGY_SOURCE_THEN_SORT_BY_SCORE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_USER_GENRE_AFFINITY
  Scenario: Verify GROUP_BY_USER_GENRE_AFFINITY strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                     |
      | true                | GROUP_BY_USER_GENRE_AFFINITY |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_GENRE_AFFINITY strategy when user has no GENRE AFFINITY
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                     |
      | true                | GROUP_BY_USER_GENRE_AFFINITY |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_GENRE_AFFINITY strategy when user has no GENRE AFFINITY and no onboarding GENRE
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                     |
      | true                | GROUP_BY_USER_GENRE_AFFINITY |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_USER_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE
  Scenario: Verify GROUP_BY_USER_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                            |
      | true                | GROUP_BY_USER_CONTENT_PARTNER_AFFINITY_THEN_SHUFFLE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_USER_CONTENT_PARTNER_WITH_USE_DEFAULT
  Scenario: Verify GROUP_BY_USER_CONTENT_PARTNER_WITH_USE_DEFAULT strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                       |
      | true                | GROUP_BY_USER_CONTENT_PARTNER_WITH_USE_DEFAULT |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_USER_CONTENT_PARTNER_AFFINITY
  Scenario: Verify GROUP_BY_USER_CONTENT_PARTNER_AFFINITY strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                               |
      | true                | GROUP_BY_USER_CONTENT_PARTNER_AFFINITY |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_LANG_UDL_ORDERED_MERGE
  Scenario: Verify GROUP_BY_CONTENT_LANG_UDL_ORDERED_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                |
      | true                | GROUP_BY_CONTENT_LANG_UDL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE
  Scenario: Verify GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                 |
      | true                | GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE strategy when user has no user selected language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                 |
      | true                | GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE strategy when user has no user selected and no boarding language
    Given We are using "158xE6jGDdAyMrkfcjKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                 |
      | true                | GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE |
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
    Then Verify content list in same order as request

# GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT_THEN_USR_SIMPLE_SPORT_AFFINITY_SORT
  Scenario: Verify GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT_THEN_USR_SIMPLE_SPORT_AFFINITY_SORT strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                                                                   |
      | true                | GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT_THEN_USR_SIMPLE_SPORT_AFFINITY_SORT |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT_THEN_USR_PRIORITY_SPORT_AFFINITY_SORT
  Scenario: Verify GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT_THEN_USR_PRIORITY_SPORT_AFFINITY_SORT strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                                                                     |
      | true                | GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT_THEN_USR_PRIORITY_SPORT_AFFINITY_SORT |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_INDIA_NON_INDIA_MATCH_USL_ORDERED_APPEND
  Scenario: Verify GROUP_BY_INDIA_NON_INDIA_MATCH_USL_ORDERED_APPEND strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                          |
      | true                | GROUP_BY_INDIA_NON_INDIA_MATCH_USL_ORDERED_APPEND |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT
  Scenario: Verify GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                               |
      | true                | GROUP_BY_CONTENT_LANG_USL_ORDERED_MERGE_APPEND_DEFAULT |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_LANG_USiL_ORDERED_MERGE
  Scenario: Verify GROUP_BY_CONTENT_LANG_USiL_ORDERED_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |

    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                 |
      | true                | GROUP_BY_CONTENT_LANG_USiL_ORDERED_MERGE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_GENRE_THEN_MERGE
  Scenario: Verify GROUP_BY_GENRE_THEN_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                  |
      | true                | GROUP_BY_GENRE_THEN_MERGE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_LANGUAGE_THEN_MERGE
  Scenario: Verify GROUP_BY_LANGUAGE_THEN_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                     |
      | true                | GROUP_BY_LANGUAGE_THEN_MERGE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_PARTNER_THEN_MERGE
  Scenario: Verify GROUP_BY_PARTNER_THEN_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                    |
      | true                | GROUP_BY_PARTNER_THEN_MERGE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_PARTNER_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_PARTNER_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                    |
      | true                | GROUP_BY_PARTNER_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_ONBOARDING_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_CONTENT_ONBOARDING_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                                      |
      | true                | GROUP_BY_CONTENT_ONBOARDING_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_RELEASE_YEAR_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_RELEASE_YEAR_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                                |
      | true                | GROUP_BY_RELEASE_YEAR_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_RELEASE_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_RELEASE_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                           |
      | true                | GROUP_BY_RELEASE_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_RELEASE_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW strategy when all content are in same release window
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                           |
      | true                | GROUP_BY_RELEASE_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_POPULARITY_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_POPULARITY_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                              |
      | true                | GROUP_BY_POPULARITY_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                          |
      | true                | GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW strategy when user has no consume language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                          |
      | true                | GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW strategy when user has no user selected language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                          |
      | true                | GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW strategy when user has no user selected language and consume language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                          |
      | true                | GROUP_BY_USER_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_CONTENT_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_CONTENT_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                             |
      | true                | GROUP_BY_CONTENT_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

  Scenario: Verify GROUP_BY_CONTENT_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW strategy when all content has same language
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                             |
      | true                | GROUP_BY_CONTENT_LANGUAGE_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_SOURCE_THEN_MERGE
  Scenario: Verify GROUP_BY_SOURCE_THEN_MERGE strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                   |
      | true                | GROUP_BY_SOURCE_THEN_MERGE |
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
    Then Verify content list is ordered by user consume language

# GROUP_BY_SOURCE_THEN_SHUFFLE_WITHIN_WINDOW
  Scenario: Verify GROUP_BY_SOURCE_THEN_SHUFFLE_WITHIN_WINDOW strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                   |
      | true                | GROUP_BY_SOURCE_THEN_SHUFFLE_WITHIN_WINDOW |
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
    Then Verify content list is ordered by user consume language

# USR_SIMPLE_SPORT_GENRE_AFFINITY
  Scenario: Verify USR_SIMPLE_SPORT_GENRE_AFFINITY strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                        |
      | true                | USR_SIMPLE_SPORT_GENRE_AFFINITY |
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
    Then Verify content list is ordered by user consume language

# USR_PRIORITY_SPORT_GENRE_AFFINITY
  Scenario: Verify USR_PRIORITY_SPORT_GENRE_AFFINITY strategy
    Given We are using "158xE6jGDdAyMKtnV0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                          |
      | true                | USR_PRIORITY_SPORT_GENRE_AFFINITY |
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
    Then Verify content list is ordered by user consume language

#  RECOMMENDED_CONTENT_ICL_PRIORITY
  Scenario: Verify RECOMMENDED_CONTENT_ICL_PRIORITY strategy
    Given We are using "NNAuVDROHTxgy-mWW0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | contentId              | languages |
      | HOTSTAR_DTH_MOVIE_3298 | hi,en     |
    And create body for postprocessor request with below content
      | contentId                                                    | position |
      | RAJTV_LIVETVMOVIE_61b09836c29a19d4542d969b_30000000549713267 | 1        |
      | HOTSTAR_DTH_MOVIE_3298                                       | 2        |
      | ZEEFIVE_MOVIE_0-0-1z5895270                                  | 3        |
      | HOTSTAR_DTH_MOVIE_643854                                     | 4        |
      | HOTSTAR_DTH_MOVIE_1971000542                                 | 5        |
      | HOTSTAR_DTH_MATCH_VOD_1970976115                             | 6        |
      | HOTSTAR_DTH_MOVIE_1271446366                                 | 7        |
    When post process request with
      | enableDeduplication | deduplicationMethod | strategy                         |
      | true                | ul_based            | RECOMMENDED_CONTENT_ICL_PRIORITY |
#    When Add content list to arsenal collection request with
#      | contentId                                                    | position |
#      | RAJTV_LIVETVMOVIE_61b09836c29a19d4542d969b_30000000549713267 | 1        |
#      | HOTSTAR_DTH_MOVIE_3298                                       | 2        |
#      | ZEEFIVE_MOVIE_0-0-1z5895270                                  | 3        |
#      | HOTSTAR_DTH_MOVIE_643854                                     | 4        |
#      | HOTSTAR_DTH_MOVIE_1971000542                                 | 5        |
#      | HOTSTAR_DTH_MATCH_VOD_1970976115                             | 6        |
#      | HOTSTAR_DTH_MOVIE_1271446366                                 | 7        |
    And fetch response for postprocessor request
    Then verify content should return on the intersection of input language and output language

    #  RECOMMENDED_CONTENT_ICL_UL_PRIORITY
  Scenario: Verify RECOMMENDED_CONTENT_ICL_UL_PRIORITY strategy
    Given We are using "NNAuVDROHTxgy-mWW0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | contentId                    | languages |
      | HOTSTAR_DTH_MOVIE_1271446366 | hi,en     |
    And create body for postprocessor request with below content
      | contentId                                                    | position |
      | RAJTV_LIVETVMOVIE_61b09836c29a19d4542d969b_30000000549713267 | 1        |
      | HOTSTAR_DTH_MOVIE_3298                                       | 2        |
      | ZEEFIVE_MOVIE_0-0-1z5895270                                  | 3        |
      | HOTSTAR_DTH_MOVIE_643854                                     | 4        |
      | HOTSTAR_DTH_MOVIE_1271446366                                 | 5        |
      | HOTSTAR_DTH_MOVIE_1971000542                                 | 6        |
      | SONYLIV_VOD_EPISODE_1000046844                               | 7        |
    When post process request with
      | enableDeduplication | deduplicationMethod | strategy                            |
      | true                | ul_based            | RECOMMENDED_CONTENT_ICL_UL_PRIORITY |
    And fetch response for postprocessor request
    Then verify content should return on the intersection of input language, output language and UL

    #  RECOMMENDED_CONTENT_UL_PRIORITY
  Scenario: Verify RECOMMENDED_CONTENT_UL_PRIORITY strategy
    Given We are using "NNAuVDROHTxgy-mWW0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | contentId              | languages |
      | HOTSTAR_DTH_MOVIE_3298 | ta        |
    And create body for postprocessor request with below content
      | contentId                                                    | position |
      | RAJTV_LIVETVMOVIE_61b09836c29a19d4542d969b_30000000549713267 | 1        |
      | HUNGAMA_SHORTS_64685055                                      | 2        |
      | ZEEFIVE_MOVIE_0-0-1z5895270                                  | 3        |
      | HOTSTAR_DTH_MOVIE_643854                                     | 4        |
      | HOTSTAR_DTH_MOVIE_1271446366                                 | 5        |
      | HOTSTAR_DTH_MOVIE_1971000542                                 | 6        |
      | HOTSTAR_DTH_MATCH_VOD_1970976115                             | 7        |
    When post process request with
      | enableDeduplication | deduplicationMethod | strategy                        |
      | true                | ul_based            | RECOMMENDED_CONTENT_UL_PRIORITY |
    And fetch response for postprocessor request
    Then verify content should return on the intersection of input output language and UL
