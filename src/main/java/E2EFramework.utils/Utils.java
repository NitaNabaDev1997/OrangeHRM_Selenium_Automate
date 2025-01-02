package E2EFramework.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Utils {
public static WebDriver driver;
    public static WebDriver initializedriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\E2EFramework\\resources\\Config.properties");
        prop.load(fileInputStream);
        String browsername = prop.getProperty("browser");
        if (browsername.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browsername.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.get("https://www.google.com/");
        return driver;
    }

//    public static LoginLogoutPage launchbrowser() throws IOException {
//        driver=initializedriver();
//        LoginLogoutPage lgpage=new LoginLogoutPage(driver);
//        lgpage.launchbrowserUrl();
//        return lgpage;
//    }
}
