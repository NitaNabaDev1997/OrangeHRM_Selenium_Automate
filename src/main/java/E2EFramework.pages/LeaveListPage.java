package E2EFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeaveListPage extends  BasePage{

    public LeaveListPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Leave List']")
    WebElement leave;

    @FindBy(xpath="(//div[@class='oxd-date-input']/input)[1]")
    WebElement fromdate;

    @FindBy(xpath="(//div[@class='oxd-date-input']/input)[2]")
    WebElement todate;

    @FindBy(css="div.oxd-calendar-date")
    List<WebElement> dates;

    @FindBy(css="div.oxd-calendar-header button.oxd-icon-button i.bi-chevron-left")
    WebElement leftarrow_calendar;

    @FindBy(css="div.oxd-calendar-header button.oxd-icon-button i.bi-chevron-right")
    WebElement rightarrow_calendar;

    @FindBy(css=".oxd-select-text-input")
    List<WebElement> dropdown;

    @FindBy(xpath="//span[text()='Pending Approval ']/i")
    WebElement preselectedText;

    @FindBy(css="div.oxd-select-dropdown .oxd-select-option")
    List<WebElement> dropdownoptions;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement search;


    public void clickLeaveList()
    {
        click(leave);
    }

    public void clickToClear()
    {
        preselectedText.click();
    }

    public void selectLeaveStatusDropDown(String leaveStatus)
    {
        click(dropdown.get(0));
        List<WebElement> leaveStatusoptions=dropdownoptions;

        for(WebElement e:leaveStatusoptions)
        {
            if(e.getText().equalsIgnoreCase(leaveStatus))
            {
                e.click();
                break;
            }
        }
    }

    public void clickFromDate()
    {
        fromdate.click();
    }

    public void clickToDate()
    {
        todate.click();
    }
    public void selectFromToDate(String expectedYear,String expectedDay,String expectedMonth) {

        //relocating visible year and month everytime the method is getting called to rectify staleelementreference exception

        WebElement year=driver.findElement(By.cssSelector("div.oxd-calendar-selector-year-selected p.oxd-text--p"));
        WebElement currentmonth=driver.findElement(By.cssSelector("div.oxd-calendar-selector-month-selected p.oxd-text--p"));
        String currentYear = year.getText();
        String curentMonth = currentmonth.getText();
        int year_result = Integer.parseInt(currentYear) - Integer.parseInt(expectedYear);

        int month_result = expectedMonth.compareTo(curentMonth);
        if (year_result > 0) {
            selectPastDate(year, expectedYear, expectedMonth, currentmonth, dates, expectedDay, leftarrow_calendar);
        } else if (year_result < 0)
            selectFutureDate(year, expectedYear, expectedMonth, currentmonth, dates, expectedDay, rightarrow_calendar);
        else {
            if (month_result > 0)
                selectFutureDate(year, expectedYear, expectedMonth, currentmonth, dates, expectedDay, rightarrow_calendar);
            else if (month_result < 0)
                selectPastDate(year, expectedYear, expectedMonth, currentmonth, dates, expectedDay, leftarrow_calendar);

        }
    }


    public void clickSearch()
    {
        search.click();
    }



}
