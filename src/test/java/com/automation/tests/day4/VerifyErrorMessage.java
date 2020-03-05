package com.automation.tests.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {
    public static void main(String[] args) {

        /*
        1. go to login page http://practice.cybertekschool.com/login
        2. enter invalid username
        3. enter invalid password


        // testers will gather test data in excel sheet
        1. generate data from dummy data website
        // java faker

         */
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String password = faker.app().author();

        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.id("wooden_spoon")).click();






    }
}
