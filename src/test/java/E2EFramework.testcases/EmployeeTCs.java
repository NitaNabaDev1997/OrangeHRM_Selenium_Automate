
package E2EFramework.testcases;

import E2EFramework.baseTest.BaseTests;
import E2EFramework.pages.*;
import E2EFramework.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import org.apache.logging.log4j.*;
public class EmployeeTCs extends BaseTests {
   // WebDriver driver;


    @Test
    public void loginValid() throws IOException {
        LoginLogoutPage loginLogoutPage =launchbrowser();
        //login with valid credential
        loginLogoutPage.login("Admin", "admin123");
        System.out.println("logged in successfully"+driver.getCurrentUrl());
        //driver.getCurrentUrl();
        logger.info("Login Successful");
    }

    @Test(dependsOnMethods = {"loginValid"})
    public void createEmployee() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMpage();

        AddEmployeePage addEmployee = new AddEmployeePage(driver);
        addEmployee.addemployeewithoutlogindetail();
        String actualmsg = addEmployee.verifysucessmsg();
        //System.out.println(actualmsg);
        Assert.assertEquals("Successfully Saved", actualmsg);

    }

    @Test(dependsOnMethods = {"createEmployee", "loginValid"})
    public void searchEmployee_negative() {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.searchemployee();
        String actualmsg = searchEmployee.verifymsg();
        Assert.assertEquals("No Records Found", actualmsg);
    }

    @Test(dependsOnMethods = {"createEmployee", "loginValid"})
    public void searchEmployee_positive() {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.searchemployee();
        searchEmployee.selectcheckbox();
        searchEmployee.deletebutton().click();
        String delmsg = searchEmployee.DeleteEmployee();
        Assert.assertTrue(delmsg.contains("Successfully Deleted"));

    }

}

