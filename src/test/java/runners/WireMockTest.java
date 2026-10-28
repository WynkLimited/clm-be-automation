package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/common/wiremock/wiremockPost.feature"},
        glue = {"stepDefinition.api"},
        tags = "@wiremock"
)
public class WireMockTest {
}
