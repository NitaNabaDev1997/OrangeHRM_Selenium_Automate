package E2EFramework.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features/Employee.feature", glue="E2EFramework.stepDefinitions",
monochrome = true,dryRun = true, plugin={"html:target/cucumber.html","json:target/cucumber.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    //code
    //sample
    //changed
}
