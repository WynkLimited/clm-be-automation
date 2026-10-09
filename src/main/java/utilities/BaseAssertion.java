package utilities;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class BaseAssertion {

    // ==============================
    // Core Equality
    // ==============================

    public void assertEquals(Object actual, Object expected) {
        assertEquals(actual, expected, "Values are not equal");
    }

    public void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(buildMessage(message, expected, actual), expected, actual);
    }

    public void assertNotEquals(Object actual, Object expected) {
        assertNotEquals(actual, expected, "Values should NOT be equal");
    }

    public void assertNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(buildMessage(message, expected, actual), expected, actual);
    }

    // ==============================
    // Boolean
    // ==============================

    public void assertTrue(boolean condition) {
        assertTrue(condition, "Expected condition to be TRUE but was FALSE");
    }

    public void assertTrue(boolean condition, String message) {
        Assert.assertTrue(message, condition);
    }

    public void assertFalse(boolean condition) {
        assertFalse(condition, "Expected condition to be FALSE but was TRUE");
    }

    public void assertFalse(boolean condition, String message) {
        Assert.assertFalse(message, condition);
    }

    // ==============================
    // Null Checks
    // ==============================

    public void assertNotNull(Object object) {
        assertNotNull(object, "Expected object to be NOT NULL but was NULL");
    }

    public void assertNotNull(Object object, String message) {
        Assert.assertNotNull(message, object);
    }

    public void assertNull(Object object) {
        assertNull(object, "Expected object to be NULL but was NOT NULL");
    }

    public void assertNull(Object object, String message) {
        Assert.assertNull(message, object);
    }

    // ==============================
    // String Assertions
    // ==============================

    public void assertNotBlank(String value) {
        assertNotBlank(value, "Expected string to be NOT blank");
    }

    public void assertNotBlank(String value, String message) {
        Assert.assertTrue(message + "\nActual: " + value, value != null && !value.isBlank());
    }

    public void assertContains(String actual, String expectedSubstring) {
        assertContains(actual, expectedSubstring, "Expected string to contain: " + expectedSubstring);
    }

    public void assertContains(String actual, String expectedSubstring, String message) {
        Assert.assertTrue(
                message + "\nExpected substring: " + expectedSubstring + "\nActual: " + actual,
                actual != null && actual.contains(expectedSubstring)
        );
    }

    public void assertStartsWith(String actual, String prefix) {
        Assert.assertTrue(
                "Expected string to start with: " + prefix + "\nActual: " + actual,
                actual != null && actual.startsWith(prefix)
        );
    }

    public void assertEndsWith(String actual, String suffix) {
        Assert.assertTrue(
                "Expected string to end with: " + suffix + "\nActual: " + actual,
                actual != null && actual.endsWith(suffix)
        );
    }

    // ==============================
    // Collection / Map Assertions
    // ==============================

    public void assertCollectionNotEmpty(Collection<?> collection) {
        assertCollectionNotEmpty(collection, "Expected collection to NOT be empty");
    }

    public void assertCollectionNotEmpty(Collection<?> collection, String message) {
        Assert.assertTrue(message, collection != null && !collection.isEmpty());
    }

    public void assertCollectionSize(Collection<?> collection, int expectedSize) {
        Assert.assertEquals(
                "Collection size mismatch\nExpected: " + expectedSize
                        + "\nActual: " + (collection == null ? 0 : collection.size()),
                expectedSize,
                collection == null ? 0 : collection.size()
        );
    }

    public void assertCollectionContains(Collection<?> collection, Object value) {
        Assert.assertTrue(
                "Expected collection to contain: " + value,
                collection != null && collection.contains(value)
        );
    }

    public void assertMapNotEmpty(Map<?, ?> map) {
        assertMapNotEmpty(map, "Expected map to NOT be empty");
    }

    public void assertMapNotEmpty(Map<?, ?> map, String message) {
        Assert.assertTrue(message, map != null && !map.isEmpty());
    }

    // ==============================
    // Number Assertions
    // ==============================

    public void assertGreaterThan(Number actual, Number expected) {
        Assert.assertTrue(
                "Expected " + actual + " to be greater than " + expected,
                actual.doubleValue() > expected.doubleValue()
        );
    }

    public void assertLessThan(Number actual, Number expected) {
        Assert.assertTrue(
                "Expected " + actual + " to be less than " + expected,
                actual.doubleValue() < expected.doubleValue()
        );
    }

    // ==============================
    // API Specific Assertions
    // ==============================

    public void assertStatusCode(Response response, int expectedStatus) {
        assertNotNull(response, "Response is null");
        Assert.assertEquals(
                "Status code mismatch\nExpected: " + expectedStatus
                        + "\nActual: " + response.statusCode()
                        + "\nBody: " + response.asString(),
                expectedStatus,
                response.statusCode()
        );
    }

    public void assertSuccessStatus(Response response) {
        assertSuccessStatus(response, 200, 201);
    }

    public void assertSuccessStatus(Response response, int... allowedStatuses) {
        assertNotNull(response, "Response is null");
        int actual = response.statusCode();
        boolean matched = Arrays.stream(allowedStatuses).anyMatch(status -> status == actual);
        Assert.assertTrue(
                "Unexpected status code\nAllowed: " + Arrays.toString(allowedStatuses)
                        + "\nActual: " + actual
                        + "\nBody: " + response.asString(),
                matched
        );
    }

    public void assertResponseBodyNotBlank(Response response) {
        assertNotNull(response, "Response is null");
        assertNotBlank(response.asString(), "Response body is empty");
    }

    public void assertResponseContains(Response response, String expectedSubstring) {
        assertNotNull(response, "Response is null");
        assertContains(
                response.asString(),
                expectedSubstring,
                "Response body does not contain expected value"
        );
    }

    public void assertJsonPathEquals(Response response, String jsonPath, Object expected) {
        Object actual = response.jsonPath().get(jsonPath);
        Assert.assertEquals(
                "JSON path mismatch: " + jsonPath
                        + "\nExpected: " + expected
                        + "\nActual: " + actual,
                expected,
                actual
        );
    }

    public void assertJsonPathNotNull(Response response, String jsonPath) {
        Object value = response.jsonPath().get(jsonPath);
        Assert.assertNotNull("Expected JSON path to NOT be null: " + jsonPath, value);
    }

    // ==============================
    // Helper
    // ==============================

    private String buildMessage(String baseMessage, Object expected, Object actual) {
        return baseMessage
                + "\nExpected : " + expected
                + "\nActual   : " + actual;
    }
}
