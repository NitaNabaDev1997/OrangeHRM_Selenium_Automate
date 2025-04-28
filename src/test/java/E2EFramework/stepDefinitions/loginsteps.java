package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import E2EFramework.pages.LoginLogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class loginsteps extends BaseTests {
    LoginLogoutPage loginLogoutPage;
    @Given("User Launch Edge Browser")
    public void user_launch_browser() throws IOException {
        BaseTests.getLogger().info("Goto my account-->Click on Login.. ");
        loginLogoutPage=new LoginLogoutPage(BaseTests.getDriver());
        logger.info("User launches edge browser");
    }

    @When("User open URL")
    public void userOpenURL() {
        System.out.println("Url is open in successfully"+driver.getCurrentUrl());
        logger.info("Url is open and printed in console");
    }


    @And("User Enters Username as {string} and Password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        loginLogoutPage.login(username,password);
    }

    @And("Click on Login")
    public void clickOnLogin() {
        logger.info("login button clicked");
    }


    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String title) {
        String logintitle=driver.getTitle();
        Assert.assertEquals(logintitle,title);
    }

    @When("User click on profile link")
    public void userClickOnProfileLink() {
        loginLogoutPage.clickProfile();
    }

    @And("click on Logout link")
    public void clickOnLogoutLink() {
        loginLogoutPage.clicklogout();
    }

    @Then("User should be on Login Page")
    public void landloginpage() {
       String text= loginLogoutPage.gettheText();
        Assert.assertEquals(text,"Login","Not successfully logged out");
    }
}
