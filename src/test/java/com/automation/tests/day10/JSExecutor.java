package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

   // private WebDriver driver;
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
    //    driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();

    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down 250 pixels
        // x,y
        for(int i=0;i<10;i++){
            driver.executeScript("window.scrollBy(0,250)");
            BrowserUtils.wait(3);
        }

        BrowserUtils.wait(3);

    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //scrollIntoView -> javascript method
        //arguments[0] -> means 1st webelement after comma
        driver.executeScript("argumants[0].scrollIntoView(true)",link);

    }
}
