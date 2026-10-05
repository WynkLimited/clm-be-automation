package stepDefinition.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import model.Common.arsenalCollection.Content;
import model.Common.arsenalCollection.PostProcessing;
import model.response.userPersona.UserPersonaDTO;
import net.serenitybdd.annotations.Steps;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import services.common.KibanaService;
import services.discovery.DownStreamService;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static helpers.ApiHelper.gson;

import static stepDefinition.api.MultiSourceSteps.*;
import static utilities.StringUtils.toLower;

public class PostProcessorSteps {
    PostProcessing postProcessing;

    @Steps
    KibanaService kibanaService;

    private static List<String> fetchContentIdList(List<Content> contents) {
        List<String> contentIds = new ArrayList<>();
        for (Content content : contents) {
            contentIds.add(content.getContentId());
        }
        return contentIds;
    }

    private static List<String> listOfLang(String l) {
        return l != null ? List.of(l.replace(" ", "").split(",")) : new ArrayList<>();
    }

    public static Set<String> getUserLanguage(String type, UserPersonaDTO userPersona, Map<String, String> liveAttribute) {
        Set<String> userLangList = new HashSet<>();

        List<String> userSelectedLang = liveAttribute.containsKey("languages") ? listOfLang(liveAttribute.get("languages")) : listOfLang(userPersona.getXstreamOnboardingUsl());
        List<String> dominantLang = type.startsWith("c") ? listOfLang(userPersona.getClickPersonaDominantLang()) : listOfLang(userPersona.getXstreamDominantLanguageDaily());
        List<String> significantLang = type.startsWith("c") ? listOfLang(userPersona.getClickPersonaSignificantLang()) : userPersona.getXstreamSignificantLanguageDaily();

        switch (type) {
            case "usl" -> userLangList.addAll(userSelectedLang);
            case "ucl", "cucl" -> {
                userLangList.addAll(dominantLang);
                userLangList.addAll(significantLang);
            }
            case "ul", "cul" -> {
                userLangList.addAll(dominantLang);
                userLangList.addAll(significantLang);
                userLangList.addAll(userSelectedLang);
            }
            case "usil", "cusil" -> userLangList.addAll(significantLang);
            case "udl", "cudl" -> userLangList.addAll(dominantLang);
            default -> Collections.emptyList();
        }
        return userLangList;
    }

