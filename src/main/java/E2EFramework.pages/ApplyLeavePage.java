package E2EFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ApplyLeavePage extends BasePage{

    WebDriver driver;
    public ApplyLeavePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='Leave']")
    WebElement leave;

    @FindBy(xpath = "//a[text()='Apply']")
    WebElement apply;

    @FindBy(css=".oxd-select-text-input")
    List<WebElement> dropdown;

    @FindBy(css="div.oxd-select-dropdown .oxd-select-option")
    List<WebElement> dropdownoptions;

    @FindBy(css="div.oxd-calendar-selector-month-selected p.oxd-text--p")
    WebElement currentmonth;

    @FindBy(css="div.oxd-calendar-selector-year-selected p.oxd-text--p")
    WebElement year;

    @FindBy(css="div.oxd-calendar-date")
    List<WebElement> dates;

    @FindBy(css="div.oxd-calendar-header button.oxd-icon-button i.bi-chevron-left")
    WebElement leftarrow_calendar;

    @FindBy(css="div.oxd-calendar-header button.oxd-icon-button i.bi-chevron-right")
    WebElement rightarrow_calendar;

    @FindBy(css=".orangehrm-left-space")
    WebElement applyleave;


    public void clickleave()
    {
        click(leave);
    }

    public void clickApply()
    {
        click(apply);
    }

    public void selectLeaveDropDown(String leavetype)
    {
        click(dropdown.get(0));
        List<WebElement> leaveoptions=dropdownoptions;

        for(WebElement e:leaveoptions)
        {
            if(e.getText().equalsIgnoreCase(leavetype))
            {
                e.click();
                break;
            }
        }
    }


    public void selectFromToDate(String expectedYear,String expectedMonth,String expectedDay)
    {
        String currentYear= year.getText();
        String curentMonth=currentmonth.getText();
        int year_result= Integer.parseInt(currentYear)-Integer.parseInt(expectedYear);

        int month_result=expectedMonth.compareTo(curentMonth);
        if(year_result>0) {
            selectPastDate(year, expectedYear, expectedMonth, currentmonth,dates, expectedDay, leftarrow_calendar);
        }
        else if(year_result<0)
            selectFutureDate(year,expectedYear,expectedMonth,currentmonth,dates,expectedDay,rightarrow_calendar);
        else if (year_result==0 && month_result>0) {
            selectFutureDate(year,expectedYear,expectedMonth,currentmonth,dates,expectedDay,rightarrow_calendar);
        } else if (year_result==0 && month_result<0) {
            selectPastDate(year, expectedYear, expectedMonth, currentmonth,dates, expectedDay, leftarrow_calendar);
        }
    }


}
