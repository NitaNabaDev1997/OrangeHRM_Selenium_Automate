package E2EFramework.baseTest;

import E2EFramework.pages.LoginLogoutPage;
import E2EFramework.utils.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class BaseTests extends Utils{

    @Test
    public static LoginLogoutPage launchbrowser() throws IOException {
        driver=initializedriver();
        LoginLogoutPage lgpage=new LoginLogoutPage(driver);
        lgpage.launchbrowserUrl();
        return lgpage;
    }
}
