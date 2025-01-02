package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage{
    public static WebDriver driver;
    public PIMPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }

    public void clickPIMpage()
    {
        driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper']//span[text()='PIM']")).click();
    }
}
