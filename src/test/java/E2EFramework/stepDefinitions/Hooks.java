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
        if(scenario.isFailed()) {
            System.out.println("am here");
            TakesScreenshot ts=(TakesScreenshot) driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());

        }
    }
}
