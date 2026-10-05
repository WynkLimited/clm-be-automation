Feature: Subscription Filter
  filter_userSubscription: This is a filter which is used to filter content based on user subscription. It can be include or exclude.
  -> If it is include then all content will be returned for avod and svod2 user.
  -> If it is include and user is svod user then only svod2 content should not visible.
  -> If it is exclude then only content which is not subscribed by user will be returned.

  filter_subscribedContentOnly: This is a filter which is used to filter content based on user subscription. It can be true or false.
  -> If it is true and user is avod user then only free content should not visible.
  -> If it is true and user is svod user then only svod2 content should not visible.
  -> If it is true and user is svod user then only svod2 content should be visible.
  -> If it is false then only content which is not subscribed by user will be returned.

  filter_contents_filtered_on_subscription: This is a filter which is used to filter content based on content subscription state.
  -> It can be FREE, XPP, SVOD2 or combination of these.

  filter_freeContent: This is a filter which is used to filter content based on content subscription state only for free type.

  => Keys_To_Use : sd, partnerStatus, offerSegment

  => Note: Need to manage collection for subscription filter test cases, so we are using arsenal
  collection axsta_automation_collection

  #    filter_userSubscription
  Scenario: Verify when user is an avod user and filter_userSubscription is include then all content should be returned using sd
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_userSubscription |
      | include                 |
    And post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify when user is an svod 2.0 user and filter_userSubscription is include then all content should be returned for sd
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd    | partnerStatus | offerSegment | debug |
      | SVOD2 |               |              | true  |
#    And create body for postprocessor request
    And create body for postprocessor request with params
      | filter_userSubscription |
      | include                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify when user is an svod user and filter_userSubscription is include then one only svod(free+svod paid) content should be returned for sd
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | svod |               |              | true  |
    And create body for postprocessor request with params
      | filter_userSubscription |
      | include                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner

  Scenario: Verify when user is an svod 2.0 user and filter_userSubscription is include then all content should be returned with partnerStatus
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd | offerSegment | partnerStatus                                                                                  | debug |
      |    |              | xstreampremium:claimed,jiohotstar:claimed,netflix:claimed,zeefive:claimed,amazon_prime:claimed | true  |
    And create body for postprocessor request with params
      | filter_userSubscription |
      | include                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify when user is an avod user and filter_userSubscription is include then all content should be returned with offerSegment
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd | partnerStatus | offerSegment        | debug |
      |    |               | xstreampremium_free | true  |
    And create body for postprocessor request with params
      | filter_userSubscription |
      | include                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify when user is an svod user and filter_userSubscription is include then one only svod(free+svod paid) content should be returned with offerSegment
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd | partnerStatus | offerSegment        | debug |
      |    |               | xstreampremium_paid | true  |
    And create body for postprocessor request with params
      | filter_userSubscription |
      | include                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner

  Scenario: Verify when user is an svod user and filter_userSubscription is exclude then one only svod(free+svod paid) content should not be returned
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | svod |               |              | true  |
    And create body for postprocessor request with params
      | filter_userSubscription |
      | exclude                 |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all svod contents are not returned in response


    # filter_subscribedContentOnly
  Scenario: Verify when user is an svod user and filter_subscribedContentOnly is true then only svod(free+svod paid) content should be returned with sd
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | svod |               |              | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner

  Scenario: Verify when user is an avod user and filter_subscribedContentOnly is true then only free content should be returned with sd
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are free content should be returned

  Scenario: Verify when user is an svod 2.0 user and filter_subscribedContentOnly is true then all content should be returned with sd
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd    | debug |
      | svod2 | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify when user is an svod user and filter_subscribedContentOnly is true then only svod(free+svod paid) content should be returned with partner status
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd | partnerStatus          | offerSegment | debug |
      |    | xstreampremium:claimed |              | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner

  Scenario: Verify when user is an svod 2.0 user and filter_subscribedContentOnly is true then all content should be returned with partner status
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd | partnerStatus                                                                                  | offerSegment | debug |
      |    | xstreampremium:claimed,jiohotstar:claimed,netflix:claimed,zeefive:claimed,amazon_prime:claimed |              | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request

  Scenario: Verify when user is an svod user and filter_subscribedContentOnly is true then only svod(free+svod paid) content should be returned with offerSegment
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd | partnerStatus | offerSegment        | debug |
      |    |               | xstreampremium_paid | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner

  Scenario: Verify when user is an avod user and filter_subscribedContentOnly is true then only free content should be returned with offerSegment
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd | partnerStatus | offerSegment        | debug |
      |    |               | xstreampremium_free | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | true                         |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are free content should be returned

  Scenario: Verify when user is an svod user and filter_subscribedContentOnly is false then all contents should be returned with offerSegment
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd    | debug |
      | svod2 | true  |
    And create body for postprocessor request with params
      | filter_subscribedContentOnly |
      | false                        |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify content list in same order as request


    #  filter_contents_filtered_on_subscription
  Scenario: verify only free contents are returned accourding to filter_contents_filtered_on_subscription is FREE
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_contents_filtered_on_subscription |
      | FREE                                     |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are free content should be returned

  Scenario: verify only paid xpp contents are returned accourding to filter_contents_filtered_on_subscription is XPP
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_contents_filtered_on_subscription |
      | XPP                                      |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner

  Scenario: verify only Svod2 contents are returned accourding to filter_contents_filtered_on_subscription is SVOD2
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_contents_filtered_on_subscription |
      | SVOD2                                    |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are from external content partner should be returned

  Scenario: verify free and paid xpp contents are returned accourding to filter_contents_filtered_on_subscription is FREE and XPP
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_contents_filtered_on_subscription |
      | FREE, XPP                                |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are not from external content partner should be returned


    # exclude_filter_contents_filtered_on_subscription
  Scenario: verify free contents are not returned accourding to exclude_filter_contents_filtered_on_subscription is FREE
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | exclude_filter_contents_filtered_on_subscription |
      | FREE                                             |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are not from free content should be returned
