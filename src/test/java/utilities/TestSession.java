package utilities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple per-thread session store (replaces Serenity session variables).
 */
public final class TestSession {

    private static final ThreadLocal<Map<String, Object>> STORE =
            ThreadLocal.withInitial(ConcurrentHashMap::new);

    private TestSession() {
    }

    public static void set(String key, Object value) {
        STORE.get().put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) STORE.get().get(key);
    }

    public static void clear() {
        STORE.remove();
    }
}
