package cucmberAmazon.test.amazon;




import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucmberAmazon/test/amazon/Features", 
glue = "cucmberAmazon.test.amazon.StepDefinitions",
plugin = {"pretty", "html:target/results.html"},
publish = true)
public class TestRunner {

}
