package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue={"step_Definitions"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
