package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import E2EFramework.pages.AddEmployeePage;
import E2EFramework.pages.LoginLogoutPage;
import E2EFramework.pages.PIMPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class Steps extends BaseTests {
    LoginLogoutPage loginLogoutPage;
    AddEmployeePage addEmployeePage;
@Given("User Launch Edge Browser")
    public void user_launch_browser() throws IOException {
    loginLogoutPage = launchbrowser();
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

    @Then("close the browser")
    public void closeTheBrowser() {
   driver.quit();
    }

    @When("User click on PIM item")
    public void userClickOnPIMItem() {
    PIMPage pimPage= new PIMPage(driver);
    pimPage.clickPIMpage();
    }

    @And("User click on AddEmployee tab")
    public void userClickOnAddEmployeeTab() throws InterruptedException {
       addEmployeePage=new AddEmployeePage(driver) ;
        addEmployeePage.addEmployee();
    }

    @Then("^User fills the details of new Employee (.+) and (.+) and (.+)$")
    public void userFillsTheDetailsOfNewEmployeeFirstnameMidnameLastname(String fname,String mname,String lname) {
        addEmployeePage.addemployeewithoutlogindetail(fname,mname,lname);
    }

    @And("User clicks on save button")
    public void userClicksOnSaveButton() {
        logger.info("button is clicked");
    }

    @Then("User is added successfully")
    public void userIsAddedSuccessfully() {
        logger.info(addEmployeePage.verifysucessmsg());
    }
}
