package E2EFramework.baseTest;

import E2EFramework.pages.*;
import E2EFramework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTCs {
    WebDriver driver;


    @Test
    public void loginValid()
    {
   driver= Utils.launchbrowser();
   LoginLogoutPage loginLogoutPage = new LoginLogoutPage(driver);
   //login with valid credential
        LoginLogoutPage.login("Admin","admin123");
        System.out.println("logged in successfully"+driver.getCurrentUrl());
        //driver.getCurrentUrl();
    }

    @Test(dependsOnMethods = {"loginValid"})
    public void createEmployee()
    {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMpage();

        AddEmployeePage addEmployee= new AddEmployeePage(driver);
        addEmployee.addemployeewithoutlogindetail();
        String actualmsg= addEmployee.verifysucessmsg();
        //System.out.println(actualmsg);
        Assert.assertEquals("Successfully Saved",actualmsg);

    }
@Test(dependsOnMethods = {"createEmployee","loginValid"})
    public void searchEmployee_negative()
    {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.searchemployee();
        String actualmsg= searchEmployee.verifymsg();
        Assert.assertEquals("No Records Found",actualmsg);
    }
    @Test(dependsOnMethods = {"createEmployee","loginValid"})
    public void searchEmployee_positive()
    {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.searchemployee();
        searchEmployee.selectcheckbox();
        String actualmsg= searchEmployee.deletemsgbutton().getText();
        //Assert.assertTrue(actualmsg.contains("Record Found"));
        searchEmployee.deletemsgbutton().click();
    }

}
