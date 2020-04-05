package officeHours;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitPractice extends AbstractTestBase {

    private WebDriver driver = Driver.getDriver();

     /*
    http://qa3.vytrack.com
    salesmanager110
    UserUser123

    ImplicitWait - set is 1 time and it will work for every findElement method
                - NoSuchElementException

    Thread.sleep -> not Selenium wait!!! Thread -> Java class, sleep() method of Thread class
        stops the execution of java program
        We never want to use this method in our tests

    Explicit Wait -> we have to declare every time before the iteration with element
            Expected Condition we are looking for

    Singleton -> it helps us to make sure we have only 1 instance of driver object at a time.



      */



     @Test
    public void testWait(){

         driver.get("http://qa3.vytrack.com");
         driver.manage().window().maximize();

         WebDriverWait webDriverWait = new WebDriverWait(driver,10);

         webDriverWait.until(ExpectedConditions.titleIs("Login"));

         WebElement user = driver.findElement(By.id("prependedInput"));
         WebElement password = driver.findElement(By.id("prependedInput2"));
         WebElement submit = driver.findElement(By.id("_submit"));

         user.sendKeys("salesmanager110");
         password.sendKeys("UserUser123");

         submit.click();

         WebElement account = driver.findElement(By.xpath("//span[.'Accounts']/following-sibling::span/following-sibling::a"));

         webDriverWait.until(ExpectedConditions.elementToBeClickable(account));

         BrowserUtils.wait(4);

         account.click();










     }

}
