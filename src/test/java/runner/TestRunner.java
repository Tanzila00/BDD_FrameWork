package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@smoke", features = "src/test/java/features", // define where is my feature
																		// file(src/main/java/features)
		glue = {"base","stepdefs"}, //base has steps setup for browser and stepdefs to run steps
		dryRun = false, 
		monochrome = true, 
		plugin = { "pretty", "html:target/report.html", "json:target/report.json" }// html report -in
																										// built
)
public class TestRunner {

}
