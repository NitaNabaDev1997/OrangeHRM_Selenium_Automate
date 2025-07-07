package E2EFramework.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {".//Features/LeaveManagement.feature"}, //features= {"@target/rerun.txt"},
 glue="E2EFramework.stepDefinitions",
monochrome = true,publish = true, tags = "@CheckLeave",plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
