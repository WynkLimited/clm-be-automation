package services.clm;

import com.airtel.helper.common.BaseManager;
import com.airtel.helper.report.ChainTestUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.typesafe.config.Config;
import config.ConfigLoader;
import constants.TokenConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.junit.Assert;
import stepDefinition.api.ApiEndpoints;
import utilities.TestSession;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class AudienceManagerService extends BaseManager implements ApiEndpoints {

    private final Config conf = ConfigLoader.load();

    private List<Header> authHeaders() {
        String token = TestSession.get(TokenConstants.AUTH_TOKEN_SESSION_KEY);
        if (token == null || token.isBlank()) {
            throw new IllegalStateException(
                    "JWT auth token not found in session. Run 'Generate JWT auth token for CLM APIs' first.");
        }
        return Arrays.asList(new Header("Authorization", "Bearer " + token));
    }

    public Response getPartnerInfo(boolean checkStatus) {
        Response response = getResponseWithHeaders(null, authHeaders(), BASE_URL + PARTNER_INFO_ENDPOINT, checkStatus);
        ChainTestUtil.log("Partner info status=" + response.statusCode());
        ChainTestUtil.embedJson(response.asString());
        return response;
    }

    public Response getTagCatalog(boolean checkStatus) {
        Map<String, String> query = Map.of("scope", "AUDIENCE_CATALOG");
        Response response = getResponseWithHeaders(query, authHeaders(), BASE_URL + TAG_CATALOG_LIST_ENDPOINT, checkStatus);
        ChainTestUtil.log("Tag catalog status=" + response.statusCode());
        ChainTestUtil.embedJson(response.asString());
        return response;
    }

    public Response createAudience(String body, Map<String, String> queryParams, boolean checkStatus) {
        ChainTestUtil.embedJson(body);
        Response response = patchResponseWithHeaders(
                body,
                authHeaders(),
                ContentType.JSON,
                BASE_URL + AUDIENCE_SAVE_ENDPOINT,
                queryParams,
                checkStatus);
        String responseBody = response.getBody().asString();
        log.info("response: {}", responseBody);
        ChainTestUtil.log("Create audience status=" + response.statusCode());
        ChainTestUtil.embedJson(responseBody);
        return response;
    }

    /**
     * Fetches the audience document from Mongo by id using framework {@code MongoHelper}
     * (via {@link BaseManager}).
     */
    public Document getAudienceFromMongo(String audienceId) {
        Assert.assertFalse("audienceId must not be blank", audienceId == null || audienceId.isBlank());

        String uri = conf.getString("mongodb.uri");
        String database = conf.getString("mongodb.database");
        String collectionName = conf.getString("mongodb.audienceCollection");
        String idField = conf.getString("mongodb.audienceIdField");

        MongoClient client = getMongoClient(uri);
        MongoCollection<Document> collection = getCollection(client, database, collectionName);
        List<Document> docs = getResultFromMongo(collection, getMongoDBQuery(idField, audienceId));

        String mongoLookupMsg = String.format(
                "Mongo audience lookup | db=%s | collection=%s | %s=%s | hits=%d",
                database, collectionName, idField, audienceId, docs.size());
        log.info(mongoLookupMsg);
        ChainTestUtil.log(mongoLookupMsg);
        if (!docs.isEmpty()) {
            ChainTestUtil.embedJson(docs.get(0).toJson());
        }

        return docs.isEmpty() ? null : docs.get(0);
    }

    /**
     * Validates that the created audience exists in Mongo and matches expected name (if provided).
     *
     * @return the Mongo document when validation passes
     */
    public Document validateCreatedAudienceInMongo(String audienceId, String expectedName) {
        Document audienceDoc = getAudienceFromMongo(audienceId);
        Assert.assertNotNull(
                "Audience not found in Mongo for " + conf.getString("mongodb.audienceIdField") + "=" + audienceId,
                audienceDoc);

        if (expectedName != null && !expectedName.isBlank()) {
            Object actualName = audienceDoc.get("name");
            Assert.assertEquals(
                    "Audience name mismatch in Mongo for id=" + audienceId,
                    expectedName,
                    actualName == null ? null : String.valueOf(actualName));
        }

        ChainTestUtil.log("Audience validated in Mongo | id=%s | name=%s", audienceId, audienceDoc.get("name"));
        return audienceDoc;
    }
}
