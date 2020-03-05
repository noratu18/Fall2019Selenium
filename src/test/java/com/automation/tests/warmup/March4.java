package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {

    public static void main(String[] args) throws Exception{
        ebayTest();
        amazonTest();
        wikiTest();

    }

    /*
    Go to ebay
enter search term
click on search button
print number of results
     */

    public static void ebayTest(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement search = driver.findElement(By.tagName("h1"));
        System.out.println(search.getText());
        driver.quit();
    }

    /*
    go to amazon
enter search term
click on search button
verify title contains search term
     */

    public static void amazonTest(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
//        WebElement search = driver.findElement(By.className("<div class=\"a-section a-spacing-small a-spacing-top-small\">\n" +
//                "                <span dir=\"auto\">1-16 of over 4,000 results for</span><span dir=\"auto\"> </span><span class=\"a-color-state a-text-bold\" dir=\"auto\">\"java book\"</span>\n" +
//                "            </div>"));
        String title = driver.getTitle();

        if(title.contains("java book")) {
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        driver.quit();
    }

    /*
    Go to wikipedia.org
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
     */

    public static void wikiTest(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");


        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        String link = driver.getCurrentUrl(); // to get link as a String
        if(link.endsWith("Selenium_(software)")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        driver.quit();


    }
}
