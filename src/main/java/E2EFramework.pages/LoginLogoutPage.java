package E2EFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginLogoutPage extends BasePage{
public WebDriver driver;
    public LoginLogoutPage(WebDriver driver) {
       super(driver);
       this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="username")
    WebElement usernam;

    @FindBy(name="password")
    WebElement pass;

    @FindBy(tagName = "button")
    WebElement submitbtn;

    @FindBy(css=".oxd-userdropdown")
    WebElement dropdown;

    @FindBy(css=".oxd-userdropdown-link")
    List<WebElement> dropdownlist;

    @FindBy(xpath="//h5[text()='Login']")
    WebElement loginsymbol;

    public void login(String username, String password)
    {
        enterText(usernam,username);
        enterText(pass,password);
        click(submitbtn);
    }

    public void clickProfile()
    {
        click(dropdown);
    }
    public void clicklogout()
    {
        selectDropdown(dropdownlist,"Logout");
    }

    public String gettheText()
    {
        return loginsymbol.getText();
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

    public String getTitle()
    {
        return driver.getTitle();
    }
}
