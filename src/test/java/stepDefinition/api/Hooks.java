package stepDefinition.api;

import io.cucumber.java.After;
import utilities.TestSession;

/**
 * LOB-only cleanup. ChainTest bind/unbind + Teams summary come from
 * {@link com.airtel.helper.report.ChainTestHooks} via {@code CHAINTTEST_HOOKS_GLUE}.
 */
public class Hooks {

    @After(order = 0)
    public void clearSession() {
        TestSession.clear();
    }
}
