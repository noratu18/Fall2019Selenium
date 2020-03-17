package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) throws InterruptedException{

        // binary the driver abd browsers
        // setup chromedriver
        WebDriverManager.chromedriver().setup();

        //create chrome driver object
        //WebDriver object --> Interface
        // I have a driver
        ChromeDriver driver = new ChromeDriver();

        // open some website
        //I want to open Google home page
        // How do you launch/open a web page?
        //by using get()--> url as String
        driver.get("http://google.com");

        //Navigations
        //navigate().to() --> open a web page

        // driver.navigate().to("http://www.google.com");

        //get() vs navigate().to()
        //get() --> wait to load the page
        //to() --> does no wait

        //navigate().back()-->
        //1. go to google
        //2. go to cybertek practice website

        driver.get("https://www.google.com");
        Thread.sleep(5000);;
        driver.navigate().to("http://practice.cybertekschool.com/");
        Thread.sleep(8000);
        driver.navigate().back();

        driver.close();


    }
}
