package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {

    public static void main(String[] args) throws Exception{

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        // using our own created method with className instead above two lines
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        Thread.sleep(3000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        //when you see type="submit", you can use submit() instead of click()
        //it make sense to use when click() method doesn't work
        signUp.submit();
        Thread.sleep(3000);

        String expected = "Thank you for signing up. Click the button below to return to the home page";
        WebElement message = driver.findElement(By.className("subheader"));

        String actual = message.getText(); //

        if(expected.equals(actual)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit(); // to close everything



    }
}
