package E2EFramework.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {".//Features/"}, glue="E2EFramework.stepDefinitions",
monochrome = true,publish = true, tags = "@LoginEmployee",plugin={"html:target/cucumber.html","json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    //code
    //sample
    //changed
}
