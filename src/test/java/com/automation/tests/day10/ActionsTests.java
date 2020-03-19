package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        actions = new Actions(driver);

    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        //paranthesis() used when there more then one tag or element
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //perform()-->start the action
        //buil() --> when you have couple of actions(combines)
        //always end with perform
        //build().perform() -->goes together if there is more then one action
        //pause()--> like Thread.sleep(1000)
        //moveToElement -> returns instance of action class that's why we can chain them
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        BrowserUtils.wait(3);

        //hover on the first image
        //verify that "name: user1" is displayed
        //hover over image you make text visible
        actions.moveToElement(img1).perform();
         WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
         //verify that webElement that conatins the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        //move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(img2.isDisplayed());
    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        //hover on "enabled"
        //hover on "download"
        //click on PDF
        WebElement enabled = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
        WebElement download = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));
        WebElement pdf = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));

        actions.moveToElement(enabled).
                pause(1000).
                moveToElement(download).
                pause(1000).
                click(pdf).build().perform();

    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);
        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();

        BrowserUtils.wait(5);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));


        actions.dragAndDrop(moon,earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual,expected);


    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();

    }

}
