package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

    }

    /*
    Go to web orders page
    Click on "Check All" button
    Verify that all records are selected

     */

    @Test
    public void checkBoxText() {
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        BrowserUtils.wait(2);
        // List<WebElement> checkBox = driver.findElements(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement eachBox : checkBox) {

            Assert.assertTrue(eachBox.isSelected());

        }
    }
        /**
         * until 5:37
         * :: TASK for 10 minutes ::
         * Go to web orders page
         * Verify that Steve Johns zip code is 21233
         * Then update his zip code to 20002
         * Then verify that Steve Johns zip code is 20002
         */

        @Test
        public void updateZipCode(){

            WebElement zipCode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
            Assert.assertEquals(zipCode.getText(),"21233");

            //click on update image

            driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td/input")).click();

            WebElement zipCodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

            zipCodeInput.clear();
            zipCodeInput.sendKeys("20002");

            driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

            zipCode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));

            Assert.assertEquals(zipCode.getText(),"20002");




    }



    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}

