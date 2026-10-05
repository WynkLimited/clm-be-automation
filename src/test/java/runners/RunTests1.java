package runners;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/microService/recommender/recommender.feature"},
        glue = {"stepDefinition.api"})

public class RunTests1 {
}
