package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByIndex(8);//index always starts from 0-->Delaware

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);//Wyoming

        //to print all states with indexes
        List<WebElement> stateList = stateSelect.getOptions();
        int count = 0;
        for(WebElement eachState: stateList){
            count++;
            System.out.println(count+" = "+eachState.getText());
        }


        BrowserUtils.wait(2);
        driver.quit();

    }
}
