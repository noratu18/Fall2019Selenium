package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(4);

        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
       String filePath = System.getProperty("user.dir")+"/pom.xml";
        //it work only fo my computer beacuse only have this file
        // and my computer username is different than yours
        String filePath2 = "/Users/Baktyiar/Desktop/cybertek-nora/abstract.pages";


        System.out.println(filePath);//print path

        upload.sendKeys(filePath2);

        driver.findElement(By.id("file-submit")).click(); // click to upload



        BrowserUtils.wait(4);
        driver.quit();


    }
}
