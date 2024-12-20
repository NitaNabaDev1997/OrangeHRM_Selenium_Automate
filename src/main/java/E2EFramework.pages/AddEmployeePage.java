package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddEmployeePage extends BasePage{
public static WebDriver driver;
    public AddEmployeePage(WebDriver driver)
    {
        super();
        this.driver=driver;
    }

    public void addemployeewithoutlogindetail()
    {
        driver.findElement(By.name("firstName")).sendKeys("TestName1");
        driver.findElement(By.name("middleName")).sendKeys("TestName2");
        driver.findElement(By.name("lastName")).sendKeys("TestName3");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
         }

    public String verifysucessmsg()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.oxd-text--toast-message.oxd-toast-content-text")));
        String toastmessge=toast.getText();
        return toastmessge;
    }
}
