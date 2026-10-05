Feature: Xstream Autostatic & Merged Collection Ranking Strategies Validation

  Dominant Language: "click_persona_dominant_lang" or "xstream__dominant_language__daily" or "dth_dominant_language_name"
  Significant Language: "click_persona_significant_lang" or "xstream__significant_language__daily" or "dth_significant_language_names"
  Consumed Language: "Dominant Language" and "Significant Language"
  User Selected Language: live_attribute "languages"
  User Language: "Consumed Language" and "User Selected Language"

# GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK
  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK strategy
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                      |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK |
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
    Then Verify content list is ordered in RR by consume language and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK strategy when user has no Dominant language
    Given We are using "FdPTwN400Ax9YLEYD0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                      |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK |
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
    Then Verify preffered language content should be in front and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK strategy when user has no Significat language
    Given We are using "FdPTwN400Ax9YLEYD0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                      |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK |
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
    Then Verify preffered language content should be in front and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK strategy when user has no consumed language
    Given We are using "FdPTwN400Ax9YLEYD0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                      |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_CLICK |
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


# GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK
  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK strategy
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK |
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
    Then Verify content list is ordered in RR by user language and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK when user has no consumed language
    Given We are using "c7ldIVLufqFw3g8Gc0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,pa     |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK when user has no user Dominant language
    Given We are using "akYuW0jsLiB_2t9Qq0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK when user has no user selected language
    Given We are using "NNAuVDROHTxgy-mWW0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK when user has no user selected language and significant language
    Given We are using "c7ldIVLufqFw3g8Gc0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi        |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK when user has no user selected language and consumed language
    Given We are using "l8a0ZBd13UbdrvRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK strategy


# GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE
  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy
    Given We are using "l8a0ZBd13UbdrvRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                                             |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy when user has no consumed language
    Given We are using "c7ldIVLufqFw3g8Gc0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,pa     |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                                             |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy when user has no User selected language
    Given We are using "NNAuVDROHTxgy-mWW0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |      |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                                             |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy when user has no User selected language and no significant language
    Given We are using "c7ldIVLufqFw3g8Gc0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |         |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                                             |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy when user has no consumed language and no User selected language
    Given We are using "l8a0ZBd13UbdrvRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                                             |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy

# CONTENT_POPULARITY_CLICK - Sorting on the basis of long_term_rank_30_days_c in asc order
  Scenario: Verify CONTENT_POPULARITY_CLICK strategy
    Given We are using "l8a0ZBd13UbdrvRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | HOTSTAR_DTH_MOVIE_1271446366                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                 |
      | true                | CONTENT_POPULARITY_CLICK |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for CONTENT_POPULARITY_CLICK strategy