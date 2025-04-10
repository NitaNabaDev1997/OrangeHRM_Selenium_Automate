package E2EFramework.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        return driver;
    }


public static List<HashMap<String,String>> dataReader(String filePath, String sheetName)
{


    List<HashMap<String,String>> empdata= new ArrayList<>();
    try
    {
        FileInputStream fs= new FileInputStream(filePath);
        XSSFWorkbook workbook= new XSSFWorkbook(fs);
        XSSFSheet sheet=workbook.getSheet(sheetName);
        Row headerRow=sheet.getRow(0);

        for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
        {
            Row currentRow=sheet.getRow(i);
            HashMap<String,String> currentmap= new HashMap<>();
            for(int j=0; j<currentRow.getPhysicalNumberOfCells();j++)
            {
                Cell currentcell=currentRow.getCell(j);
                switch (currentcell.getCellType())
                {
                    case STRING:
                        currentmap.put(headerRow.getCell(j).getStringCellValue(),currentcell.getStringCellValue());
                        break;
                }
            }
            empdata.add(currentmap);
        }

        fs.close();
    } catch (Exception e) {

        e.getMessage();
    }


return empdata;
}

}
