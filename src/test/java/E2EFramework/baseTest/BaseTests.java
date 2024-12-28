package E2EFramework.baseTest;

import E2EFramework.pages.LoginLogoutPage;
import E2EFramework.testcases.EmployeeTCs;
import E2EFramework.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class BaseTests extends Utils{
    public static Logger logger= LogManager.getLogger(EmployeeTCs.class);
    @Test
    public static LoginLogoutPage launchbrowser() throws IOException {
        driver=initializedriver();
        LoginLogoutPage lgpage=new LoginLogoutPage(driver);
        logger.info("Driver initialized");
        lgpage.launchbrowserUrl();
        logger.info("browser lauched");
        return lgpage;
    }
}
