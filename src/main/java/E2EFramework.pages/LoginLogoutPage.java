package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLogoutPage extends BasePage{
public static WebDriver driver;
    public LoginLogoutPage(WebDriver driver) {
       super();
       this.driver=driver;
    }

    public static void login(String username, String password)
    {
       driver.findElement(By.name("username")).sendKeys("Admin");
       driver.findElement(By.name("password")).sendKeys("admin123");
       driver.findElement(By.tagName("button")).click();

    }
}
