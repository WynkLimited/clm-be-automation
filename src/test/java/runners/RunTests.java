
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/microService/arsenal/arsenal.feature"},
 glue = {"stepDefinition.api"},tags ="@aerospike")

public class RunTests {
}
