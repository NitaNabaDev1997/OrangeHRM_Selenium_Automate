package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import E2EFramework.pages.LoginLogoutPage;
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static E2EFramework.baseTest.BaseTests.launchbrowser;

public class Steps extends BaseTests {
@Given("User Launch Edge Browser")
    public void user_launch_browser() throws IOException {
    LoginLogoutPage loginLogoutPage =launchbrowser();
    //logger.info("User launches edge browser");
}
}
