package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {

        /*
        User story: As a user, I should be able to login VyTrack app.

        test case 1: login successfully
        1. go to Vytrack login page
        2. write username data: storemanager52
        3. write password data: UserUser123
        4. click login button
        5. Verify that user is on the homepage

        Test case2: login invalid crdeential
        1. go to login page
        2. write invalid username
        3. write invalid password
        4. click login button
        5. verify that user see error message "Invalid username or password"


         */

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        //find login button, and then click
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        //login button can be found and clicked directly
        //driver.findElement(By.id("submit")).click()

        // Verify that you are in the home page

        String expextedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if(expextedTitle.equals(actualTitle)){
            System.out.println("Pass!");
        }else{
            System.out.println("Fail!");
        }



    }
}
