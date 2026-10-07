package runners;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features"},
 glue = {"stepDefinition.api"},tags ="@clm")

public class RunTests {
}
