package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchEmployee extends BasePage {
    public static WebDriver driver;
    public SearchEmployee(WebDriver driver)
    {
      super(driver);
      this.driver=driver;
    }

    public void clickemployeehistory()
    {
        driver.findElement(By.linkText("Employee List")).click();
    }

    public void searchemployee(String username)
    {
    driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys(username);
    //driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("0399");
    //selectionEmployeestatus("Freelance");

    }

    public void clicksearchbutton()
    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }


    public WebElement deletebutton()
    {
       WebElement deletebutton =driver.findElement(By.xpath("//button[contains(.,'Delete Selected')]"));
        System.out.println("Delete button displayed"+deletebutton.isEnabled());
       return deletebutton;
    }

   /* public WebElement selectionEmployeestatus(String statusname) {
        WebElement dropdown_employeestatus = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
        Select employeestatus = new Select(dropdown_employeestatus);
        employeestatus.selectByVisibleText(statusname);
        WebElement selectedoption = employeestatus.getFirstSelectedOption();
        return selectedoption;
    }*/
   public void selectionEmployeestatus(String statusname) {
      driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
       List<WebElement> dropdown_employeestatus=driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
       for (WebElement element : dropdown_employeestatus) {
           if (element.getText().equals(statusname)) {
               element.click();
               break;
           }
       }
   }

   public String verifymsg()
   {
      WebElement toast= driver.findElement(By.cssSelector("p.oxd-text--toast-message.oxd-toast-content-text"));
      String toastmsg=toast.getText();
      return toastmsg;
   }

    public void selectcheckbox(String username) throws InterruptedException {

       String messge=verifymsg();
       if(messge.equals("No Records Found"))
       {
           System.out.println("User not found");
       }
       else {
           WebElement table = driver.findElement(By.xpath("//div[@class='oxd-table-card']"));
           List<WebElement> rows = table.findElements(By.xpath("//div[@role='row']"));
           for (WebElement element : rows) {
               if (element.getText().contains(username)) {
                   driver.findElement(By.xpath("//div[@class='oxd-table-card-cell-checkbox']")).click();
               }
           }
       }
        }

    
    public String DeleteEmployee()
    {
      driver.findElement(By.xpath("//button[contains(.,'Yes, Delete')]")).click();
      String deleteempmsg=driver.findElement(By.cssSelector("p.oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")).getText();
      return deleteempmsg;
    }



}
