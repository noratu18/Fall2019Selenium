package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookItTitleVerify {

    public static void main(String[] args) {
        /*
        Task 1:
        1. Go to Bookit login page
        https://cybertek-reservation-qa.herokuapp.com/sign-in
        2. Verify the title of the page
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");

        driver.manage().window().maximize();

        // expected vs actual result

        String expectedTitle = "bookit";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
            System.out.println("I expect to see" + expectedTitle);
            System.out.println("The driver get " + actualTitle);
        }

        driver.close();



    }
}
