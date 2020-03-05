package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {

    public static void main(String[] args) throws InterruptedException {

        //Locator 1.id

        // task:
        // go to cybertek okta login page
        //write email to the text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cybertekschool.okta.com/");
        driver.manage().window().maximize();

        //write email to the text box
        //1. Find the text box first --> findElement() from WebDriver


        Thread.sleep(3000);
        WebElement emailBox = driver.findElement(By.id("okta-signin-username"));

        emailBox.sendKeys("noratukesh@gmail.com");

        //write your password to the password text box

        Thread.sleep(3000);
        driver.findElement(By.id("okta-signin-password")).sendKeys("123abc");



    }
}
