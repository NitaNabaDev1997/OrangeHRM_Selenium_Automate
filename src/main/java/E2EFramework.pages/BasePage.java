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
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void enterText(WebElement element,String txt)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(txt);
        }catch (Exception e)
        {
            throw e;
        }
    }

    public void enterText(By by,String txt)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            WebElement element=driver.findElement(by);
            element.clear();
            element.sendKeys(txt);
        }catch (Exception e)
        {
            throw e;
        }
    }

    public void click(WebElement element)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }catch (Exception e)
        {
            throw e;
        }
    }


    public void click(By by,String txt)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            WebElement element=driver.findElement(by);
            element.click();
        }catch (Exception e)
        {
            throw e;
        }
    }

    public void selectDropdown(List<WebElement> elementList,String option)
    {
        for(WebElement element:elementList)
        {
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase(option)) {
                element.click();
                break;
            }
        }


    }
}
