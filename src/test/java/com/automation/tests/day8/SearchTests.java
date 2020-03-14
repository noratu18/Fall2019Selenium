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
                //if some of the search
                //doesn't contain java word, it will fail the test
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
           // System.out.println(searchItem.getText());
        }
    }
    /*
    Given user is on the amazon.com page
    When user enters "java" as a search item
    //Then user clicks on the search item
    //And user clicks on the first search item
    //And user verifies that title of the search item contains "java"
     */

    @Test(description = "Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        //there bis a chance that item is not visible
        //so we need to maximize the window before clicking on it
        driver.manage().window().maximize();

        BrowserUtils.wait(5);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(5);

        //find all links inside h2 elements, beacuse he elements is not clicklable itself
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));

        //click on the first item
        for(WebElement searchItem : searchItems){
            System.out.println("Title: " + searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(5);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));;

        //so h2 elements are not clickable, even though they contain links
        //that's why , instead off collelction all h2 elements
        //we collected all hyperlinks
        //everry hyperlink represent some search item

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
