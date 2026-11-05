package runners;

import com.airtel.helper.report.ReportFrameworkConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {ReportFrameworkConfig.CUCUMBER_CHAINTEST_PLUGIN},
        features = {"src/test/resources/features/clm/audienceManager/audienceManager.feature"},
        glue = {
                "stepDefinition.api",
                ReportFrameworkConfig.CHAINTTEST_HOOKS_GLUE
        },
        tags = "@clm",
        monochrome = true
)
public class RunTests {
}