#
  Scenario: verify paid contents should bot returned accourding to exclude_filter_contents_filtered_on_subscription is XPP, SVOD2
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | exclude_filter_contents_filtered_on_subscription |
      | XPP, SVOD2                                       |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are free content should be returned
#
  Scenario: verify internal cp contents are returned accourding to exclude_filter_contents_filtered_on_subscription is SVOD2
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | exclude_filter_contents_filtered_on_subscription |
      | SVOD2                                            |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner

  Scenario: verify free and paid xpp contents are returned accourding to exclude_filter_contents_filtered_on_subscription is FREE and XPP
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | exclude_filter_contents_filtered_on_subscription |
      | FREE, XPP                                        |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are from external content partner should be returned

  Scenario: verify all paid xpp contents are returned accourding to exclude_filter_contents_filtered_on_subscription is FREE and XPP
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | exclude_filter_contents_filtered_on_subscription |
      | FREE, SVOD2                                      |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents which are return should be from internal content partner
    And Verify all contents are not from free content should be returned

#  filter_freeContent
  Scenario: verify all and firstEpisodeFre free contents are returned accourding to filter_freeContent filter
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_freeContent    |
      | all, firstEpisodeFree |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all contents are free content should be returned

  Scenario: verify all free contents are returned accourding to filter_freeContent filter
    Given We are using "MOdGE8JM3IvRVcZSE0" as a Xstream user and fetch
      | Experiment | WatchHistory | VisualSkip | SlotPersona |
      | false      | false        | false      | false       |
    And change user Live Attributes to
      | sd   | partnerStatus | offerSegment | debug |
      | AVOD |               |              | true  |
    And create body for postprocessor request with params
      | filter_freeContent |
      | all                |
    When post process request with
      | enableDeduplication | deduplicationMethod |
      | true                | dubbed_overlap      |
    When Add content list to collection request using arsenal collection "axsta_automation_collection"
    And fetch response for postprocessor request
    Then Verify all episode contents are free content should be returned