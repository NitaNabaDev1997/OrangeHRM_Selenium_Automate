package E2EFramework.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features/Login.feature", glue="E2EFramework.stepDefinitions",
monochrome = true,dryRun = false, plugin={"html:target/cucumber.html",""})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    //code
    //sample
}
