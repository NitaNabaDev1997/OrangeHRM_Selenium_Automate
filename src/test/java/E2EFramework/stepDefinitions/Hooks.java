package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;

public class Hooks extends BaseTests {
    @Before
    public void setUp() throws IOException {
        //loginLogoutPage = launchbrowser();
    logger.info("Test started...");
    }
   @After
    public void tearDown() {
       if (driver != null) {
           try {
               driver.close();
           } catch (NoSuchSessionException e) {
               System.out.println("Session already closed: " + e.getMessage());
           }
       }
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
