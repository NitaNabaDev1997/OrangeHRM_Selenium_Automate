package E2EFramework.baseTest;

import E2EFramework.pages.LoginLogoutPage;
//import E2EFramework.testcases.EmployeeTCs;
import E2EFramework.utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseTests extends Utils{
    public static Logger logger;
    static Properties prop;
    public static WebDriver initializedriver() throws IOException {

        String browsername = System.getProperty("browser")!=null? System.getProperty("browser"):getProperties().getProperty("browser");
        if (browsername.equalsIgnoreCase("Edge")) {
            // WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browsername.equalsIgnoreCase("chrome"))
        {
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static Properties getProperties() throws IOException
    {
        FileReader file=new FileReader(System.getProperty("user.dir")+"/src/main/java/E2EFramework/resources/Config.properties");

        prop=new Properties();
        prop.load(file);
        return prop;
    }

    protected static WebDriver getDriver()
    {
        return driver;
    }

    public static Logger getLogger()
    {
        logger=LogManager.getLogger(BaseTests.class); //Log4j
        return logger;
    }


}
