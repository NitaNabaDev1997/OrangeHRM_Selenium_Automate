package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage extends BasePage{
public WebDriver driver;
    public AddEmployeePage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }

    public void addEmployee()
    {
        driver.findElement(By.linkText("Add Employee")).click();
    }

    public void addemployeewithoutlogindetail(String firstname,String middlename,String lastname) throws InterruptedException {
        driver.findElement(By.name("firstName")).sendKeys(firstname);
        driver.findElement(By.name("middleName")).sendKeys(middlename);
        driver.findElement(By.name("lastName")).sendKeys(lastname);
        Thread.sleep(1000);
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
