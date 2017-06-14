package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:", glue = "classpath:", tags = {"@runnable", "~@unfinished"}, dryRun = true)
//@CucumberOptions(format = { "json:target/cucumber.json", "pretty", "html:target/cucumber.html" }, resources.features = "src/tests/resources.features/", tags = {"@runnable", "~@unfinished"}, glue = "src/tests/resources.steps/", dryRun = true)
public class RunAllDry {
}
