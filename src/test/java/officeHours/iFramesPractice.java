package officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class iFramesPractice {

    /*
    iFrame -> web document indisde of other web document (html inside of another html document)

     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //we landed to red webdocument -> default content
        BrowserUtils.wait(2);
        driver.switchTo().frame("frame-top");
        //we landed to blue webdocument ->
        List<WebElement> frames = driver.findElements(By.xpath("//frame"));
        /*
        We have stored all frames webElements inside the List
        1. We will loop through List
        2. Switch to each frame
            a. get text from body
            b. switch to the parent
         */

        for(int i=0; i<frames.size();i++){
            BrowserUtils.wait(2);
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Body text: "+ bodyText);
            driver.switchTo().parentFrame();


        }

        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: "+ bodyText);

        driver.switchTo().defaultContent();

    }
}