    @Then("Verify content list is ordered in RR by consume language and rest content in end")
    public void verifyContentListIsOrderedInRRByConsumeLanguageAndRestContentInEnd() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<String> userLanguagesList = new ArrayList<>(getUserLanguage("cucl", UserInfo.userPersona, UserInfo.liveAttribute));

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            if (i < response.getContents().size() - 2) {
                Assert.assertEquals(userLanguagesList.get(i % userLanguagesList.size()), response.getContents().get(i).getExtras().get("_bucket_key"));
            } else {
                Assert.assertFalse(userLanguagesList.contains(userLanguagesList.contains(response.getContents().get(i).getExtras().get("_bucket_key"))));
            }
        }
    }

    @Then("Verify content list in same order as request")
    public void verifyContentListInSameOrderAsRequest() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        ArsenalCollection request = DownStreamApiSteps.req;

        Assert.assertEquals(request.getContents().size(), response.getContents().size());
        for (int i = 0; i < response.getContents().size(); i++) {
            System.out.println(request.getContents().get(i).getContentId() + "===" + response.getContents().get(i).getContentId());
            Assert.assertEquals(request.getContents().get(i).getContentId(), response.getContents().get(i).getContentId());
        }
    }

    @Then("Verify preffered language content should be in front and rest content in end")
    public void verifyPrefferedLanguageContentShouldBeInFrontAndRestContentInEnd() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<String> userLanguagesList = new ArrayList<>(getUserLanguage("cucl", UserInfo.userPersona, UserInfo.liveAttribute));

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            if (i < 3) {
                if (i % userLanguagesList.size() == 0) {
                    Assert.assertEquals(userLanguagesList.getFirst(), response.getContents().get(i).getExtras().get("_bucket_key"));
                }
            } else {
                Assert.assertFalse(userLanguagesList.contains(userLanguagesList.contains(response.getContents().get(i).getExtras().get("_bucket_key"))));
            }
        }
    }

    @Then("Verify content list is ordered in RR by user language and rest content in end")
    public void verifyContentListIsOrderedInRRByUserLanguageAndRestContentInEnd() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<String> userLanguagesList = new ArrayList<>(getUserLanguage("cul", UserInfo.userPersona, UserInfo.liveAttribute));

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            if (i < response.getContents().size() - 2) {
                Assert.assertEquals(userLanguagesList.get(i % userLanguagesList.size()), response.getContents().get(i).getExtras().get("_bucket_key"));
            } else {
                Assert.assertFalse(userLanguagesList.contains(userLanguagesList.contains(response.getContents().get(i).getExtras().get("_bucket_key"))));
            }
        }
    }

    public static String languageTypeToCode(String languageType) {
        return switch (languageType.toLowerCase()) {
            case "user_consume_language" -> "cucl";
            case "iptv_user_consume_language" -> "iucl";
            case "user_language" -> "cul";
            case "iptv_user_language" -> "iul";
            default -> "user_selected_lang";
        };
    }

    @Then("Verify content list is ordered in RR by {string} and rest content in end")
    public void verifyContentListIsOrderedInRRByAndRestContentInEnd(String type) {

        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<String> userLanguagesList = new ArrayList<>(getUserLanguage(languageTypeToCode(type), UserInfo.userPersona, UserInfo.liveAttribute));

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            if (i < response.getContents().size() - 2) {
                Assert.assertEquals(userLanguagesList.get(i % userLanguagesList.size()), response.getContents().get(i).getExtras().get("_bucket_key"));
            } else {
                Assert.assertFalse(userLanguagesList.contains(userLanguagesList.contains(response.getContents().get(i).getExtras().get("_bucket_key"))));
            }
        }
    }

    @Then("^Verify all the contents should show as per context_language which is kn from \"([^\"]*)\" collection$")
    public void verifyAllContentAsPerContextLanguage(String collection) {
        ArsenalCollection response = DownStreamApiSteps.multiSourceResponse;

        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertEquals(collection, response.getContents().get(i).getExtras().get("_source"));
        }

    }

    @Then("Verify all the contents should show as per USL which is hi,en from {string} or {string} collection")
    public void verifyAllContentAsPerUSL(String collection1, String collection2) {
        ArsenalCollection response = DownStreamApiSteps.multiSourceResponse;

        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(collection1.equalsIgnoreCase(response.getContents().get(i).getExtras().get("_source")) | collection2.equalsIgnoreCase(response.getContents().get(i).getExtras().get("_source")));
        }

    }

    @Then("Verify all the contents should show as per both contextLanguage and USL which is kn,hi from {string} or {string}")
    public void verifyAllContentAsPerContextLanguageAndUSL(String collection1, String collection2) {
        ArsenalCollection response = DownStreamApiSteps.multiSourceResponse;

        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(collection1.equalsIgnoreCase(response.getContents().get(i).getExtras().get("_source")) | collection2.equalsIgnoreCase(response.getContents().get(i).getExtras().get("_source")));
        }

    }

    @Then("Verify all the contents should show as per USL which is hi,en from {string} or {string}")
    public void verifyAllContentAsPerUSLForBothLanguage(String collection1, String collection2) {
        ArsenalCollection response = DownStreamApiSteps.multiSourceResponse;

        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(collection1.equalsIgnoreCase(response.getContents().get(i).getExtras().get("_source")) | collection2.equalsIgnoreCase(response.getContents().get(i).getExtras().get("_source")));
        }

    }

    @Then("verify content should return on the intersection of input language and output language")
    public void verifyContentShouldReturnFromCollection() {
        ArsenalCollection ars = DownStreamApiSteps.req;

        List<String> originalSequence = new ArrayList<>();
        Response node;
        for (int i = 0; i < ars.getContents().size(); i++) {
            node = kibanaService.getContentMeta(ars.getContents().get(i).getContentId());
            originalSequence.add(node.getBody().jsonPath().get("_source.ln").toString().replace("\"", "").replace("[", "").replace("]", "").replace(" ", ""));
        }
        String inputLanguages = kibanaService.getContentMeta(UserInfo.liveAttribute.get("contentId")).getBody().jsonPath().get("_source.ln").toString().replace("\"", "").replace("[", "").replace("]", "").replace(" ", "");
        Set<String> inputLangSet = Arrays.stream(inputLanguages.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
        List<String> matching = new ArrayList<>();
        List<String> nonMatching = new ArrayList<>();

        for (int i = 0; i < originalSequence.size(); i++) {

            String contentLanguages = originalSequence.get(i);
            String contentId = ars.getContents().get(i).getContentId();

            boolean hasMatch = Arrays.stream(contentLanguages.split(","))
                    .map(String::trim)
                    .anyMatch(inputLangSet::contains);

            if (hasMatch) {
                matching.add(contentId);
            } else {
                nonMatching.add(contentId);
            }
        }

        List<String> expectedContentIds = new ArrayList<>();
        expectedContentIds.addAll(matching);
        expectedContentIds.addAll(nonMatching);

        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        List<String> actualContentIds = response.getContents().stream()
                .map(Content::getContentId)
                .collect(Collectors.toList());
        Assert.assertEquals(expectedContentIds, actualContentIds);
    }

    @Then("verify content should return on the intersection of input language, output language and UL")
    public void verifyContentShouldReturnOnLanguageAndUL() {
        ArsenalCollection ars = DownStreamApiSteps.req;
        List<String> ulLang = new ArrayList<>(getUserLanguage("ul", UserInfo.userPersona, UserInfo.liveAttribute));
        ulLang.removeIf(String::isEmpty);
        List<String> originalSequence = new ArrayList<>();
        Response node;
        for (int i = 0; i < ars.getContents().size(); i++) {
            node = kibanaService.getContentMeta(ars.getContents().get(i).getContentId());
            originalSequence.add(node.getBody().jsonPath().get("_source.ln").toString().replace("\"", "").replace("[", "").replace("]", "").replace(" ", ""));
        }

        String inputLanguage = kibanaService.getContentMeta(UserInfo.liveAttribute.get("contentId")).getBody().jsonPath().get("_source.ln").toString().replace("\"", "").replace("[", "").replace("]", "").replace(" ", "");
        Set<String> inputLangSet = Arrays.stream(inputLanguage.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();
        List<String> p3 = new ArrayList<>();

        for (int i = 0; i < originalSequence.size(); i++) {

            String contentLanguages = originalSequence.get(i);
            String contentId = ars.getContents().get(i).getContentId();

            Set<String> contentLangSet = Arrays.stream(contentLanguages.split(","))
                    .map(String::trim)
                    .collect(Collectors.toSet());

            boolean matchesInput =
                    contentLangSet.stream().anyMatch(inputLangSet::contains);

            boolean matchesUL =
                    contentLangSet.stream().anyMatch(ulLang::contains);

            if (matchesInput) {
                p1.add(contentId);
            } else if (matchesUL) {
                p2.add(contentId);
            } else {
                p3.add(contentId);
            }
        }

        List<String> expectedContentIds = new ArrayList<>();
        expectedContentIds.addAll(p1);
        expectedContentIds.addAll(p2);
        expectedContentIds.addAll(p3);

        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        List<String> actualContentIds = response.getContents().stream()
                .map(content -> content.getContentId())
                .collect(Collectors.toList());

        System.out.println("Expected IDs : " + expectedContentIds);
        System.out.println("Actual IDs   : " + actualContentIds);

        Assert.assertEquals(expectedContentIds, actualContentIds);
    }

    @Then("verify content should return on the intersection of input output language and UL")
    public void verifyContentShouldReturnOnUL() throws JsonProcessingException {
        ArsenalCollection ars = DownStreamApiSteps.req;
        List<String> ulLang = new ArrayList<>(getUserLanguage("ul", UserInfo.userPersona, UserInfo.liveAttribute));
        ulLang.removeIf(String::isEmpty);
        List<String> originalSequence = new ArrayList<>();
        Response node;
        for (int i = 0; i < ars.getContents().size(); i++) {
            node = kibanaService.getContentMeta(ars.getContents().get(i).getContentId());
            originalSequence.add(node.getBody().jsonPath().get("_source.ln").toString().replace("\"", "").replace("[", "").replace("]", "").replace(" ", ""));
        }
        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();

        for (int i = 0; i < originalSequence.size(); i++) {

            String contentLanguages = originalSequence.get(i);
            String contentId = ars.getContents().get(i).getContentId();

            Set<String> contentLangSet = Arrays.stream(contentLanguages.split(","))
                    .map(String::trim)
                    .collect(Collectors.toSet());

            boolean matchesUL =
                    contentLangSet.stream().anyMatch(ulLang::contains);

            if (matchesUL) {
                p1.add(contentId);
            } else {
                p2.add(contentId);
            }
        }

        List<String> expectedContentIds = new ArrayList<>();
        expectedContentIds.addAll(p1);
        expectedContentIds.addAll(p2);

        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        List<String> actualContentIds = response.getContents().stream()
                .map(content -> content.getContentId())
                .collect(Collectors.toList());

        System.out.println("Expected IDs : " + expectedContentIds);
        System.out.println("Actual IDs   : " + actualContentIds);

        Assert.assertEquals(expectedContentIds, actualContentIds);
    }

    @Then("Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK strategy")
    public void verifyContentListOrderedByGROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICKStrategy() {
        ArsenalCollection ars = DownStreamApiSteps.req;
        List<String> sigLang = new ArrayList<>(getUserLanguage("cusil", UserInfo.userPersona, UserInfo.liveAttribute));
        sigLang.removeIf(String::isEmpty);
        String resultSigLang = String.join(",", sigLang);
        List<String> domLang = new ArrayList<>(getUserLanguage("cudl", UserInfo.userPersona, UserInfo.liveAttribute));
        domLang.removeIf(String::isEmpty);
        String resultDomLang = String.join(",", domLang);
        List<String> selectedLang = new ArrayList<>(getUserLanguage("usl", UserInfo.userPersona, UserInfo.liveAttribute));
        selectedLang.removeIf(String::isEmpty);
        String resultSelectedLang = String.join(",", selectedLang);
        Response node;
        List<String> originalSequence = new ArrayList<>();
        for (int i = 0; i < ars.getContents().size(); i++) {
            node = kibanaService.getContentMeta(ars.getContents().get(i).getContentId());
            originalSequence.add(node.getBody().jsonPath().get("_source.ln").toString().replace("\"", "").replace("[", "").replace("]", "").replace(" ", ""));
        }

        List<String> priorityLanguages = new ArrayList<>();

        addLanguages(priorityLanguages, resultDomLang);
        addLanguages(priorityLanguages, resultSigLang);
        addLanguages(priorityLanguages, resultSelectedLang);

        priorityLanguages = priorityLanguages.stream()
                .distinct()
                .collect(Collectors.toList());

        boolean hasPriority = !priorityLanguages.isEmpty();

        Map<String, Queue<String>> groups = new LinkedHashMap<>();
        for (int i = 0; i < originalSequence.size(); i++) {

            String contentLanguages = originalSequence.get(i);
            String contentId = ars.getContents().get(i).getContentId();
            List<String> langs = Arrays.stream(contentLanguages.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
            String bucketKey = null;
            if (!hasPriority) {
                bucketKey = langs.get(0);
            } else {
                for (String lang : langs) {

                    if (priorityLanguages.contains(lang)) {
                        bucketKey = lang;
                        break;
                    }
                }
                if (bucketKey == null) {

                    for (String lang : langs) {

                        if (groups.containsKey(lang)) {
                            bucketKey = lang;
                            break;
                        }
                    }
                }
                if (bucketKey == null) {
                    bucketKey = langs.get(0);
                }
            }
            groups.computeIfAbsent(bucketKey, k -> new LinkedList<>())
                    .add(contentId);
        }

        List<String> expectedContentIds = new ArrayList<>();

        Map<String, Queue<String>> priorityGroups = new LinkedHashMap<>();

        for (String lang : priorityLanguages) {

            Queue<String> queue = groups.remove(lang);

            if (queue != null && !queue.isEmpty()) {
                priorityGroups.put(lang, queue);
            }
        }

        if (!priorityGroups.isEmpty()) {
            roundRobin(priorityGroups, expectedContentIds);
        }
        roundRobin(groups, expectedContentIds);
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<String> actualContentIds = response.getContents().stream()
                .map(content -> content.getContentId())
                .collect(Collectors.toList());
        System.out.println("Expected IDs : " + expectedContentIds);
        System.out.println("Actual IDs   : " + actualContentIds);
        Assert.assertEquals(expectedContentIds, actualContentIds);
    }

    private void roundRobin(Map<String, Queue<String>> groups,
                            List<String> result) {
        boolean hasMoreData = true;
        while (hasMoreData) {
            hasMoreData = false;
            for (Queue<String> queue : groups.values()) {
                if (!queue.isEmpty()) {
                    result.add(queue.poll());
                    hasMoreData = true;
                }
            }
        }
    }

    private void addLanguages(List<String> target,
                              String languages) {
        if (languages == null || languages.isBlank()) {
            return;
        }
        target.addAll(
                Arrays.stream(languages.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toList())
        );
    }

    @Then("Verify content list is ordered by user consume language for GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_SHUFFLE strategy")
    public void verifyContentListOrderedByGROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE_CLICK_ShuffleStrategy() {
        ArsenalCollection ars = DownStreamApiSteps.req;
        List<String> sigLang = new ArrayList<>(getUserLanguage("cusil", UserInfo.userPersona, UserInfo.liveAttribute));
        sigLang.removeIf(String::isEmpty);
        String resultSigLang = String.join(",", sigLang);
        List<String> domLang = new ArrayList<>(getUserLanguage("cudl", UserInfo.userPersona, UserInfo.liveAttribute));
        domLang.removeIf(String::isEmpty);
        String resultDomLang = String.join(",", domLang);
        List<String> selectedLang = new ArrayList<>(getUserLanguage("usl", UserInfo.userPersona, UserInfo.liveAttribute));
        selectedLang.removeIf(String::isEmpty);
        String resultSelectedLang = String.join(",", selectedLang);
        Response node;
        List<String> originalSequence = new ArrayList<>();
        for (int i = 0; i < ars.getContents().size(); i++) {
            node = kibanaService.getContentMeta(ars.getContents().get(i).getContentId());
            originalSequence.add(node.getBody().jsonPath().get("_source.ln").toString().replace("\"", "").replace("[", "").replace("]", "").replace(" ", ""));
        }

        List<String> priorityLanguages = new ArrayList<>();
        addLanguages(priorityLanguages, resultDomLang);
        addLanguages(priorityLanguages, resultSigLang);
        addLanguages(priorityLanguages, resultSelectedLang);
        priorityLanguages = priorityLanguages.stream().distinct().collect(Collectors.toList());
        boolean hasPriority = !priorityLanguages.isEmpty();
        Map<String, Queue<String>> groups = new LinkedHashMap<>();
        for (String contentLanguages : originalSequence) {
            List<String> langs = Arrays.stream(contentLanguages.split(",")).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
            String bucketKey = null;
            if (!hasPriority) {
                bucketKey = langs.get(0);
            } else {
                for (String lang : langs) {

                    if (priorityLanguages.contains(lang)) {
                        bucketKey = lang;
                        break;
                    }
                }
                if (bucketKey == null) {

                    for (String lang : langs) {

                        if (groups.containsKey(lang)) {
                            bucketKey = lang;
                            break;
                        }
                    }
                }
                if (bucketKey == null) {
                    bucketKey = langs.get(0);
                }
            }
            groups.computeIfAbsent(bucketKey, k -> new LinkedList<>()).add(contentLanguages);
        }
        List<String> expectedOrder = new ArrayList<>();
        Map<String, Queue<String>> priorityGroups = new LinkedHashMap<>();
        for (String lang : priorityLanguages) {
            Queue<String> queue = groups.remove(lang);
            if (queue != null && !queue.isEmpty()) {
                priorityGroups.put(lang, queue);
            }
        }
        if (!priorityGroups.isEmpty()) {
            roundRobinShuffle(priorityGroups, expectedOrder);
        }
        roundRobinShuffle(groups, expectedOrder);
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<String> actualOrder = response.getContents().stream().map(content -> content.getExtras().get("_bucket_key").toString().replace("~~~__","")).collect(Collectors.toList());
        System.out.println("Expected IDs : " + expectedOrder);
        System.out.println("Bucket_key IDs   : " + actualOrder);
        List<String> actualOrderLanguage = response.getContents().stream()
                .map(content -> content.getExtras().get("_availableLanguages").toString()).collect(Collectors.toList());
        System.out.println("actualOrderLanguage IDs   : " + actualOrderLanguage);
        for(int i=0;i<actualOrder.size();i++){
            Assert.assertTrue(expectedOrder.get(i).contains( actualOrder.get(i)));
        }

    }

    private void roundRobinShuffle(Map<String, Queue<String>> groups,
                                   List<String> result) {
        boolean hasMoreData = true;
        while (hasMoreData) {
            hasMoreData = false;
            for (Queue<String> queue : groups.values()) {
                if (queue != null && !queue.isEmpty()) {
                    result.add(queue.poll());
                    hasMoreData = true;
                }
            }
        }
    }

    @Then("Verify content list is ordered by user consume language for CONTENT_POPULARITY_CLICK strategy")
    public void verifyContentListForCONTENT_POPULARITY_CLICKStrategy(){
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<Integer> actualOrder = response.getContents().stream()
                .map(content -> Integer.parseInt(content.getExtras().get("_longTermRank30DaysC"))).collect(Collectors.toList());
        List<Integer> expectedOrder = actualOrder.stream()
                .sorted()
                .collect(Collectors.toList());
        Assert.assertEquals(expectedOrder, actualOrder);

    }

    @Then("Verify content list is ordered by user consume language for GROUP_BY_PARTNER_THEN_MERGE_IPTV strategy")
    public void verifyContentListForGROUP_BY_PARTNER_THEN_MERGE_IPTVStrategy(){

        Map<String, List<String>> languagePreference = new HashMap<>();
        languagePreference.put("hi", Arrays.asList("sonyliv_vod","mxplayer","zeefive","hotstar_dth","amazon_prime","erosnow","hungama","shemaroome","ultra","epicon"));
        languagePreference.put("en", Arrays.asList("lionsgateplay","sonyliv_vod","hotstar_dth","amazon_prime","timesplay","docubay","playflix"));
        languagePreference.put("ta", Arrays.asList("sunnxt","aha","zeefive","sonyliv_vod","amazon_prime","hotstar_dth","mxplayer","lionsgateplay","shemaroome","playflix"));
        languagePreference.put("te", Arrays.asList("aha","sunnxt","zeefive","amazon_prime","sonyliv_vod","mxplayer","hotstar_dth","lionsgateplay","playflix"));
        languagePreference.put("pa", Arrays.asList("chaupal","zeefive","shemaroome","amazon_prime","hungama"));
        languagePreference.put("bn", Arrays.asList("hoichoi","addatimes","klikk","zeefive","sonyliv_vod","shemaroome","erosnow","amazon_prime"));
        languagePreference.put("ml", Arrays.asList("sonyliv_vod","manoramamax","sunnxt","hotstar_dth","zeefive","amazon_prime"));
        languagePreference.put("kn", Arrays.asList("zeefive","sunnxt","sonyliv_vod","nammaflix","hotstar_dth","lionsgateplay","hungama","amazon_prime"));
        languagePreference.put("hr", Arrays.asList("chaupal","sonyliv_vod","mxplayer","zeefive","hotstar_dth","amazon_prime","erosnow","hungama","shemaroome"));
        languagePreference.put("ko", Arrays.asList("playflix","mxplayer","sonyliv_vod","lionsgateplay","epicon","zeefive","amazon_prime"));
        languagePreference.put("gu", Arrays.asList("jojo","shemaroome","sonyliv_vod","mxplayer","zeefive","hotstar_dth","amazon_prime","erosnow","hungama"));
        languagePreference.put("mr", Arrays.asList("zeefive","sonyliv_vod","shemaroome","hungama","lionsgateplay","playflix","erosnow"));
        languagePreference.put("bh", Arrays.asList("chaupal","klikk","hungama","playflix","lionsgateplay","shemaroome"));
        languagePreference.put("od", Arrays.asList("hungama","sonyliv_vod","mxplayer","zeefive","hotstar_dth","amazon_prime","erosnow","shemaroome"));

        ArsenalCollection ars = DownStreamApiSteps.req;
        Response node;
        List<String> originalSequence = new ArrayList<>();
        for (int i = 0; i < ars.getContents().size(); i++) {
            node = kibanaService.getContentMeta(ars.getContents().get(i).getContentId());
            originalSequence.add(node.getBody().jsonPath().get("_source.ln").toString());
        }

        Map<String, List<Content>> buckets = new LinkedHashMap<>();
        for (int i = 0; i < originalSequence.size(); i++) {
            String bucketLanguage = originalSequence.get(i)
                    .split(",")[0]
                    .trim().replace("[","").replace("]","")
                    .toLowerCase();
            buckets.computeIfAbsent(bucketLanguage, k -> new ArrayList<>())
                    .add(ars.getContents().get(i));
        }
        for (Map.Entry<String, List<Content>> bucket : buckets.entrySet()) {
            List<String> preference =
                    languagePreference.getOrDefault(bucket.getKey(), Collections.emptyList());
            Map<String, Integer> rank = new HashMap<>();
            for (int i = 0; i < preference.size(); i++) {
                rank.put(preference.get(i), i);
            }
            List<Content> preferred = new ArrayList<>();
            List<Content> remaining = new ArrayList<>();
            for (Content content : bucket.getValue()) {
                String cp = kibanaService.getContentMeta(String.valueOf(content.getContentId())).getBody().jsonPath().get("_source.cp").toString().trim().toLowerCase();
                if (rank.containsKey(cp)) {
                    preferred.add(content);
                } else {
                    remaining.add(content);
                }
            }
            preferred.sort(Comparator.comparingInt(
                    c -> rank.get(kibanaService.getContentMeta(String.valueOf(c.getContentId())).getBody().jsonPath().get("_source.cp").toString().trim().toLowerCase())
            ));
            preferred.addAll(remaining);
            bucket.setValue(preferred);
        }
        List<String> expectedContentIds = new ArrayList<>();
        int index = 0;
        while (true) {
            boolean found = false;
            for (List<Content> bucket : buckets.values()) {
                if (index < bucket.size()) {
                    expectedContentIds.add(bucket.get(index).getContentId());
                    found = true;
                }
            }
            if (!found) {
                break;
            }
            index++;
        }
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        List<String> actualContentIds = response.getContents().stream()
                .map(Content::getContentId)
                .collect(Collectors.toList());
        System.out.println("Expected IDs : " + expectedContentIds);
        System.out.println("Actual IDs   : " + actualContentIds);
        Assert.assertEquals(expectedContentIds, actualContentIds);
    }

    @Then("Verify all contents are free content should be returned")
    public void verifyAllContentsAreFreeContentShouldBeReturned() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(checkForFreeContent(response.getContents().get(i).getExtras()));
        }
    }

    @Then("Verify all contents are not from free content should be returned")
    public void verifyAllContentsAreNotFreeContentShouldBeReturned() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertFalse(checkForFreeContent(response.getContents().get(i).getExtras()));
        }
    }

    @Then("Verify all contents which are return should be from internal content partner")
    public void verifyAllContentsWhichAreReturnShouldBeFromInternalContentPartner() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(checkForSVODContent(response.getContents().get(i).getExtras()));
        }
    }

    @Then("Verify all svod contents are not returned in response")
    public void verifyAllSvodContentsAreNotReturnedInResponse() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertFalse(checkForSVODContent(response.getContents().get(i).getExtras()));
        }
    }

    @Then("Verify all contents are from external content partner should be returned")
    public void verifyAllContentsAreFromExternalContentPartnerShouldBeReturned() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(checkForOnlySVOD2Content(response.getContents().get(i).getExtras()));
        }
    }

    @Then("Verify all contents are not from external content partner should be returned")
    public void verifyAllContentsAreNotFromExternalContentPartnerShouldBeReturned() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertFalse(checkForOnlySVOD2Content(response.getContents().get(i).getExtras()));
        }
    }

    @Then("Verify all episode contents are free content should be returned")
    public void verifyAllEpisodeContentsAreFreeContentShouldBeReturned() {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;

        Assert.assertFalse(response.getContents().isEmpty());
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(checkForAllFreeContent(response.getContents().get(i).getExtras()));
        }
    }

    @Then("Verify all {string} should be {string} in the response")
    public void verifyAllShouldBeInTheResponse(String field, String operation) {
        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        Assert.assertFalse(response.getContents().isEmpty());

        for (int i = 0; i < response.getContents().size(); i++) {
            boolean condution = response.getContents().get(i).getExtras().containsKey(field) && response.getContents().get(i).getExtras().get(field).equals("true");
            if (operation.equals("included")) {
                Assert.assertTrue(condution);
            } else {
                Assert.assertFalse(condution);
            }
        }
    }

    @Then("Verify all {string} whose value is {string} should be {string} in the response")
    public void verifyAllWhoseValueIsShouldBeInTheResponse(String field, String value, String operation) {

        ArsenalCollection response = DownStreamApiSteps.postProcessorResponse;
        Assert.assertFalse(response.getContents().isEmpty());
        List<String> values = toLower(value.split(","));

        for (int i = 0; i < response.getContents().size(); i++) {
            for (String s : values) {
                Map<String,String> extras = response.getContents().get(i).getExtras();
                boolean condution = extras.containsKey(field) && extras.get(field).toLowerCase().contains(s.toLowerCase());
                if (operation.equals("included")) Assert.assertTrue(condution);
                else Assert.assertFalse(condution);

            }
        }
    }
}
