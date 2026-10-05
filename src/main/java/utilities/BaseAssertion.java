package utilities;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Collection;

public class BaseAssertion {

    // ==============================
    // Core Equality
    // ==============================

    protected void assertEquals(Object actual, Object expected) {

        Assert.assertEquals(
                buildMessage("Values are not equal", expected, actual),
                expected,
                actual
        );
    }

    protected void assertNotEquals(Object actual, Object expected) {
        Assert.assertNotEquals(
                buildMessage("Values should NOT be equal", expected, actual),
                expected,
                actual
        );
    }

    // ==============================
    // Boolean
    // ==============================

    protected void assertTrue(boolean condition) {
        Assert.assertTrue("Expected condition to be TRUE but was FALSE", condition);
    }

    protected void assertFalse(boolean condition) {
        Assert.assertFalse("Expected condition to be FALSE but was TRUE", condition);
    }

    // ==============================
    // Null Checks
    // ==============================

    protected void assertNotNull(Object object) {
        Assert.assertNotNull("Expected object to be NOT NULL but was NULL", object);
    }

    protected void assertNull(Object object) {
        Assert.assertNull("Expected object to be NULL but was NOT NULL", object);
    }

    // ==============================
    // String Assertions
    // ==============================

    protected void assertContains(String actual, String expectedSubstring) {
        Assert.assertTrue(
                "Expected string to contain: " + expectedSubstring +
                        "\nActual: " + actual,
                actual != null && actual.contains(expectedSubstring)
        );
    }

    protected void assertStartsWith(String actual, String prefix) {
        Assert.assertTrue(
                "Expected string to start with: " + prefix +
                        "\nActual: " + actual,
                actual != null && actual.startsWith(prefix)
        );
    }

    protected void assertEndsWith(String actual, String suffix) {
        Assert.assertTrue(
                "Expected string to end with: " + suffix +
                        "\nActual: " + actual,
                actual != null && actual.endsWith(suffix)
        );
    }

    // ==============================
    // Collection Assertions
    // ==============================

    protected void assertCollectionNotEmpty(Collection<?> collection) {
        Assert.assertTrue(
                "Expected collection to NOT be empty",
                collection != null && !collection.isEmpty()
        );
    }

    protected void assertCollectionSize(Collection<?> collection, int expectedSize) {
        Assert.assertEquals(
                "Collection size mismatch\nExpected: " + expectedSize +
                        "\nActual: " + (collection == null ? 0 : collection.size()),
                expectedSize,
                collection == null ? 0 : collection.size()
        );
    }

    protected void assertCollectionContains(Collection<?> collection, Object value) {
        Assert.assertTrue(
                "Expected collection to contain: " + value,
                collection != null && collection.contains(value)
        );
    }

    // ==============================
    // Number Assertions
    // ==============================

    protected void assertGreaterThan(Number actual, Number expected) {
        Assert.assertTrue(
                "Expected " + actual + " to be greater than " + expected,
                actual.doubleValue() > expected.doubleValue()
        );
    }

    protected void assertLessThan(Number actual, Number expected) {
        Assert.assertTrue(
                "Expected " + actual + " to be less than " + expected,
                actual.doubleValue() < expected.doubleValue()
        );
    }

    // ==============================
    // API Specific Assertions
    // ==============================

    protected void assertJsonPathEquals(Response response, String jsonPath, Object expected) {
        Object actual = response.jsonPath().get(jsonPath);
        Assert.assertEquals(
                "JSON path mismatch: " + jsonPath +
                        "\nExpected: " + expected +
                        "\nActual: " + actual,
                expected,
                actual
        );
    }

    protected void assertJsonPathNotNull(Response response, String jsonPath) {
        Object value = response.jsonPath().get(jsonPath);
        Assert.assertNotNull("Expected JSON path to NOT be null: " + jsonPath, value);
    }

    protected void assertStatusCode(Response response, int expectedStatus) {
        Assert.assertEquals(
                "Status code mismatch\nExpected: " + expectedStatus +
                        "\nActual: " + response.statusCode(),
                expectedStatus,
                response.statusCode()
        );
    }

    // ==============================
    // Helper
    // ==============================

    private String buildMessage(String baseMessage, Object expected, Object actual) {
        return baseMessage +
                "\nExpected : " + expected +
                "\nActual   : " + actual;
    }
}

