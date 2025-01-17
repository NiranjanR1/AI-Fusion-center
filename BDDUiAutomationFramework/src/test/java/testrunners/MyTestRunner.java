package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/AIFusion" }, glue = { "stepDefs", }, plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/",
		"html:target/htmlReport.html" }, tags = "@test1"
)

public class MyTestRunner {

}
