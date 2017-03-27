package runnerFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/java/features/LoginAAA",glue = "stepDefs",tags = {"~@ignore"},
plugin = {"pretty","json:Automation Reports/Latest Results/Json Reports/Test.json","html:Automation Reports/Latest Results/Html Reports/Test"})
public class Regression_Core_FeatureRunner extends AbstractTestNGCucumberTests {
	
}
