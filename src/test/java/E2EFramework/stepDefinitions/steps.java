package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import E2EFramework.pages.AddEmployeePage;
import E2EFramework.pages.LoginLogoutPage;
import E2EFramework.pages.PIMPage;
import E2EFramework.pages.SearchEmployee;
import E2EFramework.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class steps extends BaseTests {
    LoginLogoutPage loginLogoutPage;
    AddEmployeePage addEmployeePage;
    SearchEmployee searchEmployee;
    List<HashMap<String,String>> datamap;
 @Given("User Launch Browser")
    public void launch_browser() {
     BaseTests.getLogger().info("Goto my account-->Click on Login.. ");
     loginLogoutPage=new LoginLogoutPage(BaseTests.getDriver());
     logger.info("User launches edge browser");
}

    @When("URL is hit")
    public void userOpenURL() {
    System.out.println("Url is open in successfully"+driver.getCurrentUrl());
    logger.info("Url is open and printed in console");
    }


    @And("User Enters Username  {string} and Password  {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        loginLogoutPage.login(username,password);
    }

    @And("Click on Login button")
    public void clickOnLogin() {
    logger.info("login button clicked");
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
        //logger.info(addEmployeePage.verifysucessmsg());
        logger.info("User is added");
    }


    @And("Clicks on Employee List menu item")
    public void clicksOnEmployeeListMenuItem() {
     searchEmployee= new SearchEmployee(driver);
        searchEmployee.clickemployeehistory();
    }

    @When("User searches for this employee from index {string}")
    public void userSearchsForThisEmployeeEmployeeName(String index) throws IOException {
        List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"/src/main/java/E2EFramework.utils/employee.json");
       /* for (HashMap<String, String> record : data) {
            String username = record.get("employee"); // Assuming the key in JSON is "username"
            //System.out.println(username);
            // Pass the username to the search method
            searchEmployee.searchemployee(username);
        }*/
        int index1=Integer.parseInt(index);
        String username= data.get(index1).get("employee");
        searchEmployee.searchemployee(username);
            // Optionally add steps to verify the results for each search
    }

    @And("clicks on Search button")
    public void clicksOnSearchButton() throws InterruptedException {
     searchEmployee.clicksearchbutton();
     Thread.sleep(2000);
    }


    @Then("it displays results for employee from index {string}")
    public void itDisplaysResultsForEmployeeEmployeeName(String index) throws IOException {

        List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"/src/main/java/E2EFramework.utils/employee.json");
        /*for (HashMap<String, String> record : data) {
            String username = record.get("employee"); // Assuming the key in JSON is "username"

            // Pass the username to the search method
            System.out.println(searchEmployee.displayresult(username));
        }*/

        int index1=Integer.parseInt(index);
        String username= data.get(index1).get("employee");
        System.out.println(searchEmployee.displayresult(username));
    }


    @Then("User fills the details of new Employee from excel with row {string}")
    public void userFillsTheDetailsOfNewEmployeeFromExcelWithRowRowIndex(String row) {

     datamap= Utils.dataReader(System.getProperty("user.dir")+"\\testData\\EmployeeData.xlsx","Sheet1");

     int index=Integer.parseInt(row)-1;
        //System.out.println(index);

     String fname=datamap.get(index).get("firstname");
     String midname=datamap.get(index).get("middlename");
     String lastname=datamap.get(index).get("lastname");
     String expresult=datamap.get(index).get("expected");

     addEmployeePage.addemployeewithoutlogindetail(fname,midname,lastname);

     try{

         String msg=addEmployeePage.verifysucessmsg();
         if(expresult.equals("Valid"))
         {
            if(msg.contains("Saved"))
            {

            Assert.assertTrue(true);
            }
            else
                Assert.fail();
         }

         else
         {
             if(expresult.equals("Invalid"))
             {
                 if(msg.contains("Saved"))
                 {
                     Assert.fail();
                 }
                 else
                     Assert.assertTrue(true);
             }
         }

     }catch (Exception e)
     {
         Assert.fail();
     }

    }

    @When("User clicks on select all")
    public void userClicksOnSelectAll() {
        searchEmployee.selectcheckbox();
    }

    @And("clicks on delete button")
    public void clicksOnDeleteButton() {
        searchEmployee.deletebutton();
    }

    @Then("confirmation pop up will appear")
    public void confirmationPopUpWillAppear() {
        System.out.println("Delete msg appear "+ searchEmployee.popup());
    }

    @And("record will be deleted")
    public void recordWillBeDeleted() {
     searchEmployee.DeleteEmployee();
    }

}
