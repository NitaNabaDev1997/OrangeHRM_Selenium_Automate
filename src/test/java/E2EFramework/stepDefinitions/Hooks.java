package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks extends BaseTests {

   @After
    public void tearDown() {
       driver.close();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        //WebDriver driver=testContextSetup.testBase.WebDriverManager();
        if(scenario.isFailed()) {
            System.out.println("am here");
            File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent= FileUtils.readFileToByteArray(sourcepath);
            scenario.attach(fileContent,"image/png","image");

        }
    }
}
