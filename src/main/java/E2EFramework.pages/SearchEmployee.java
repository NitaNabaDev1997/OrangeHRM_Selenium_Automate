package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchEmployee extends BasePage {
    public static WebDriver driver;
    public SearchEmployee(WebDriver driver)
    {
      super(driver);
      this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement toast;

    @FindBy(xpath="//div[contains(@class,'orangehrm-vertical-padding')]/span")
    WebElement records;
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
      String toastmsg=toast.getText();
      return toastmsg;
   }

    public void selectcheckbox(String username) throws InterruptedException {

       if(records.getText().contains("No Records Found"))
       {
           System.out.println(verifymsg());
       }
       else if(records.getText().contains("Records Found")){
           WebElement table = driver.findElement(By.xpath("//div[@class='oxd-table-card']"));
           List<WebElement> rows = table.findElements(By.xpath("//div[@role='row']"));
           //List<WebElement> checkboxes=driver.findElements(By.xpath("//div[@class='oxd-table-card-cell-checkbox']"));
           for (int i=0;i<rows.size();i++) {
               if (rows.get(i).getText().contains(username)) {
                   table.findElement(By.xpath("(//div[@class='oxd-table-card-cell-checkbox'])["+i+"]")).click();
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
