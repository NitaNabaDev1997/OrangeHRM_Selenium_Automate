package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLogoutPage extends BasePage{
public static WebDriver driver;
    public LoginLogoutPage(WebDriver driver) {
       super(driver);
       this.driver=driver;
    }

    public void launchbrowserUrl()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public void login(String username, String password)
    {
       driver.findElement(By.name("username")).sendKeys("Admin");
       driver.findElement(By.name("password")).sendKeys("admin123");
       driver.findElement(By.tagName("button")).click();
    }

    public void clickProfile()
    {
        driver.findElement(By.cssSelector(".oxd-userdropdown")).click();
    }
    public void clicklogout()
    {
        selectDropdown("Logout");
    }
}
