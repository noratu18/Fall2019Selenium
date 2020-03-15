package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM???
        //ChromeOptions -> use to customize browser for tests
        //and it helps us to automate unsecure websites without issues. Since cybertek practice does not carry
        //any license and browser is trying to warn us about it, we make it to stop warning .
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

    }



    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails it will throw exception and message will be printed
        //3 parameters: (expected, actual,message in case of error)
        Assert.assertEquals(actual,expected, "Sub-header message is not matching!");


    }

    /*
    Given user is on the practice landing page
    //When user navigates to "Forgot password" page
    //Then user enters his email
    //And clsicks "Retrieve password" button
    //Then user verifies that message "Your email's been sent!" is displayed

     */
    @Test
    public void forgotPasswordTest(){
        driver.get("http://practice.cybertekschool.com/forgot_password");
      //  driver.findElement(By.linkText("Forgot password")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("testemail@gmail.com", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();

        Assert.assertEquals(actual,expected,"Confirmation message is not valid!");


    }
    /*
    Task:
    Given user is on the practice landing page
    //When user navigates to "Checkboxes" page
    //And clicks on checkbox #1
    //Then user verifies that checkbox #1 is selected

     */

    @Test
    public void checkBoxTest1(){
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Checkboxes")).click();

        //locator for specific checkbox, xpath: //input[1], cssSelector: input:nth-of-type(1)
        // //input[@type="checkbox"[1]
        //collect all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(4);

        checkboxes.get(0).click();//to click on 1st checkbox

        Assert.assertTrue(checkboxes.get(0).isSelected(),"Checkbox #1 is not selected!");;




  }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
