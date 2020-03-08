package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("MA");

        String expected = "Massachusetts";
        String actual = stateSelect.getFirstSelectedOption().getText();
        //getFirstSelectedOption-> returns a webelement, thats why we need
        // to call getText() method, to be able to compare it with a String
        //returns what we select

        if(expected.equals(actual)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }




        BrowserUtils.wait(2);
        driver.quit();
    }
}
