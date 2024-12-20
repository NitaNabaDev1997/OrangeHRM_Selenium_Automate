package E2EFramework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static WebDriver launchbrowser()
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //driver.get("https://www.google.com/");
        return driver;
    }
}
