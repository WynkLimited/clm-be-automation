package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/clm/audienceManager/audienceManager.feature"},
        glue = {"stepDefinition.api"},
        tags = "@clm"
)
public class RunTests {
}
