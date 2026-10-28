package services.clm;

import com.airtel.helper.common.BaseManager;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.typesafe.config.Config;
import config.ConfigLoader;
import constants.TokenConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import org.bson.Document;
import org.junit.Assert;
import stepDefinition.api.ApiEndpoints;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class AudienceManagerService extends BaseManager implements ApiEndpoints {

    private final Config conf = ConfigLoader.load();

    private List<Header> authHeaders() {
        String token = Serenity.sessionVariableCalled(TokenConstants.AUTH_TOKEN_SESSION_KEY);
        if (token == null || token.isBlank()) {
            throw new IllegalStateException(
                    "JWT auth token not found in session. Run 'Generate JWT auth token for CLM APIs' first.");
        }
        return Arrays.asList(new Header("Authorization", "Bearer " + token));
    }

    public Response getPartnerInfo(boolean checkStatus) {
        return getResponseWithHeaders(null, authHeaders(), BASE_URL + PARTNER_INFO_ENDPOINT, checkStatus);
    }

    public Response getTagCatalog(boolean checkStatus) {
        Map<String, String> query = Map.of("scope", "AUDIENCE_CATALOG");
        return getResponseWithHeaders(query, authHeaders(), BASE_URL + TAG_CATALOG_LIST_ENDPOINT, checkStatus);
    }

    public Response createAudience(String body, Map<String, String> queryParams, boolean checkStatus) {
        Response response = patchResponseWithHeaders(
                body,
                authHeaders(),
                ContentType.JSON,
                BASE_URL + AUDIENCE_SAVE_ENDPOINT,
                queryParams,
                checkStatus);
        log.info("response: {}", response.getBody().asString());
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

        log.info("Mongo audience lookup | db={} | collection={} | {}={} | hits={}",
                database, collectionName, idField, audienceId, docs.size());
        Serenity.recordReportData().withTitle("Mongo audience lookup")
                .andContents("db=" + database + ", collection=" + collectionName
                        + ", " + idField + "=" + audienceId + ", hits=" + docs.size()
                        + (docs.isEmpty() ? "" : ", doc=" + docs.get(0).toJson()));

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

        log.info("Audience validated in Mongo | id={} | name={}", audienceId, audienceDoc.get("name"));
        return audienceDoc;
    }
}
