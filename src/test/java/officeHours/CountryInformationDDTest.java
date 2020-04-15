package officeHours;

import com.automation.utilities.Driver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//Java reads the file and then Apache POI opens the file

public class CountryInformationDDTest {

    WebDriver driver; // running singleton class makes easy to work
    Workbook workbook;
    Sheet workSheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    @BeforeMethod
    public void setup() throws IOException {
       driver = Driver.getDriver();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        fileInputStream = new FileInputStream("Countries.xlsx");
        workbook = WorkbookFactory.create(fileInputStream); // first we open the file/created workbook
        workSheet = workbook.getSheet("Countries");

    }

    @Test
    public void test(){
        int count = workSheet.getPhysicalNumberOfRows(); // number of rows
        System.out.println("count = " + count);
        boolean match = true;

        for (int i = 1; i < count; i++){
            Row currentRow = workSheet.getRow(i);
            String execute = currentRow.getCell(0).toString();//this loop gives the first column (execute)
            System.out.println("execute = " + execute);
            if(execute.equals("y")){
                //execute the test
                String country = currentRow.getCell(1).toString();
                String capital = currentRow.getCell(2).toString();
                driver.get("https://wikipedia.org"); // to open the url
                driver.findElement(By.id("searchInput")).sendKeys(country + Keys.ENTER);//opens each country in wikipedia
                String actual = driver.findElement(By.xpath("//th[starts-with(text(), 'Capital')]/following-sibling::td//a")).getText();
                new SoftAssert().assertEquals(actual,capital);
                if(actual.equals(capital)){
                    currentRow.getCell(3).setCellValue("PASS");
                }else {
                    currentRow.getCell(3).setCellValue("FAIL");
                    currentRow.createCell(4);
                    currentRow.getCell(4).setCellValue(actual);
                    match=false;
                }

            }else{
                //skip
                currentRow.getCell(3).setCellValue("SKIP");
                continue;
            }
        }
        Assert.assertTrue(match);

    }
    @AfterMethod
    public void tearDown() throws IOException {
        Driver.closeDriver();
        fileOutputStream = new FileOutputStream("Countries.xlsx");
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();
    }

}
/*
//th[starts-with(text(),'Capital')]/../td/a --> to findthe element that starts with text Capital
            find its parent
            find its other child
 */
