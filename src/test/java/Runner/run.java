package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "./src/test/resources/Features/log.feature",
    glue = {"Stepdef"},
    plugin = {"pretty", "html:reports/cucumber-report.html"},
    monochrome = true
)	

public class run {

	
}
