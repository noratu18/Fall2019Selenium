package com.automation.tests.day6;

import java.util.List;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create a webelement object for dropdown first

        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        // provide webelement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown); //creating new object
        // select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        // and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        //select your DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1979");
        selectMonth.selectByVisibleText("December");
        selectDay.selectByVisibleText("8");

        BrowserUtils.wait(2);

        //select all months one by one
        //.getOptions(); -> returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for( WebElement eachMonth : months){
            //get the month name and select based on that
            selectMonth.selectByVisibleText(eachMonth.getText());
            BrowserUtils.wait(1);

        }

        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Massachusetts");

        //option that is currently selected
        //getFirstSelectedOption() -> returns a webelement, that's why we need to call getText()
        //getText() retrieves visible text from the webelement
        String selected = stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("Massachusetts")){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }


        // getting the list og=f all states and retrieves the options
        List<WebElement> states = stateSelect.getOptions();
        for(WebElement eachState : states){
            System.out.println(eachState.getText());
        }








        BrowserUtils.wait(3);
        driver.quit();



    }
}
