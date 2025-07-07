package E2EFramework.stepDefinitions;

import E2EFramework.baseTest.BaseTests;
import E2EFramework.pages.*;
import E2EFramework.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class steps extends BaseTests {
    LoginLogoutPage loginLogoutPage;
    AddEmployeePage addEmployeePage;
    SearchEmployee searchEmployee;
    ApplyLeavePage applyLeavePage;
    LeaveListPage leaveListPage;
    private static ThreadLocal<HashMap<String, String>> testData = new ThreadLocal<>();
 @Given("User Launch Browser")
    public void launch_browser() {
     BaseTests.getLogger().info("Goto my account-->Click on Login.. ");
     loginLogoutPage=new LoginLogoutPage(BaseTests.getDriver());
     logger.info("User launches edge browser");
}

    @When("URL is hit")
    public void userOpenURL() {
    System.out.println("Url is open in successfully"+loginLogoutPage.getUrl());
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
    PIMPage pimPage= new PIMPage(BaseTests.getDriver());
    pimPage.clickPIMpage();
    }

    @And("User click on AddEmployee tab")
    public void userClickOnAddEmployeeTab() throws InterruptedException {
       addEmployeePage=new AddEmployeePage(BaseTests.getDriver()) ;
        addEmployeePage.addEmployee();
    }

    @Then("^User fills the details of new Employee (.+) and (.+) and (.+)$")
    public void userFillsTheDetailsOfNewEmployeeFirstnameMidnameLastname(String fname,String mname,String lname) throws InterruptedException {
        addEmployeePage.addemployeewithoutlogindetail(fname,mname,lname);
    }

    @And("User clicks on save button")
    public void userClicksOnSaveButton() {
        logger.info("button is clicked");
    }

    @Then("User is added successfully")
    public void userIsAddedSuccessfully() {
        logger.info("User is added");
    }


    @And("Clicks on Employee List menu item")
    public void clicksOnEmployeeListMenuItem() {
     searchEmployee= new SearchEmployee(BaseTests.getDriver());
        searchEmployee.clickemployeehistory();
    }

    @When("User searches for this employee from index {string}")
    public void userSearchsForThisEmployeeEmployeeName(String index) throws IOException {
        List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"/src/main/java/E2EFramework.utils/employee.json");
        int index1=Integer.parseInt(index);
        testData.set(data.get(index1));
        HashMap<String, String> currentData = testData.get();
        String username= currentData.get("employee");
        searchEmployee.searchemployee(username);
    }

    @And("clicks on Search button")
    public void clicksOnSearchButton() throws InterruptedException {
     searchEmployee.clicksearchbutton();
     Thread.sleep(2000);
    }


    @Then("it displays results for employee from index {string}")
    public void itDisplaysResultsForEmployeeEmployeeName(String index) throws IOException {

        List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"/src/main/java/E2EFramework.utils/employee.json");
        int index1=Integer.parseInt(index);
        String username= data.get(index1).get("employee");
        System.out.println(searchEmployee.displayresult(username));
    }


    @Then("User fills the details of new Employee from excel with row {string}")
    public void userFillsTheDetailsOfNewEmployeeFromExcelWithRowRowIndex(String row) throws InterruptedException {

     List<HashMap<String,String>> datamap= Utils.dataReader(System.getProperty("user.dir")+"\\testData\\EmployeeData.xlsx","Sheet1");

     int index=Integer.parseInt(row)-1;
     testData.set(datamap.get(index));
     HashMap<String, String> currentData = testData.get();
     
     String fname=currentData.get("firstname");
     String midname=currentData.get("middlename");
     String lastname=currentData.get("lastname");
     String expresult=currentData.get("expected");

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
                Assert.fail("Success message is null or doesn't contain 'Saved'");
         }

         else
         {
             if(expresult.equals("Invalid"))
             {
                 if(msg.contains("Saved"))
                 {
                     Assert.fail("Success message is null or doesn't contain 'Saved'");
                 }
                 else
                     Assert.assertTrue(true);
             }
         }

     }catch (Exception e)
     {
         Assert.fail("Success message is null or doesn't contain 'Saved'");
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


    @When("User click on Leave")
    public void userClickOnLeave() {
     applyLeavePage= new ApplyLeavePage(BaseTests.getDriver());
     applyLeavePage.clickleave();
    }

    @And("User click on Apply Button")
    public void userClickOnApplyButton() {
        applyLeavePage.clickApply();

        
    }

    @Then("User selects leave type {string} from dropdown")
    public void userSelectsLeaveTypeFromDropdown(String leaveType) throws InterruptedException {
      applyLeavePage.selectLeaveDropDown(leaveType);
        Thread.sleep(2000);
    }



    @Then("User click on apply")
    public void userClickOnApply() {


    }

    @And("User selects from date {string} from calendar")
    public void userSelectsFromDateFromCalendar(String fromDate) throws InterruptedException {
     leaveListPage.clickFromDate();
     Thread.sleep(1000);
    List<String> yeardatemonth=getYearDateMonthvalue(fromDate);
    leaveListPage.selectFromToDate(yeardatemonth.get(0),yeardatemonth.get(1),yeardatemonth.get(2));
    Thread.sleep(2000);

    }

    @And("User selects to date {string} from calendar")
    public void userSelectsToDateFromCalendar(String ToDate) throws InterruptedException {
       leaveListPage.clickToDate();
       Thread.sleep(2000);
       List<String> yeardatemonth=getYearDateMonthvalue(ToDate);
        leaveListPage.selectFromToDate(yeardatemonth.get(0),yeardatemonth.get(1),yeardatemonth.get(2));
        Thread.sleep(2000);
    }

    @And("Leave is applied successfully")
    public void leaveIsAppliedSuccessfully() {
    }

    @And("User click on LeaveList Button")
    public void userClickOnLeaveListButton() {
     leaveListPage=new LeaveListPage(BaseTests.getDriver());
     leaveListPage.clickLeaveList();
    }

    @Then("User selects leave status {string} from dropdown")
    public void userSelectsLeaveStatusFromDropdown(String leaveStatus) throws InterruptedException {
     leaveListPage.clickToClear();
     leaveListPage.selectLeaveStatusDropDown(leaveStatus);
     Thread.sleep(2000);
    }

    @Then("User click on search")
    public void userClickOnSearch() {
    }

    @And("result is displayed successfully")
    public void resultIsDisplayedSuccessfully() {
    }



}
