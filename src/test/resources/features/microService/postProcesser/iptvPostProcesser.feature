Feature: Xstream Autostatic & Merged Collection Ranking Strategies Validation

  Dominant Language: "dth_dominant_language_name"
  Significant Language: "dth_significant_language_names"
  Consumed Language: "Dominant Language" and "Significant Language"
  User Selected Language: live_attribute "languages"
  User Language: "Consumed Language" and "User Selected Language"

# IPTV specific strategies
  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV strategy
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                    |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV |
    When Add content list to arsenal collection request with
      | contentId                                       | position |
      | HOTSTAR_DTH_MOVIE_1271532249                    | 1        |
      | SONYLIV_VOD_LIVE_SPORT_1090487553               | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368  | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                   | 4        |
      | ZEEFIVE_MOVIE_0-0-1z5917832                     | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                    | 7        |
      | SONYLIV_VOD_LIVE_SPORT_1090487467               | 8        |
    And fetch response for postprocessor request
    Then Verify content list is ordered in RR by "iptv_user_language" and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV strategy when user has no dominant language
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                    |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV |
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
    Then Verify content list is ordered in RR by "iptv_user_language" and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV strategy when user has no significant language
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                    |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV |
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
    Then Verify content list is ordered in RR by "iptv_user_language" and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV strategy when user has no consume language
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                    |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV |
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
    Then Verify content list is ordered in RR by "user_selected_lang" and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV strategy when user has no user selected language
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      |           |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                    |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV |
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
    Then Verify content list is ordered in RR by "iptv_user_language" and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV strategy when user has no consumed and user selected language
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | languages |
      | hi,en     |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                    |
      | true                | GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_IPTV |
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

# GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV
  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV strategy
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV |
    When Add content list to arsenal collection request with
      | contentId                                       | position |
      | HOTSTAR_DTH_MOVIE_1271532249                    | 1        |
      | SONYLIV_VOD_LIVE_SPORT_1090487553               | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368  | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                   | 4        |
      | ZEEFIVE_MOVIE_0-0-1z5917832                     | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                    | 7        |
      | SONYLIV_VOD_LIVE_SPORT_1090487467               | 8        |
    And fetch response for postprocessor request
    Then Verify content list is ordered in RR by "iptv_user_consume_language" and rest content in end

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV strategy when user has no consume language
    Given We are using "l8a0ZBd13UbRtbp78X00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV |
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

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV strategy when user has no significant language
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV |
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

  Scenario: Verify GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV strategy when user has no Dominant language
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request
    When post process request with
      | enableDeduplication | strategy                                     |
      | true                | GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE_IPTV |
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
    Then Verify content list is ordered in RR by "iptv_user_consume_language" and rest content in end

# GROUP_BY_PARTNER_THEN_MERGE_IPTV changed to GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY_IPTV
  Scenario: Verify GROUP_BY_PARTNER_THEN_MERGE_IPTV strategy
    Given We are using "l8a0ZBd13UbRtbpX00" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And create body for postprocessor request with below content
      | contentId                                                             | position |
      | HOTSTAR_DTH_MOVIE_1271532249                                          | 1        |
      | LIONSGATEPLAY_MOVIE_ALIYABASUGAYABHAIY2024MHI                                          | 2        |
      | AHA_MOVIE_91B37D19-AF75-4184-884F-7C2EC2809368                        | 3        |
      | SONYLIV_VOD_TVSHOW_1700000084                                         | 4        |
      | AMAZON_PRIME_TVSHOW_amzn1.dv.gti.7b4f4e9d-dbf6-4bef-a611-f14ffec602ea | 5        |
      | AHA_TVSHOW_48C7DB18-7A84-46DE-9936-A7A69E681F9D                       | 6        |
      | SONYLIV_VOD_MOVIE_1000064609                                          | 7        |
      | HOTSTAR_DTH_MOVIE_643854                                              | 8        |
    When post process request with
      | enableDeduplication | strategy                         |
      | true                | GROUP_BY_LANG_CONTENT_PARTNER_AFFINITY_IPTV |
    And fetch response for postprocessor request
    Then Verify content list is ordered by user consume language for GROUP_BY_PARTNER_THEN_MERGE_IPTV strategy

