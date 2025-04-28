package E2EFramework.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Utils {
public static WebDriver driver;
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
    }
    catch (Exception e) {

        e.getMessage();
    }


return empdata;
}



    public List<HashMap<String,String>> getJsonDataToMap(String filepath) throws IOException {
        //read json to String
        String jsonContent= FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

        //String to HashMap databind
        ObjectMapper objectMapper= new ObjectMapper();
        List<HashMap<String,String>> data= objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }


}
