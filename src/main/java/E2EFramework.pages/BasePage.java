package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void waitforElementToClick(By findBy)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public void selectDropdown(String option)
    {
        //WebElement dropdownelement = null;
        List<WebElement> elementList=driver.findElements(By.cssSelector(".oxd-userdropdown-link"));
        for(WebElement element:elementList)
        {
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase(option)) {
                element.click();
                break;
            }
        }
       // return dropdownelement;

    }
}
