package officeHours;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Bitrix24UploadingFile {

    public void uploadFile(){
        WebDriver driver = Driver.getDriver();

        driver.get("https://login.nextbasecrm.com/");

        //login
        driver.findElement(By.id("USER_LOGIN")).sendKeys("helpdesk7@cybertek.com");
        driver.findElement(By.id("USER_PASSWORD")).sendKeys("UserUser", Keys.ENTER);

        BrowserUtils.wait(2);

        driver.findElement(By.id("microoPostFormLHE_blogPostForm")).click();
        BrowserUtils.wait(2);

        

    }
}
