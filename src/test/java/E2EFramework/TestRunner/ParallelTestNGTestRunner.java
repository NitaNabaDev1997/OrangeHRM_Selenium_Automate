package E2EFramework.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {".//Features/Employee.feature"}, //features= {"@target/rerun.txt"},
 glue="E2EFramework.stepDefinitions",
monochrome = true,publish = true, tags = "@LoginDataDrivenAddEmployee",plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class ParallelTestNGTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

}
