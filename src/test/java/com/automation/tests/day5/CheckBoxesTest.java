package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        // # TASK!!!
        // verify that 1st checkbox is not selected and 2nd is selected
        BrowserUtils.wait(4);

        List<WebElement>checkBoxes = driver.findElements(By.tagName("input"));
        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test passed!");
        }else{
            System.out.println("Test failed");
        }

        BrowserUtils.wait(4);
        //let's click on the first checkbox and verify it's clicked
       // checkBoxes.get(0).click();
        WebElement checkbox1 = checkBoxes.get(0);
        checkbox1.click();//click on it

        if(checkbox1.isSelected()){
            System.out.println("Test passed!");
            System.out.println("checkbox1 is selected");
        }else{
            System.out.println("Test failed!");
            System.out.println("checkbox1 is not selected");
        }

        driver.quit();


    }
}
