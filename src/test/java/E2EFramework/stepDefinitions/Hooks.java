package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class Hooks extends BaseTests {
    Properties p;
    WebDriver driver;
    @Before
    public void setUp() throws IOException {
        driver=BaseTests.initializedriver();
        p=BaseTests.getProperties();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();


    }
   @After(order=0)
    public void tearDown() {
      /* if (driver != null) {
           try {
               driver.close();
               threadLocal.remove();
           } catch (NoSuchSessionException e) {
               System.out.println("Session already closed: " + e.getMessage());
           }
       }*/

      BaseTests.removeDriver();
    }

    @AfterStep(order=1)
    public void AddScreenShot(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            logger.error("Test Failed......");
            logger.debug("debug logs......");
            System.out.println("am here");
            TakesScreenshot ts=(TakesScreenshot) driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());

        }
    }
}
