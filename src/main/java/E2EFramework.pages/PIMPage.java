package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage{
    public static WebDriver driver;
    public PIMPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }

    @FindBy(xpath="//li[@class='oxd-main-menu-item-wrapper']//span[text()='PIM']")
    WebElement pim;

    public void clickPIMpage()
    {
       click(pim);
    }
}
