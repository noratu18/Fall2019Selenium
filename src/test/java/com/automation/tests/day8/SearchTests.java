package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it;s the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem : searchItems){
            String var = searchItem.getText();
            // var -> shortening for variable
            //if there is a Test - print it
            if(!var.isEmpty()){
                System.out.println(var);
                //verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
           // System.out.println(searchItem.getText());
        }
    }

    @BeforeMethod
    public void setup(){
        //setuo webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    public void tearDown(){
        //close web browser and detroy webdriver object
        driver.quit();
    }
}
