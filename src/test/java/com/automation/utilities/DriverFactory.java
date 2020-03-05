package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    /**
     * Your homework will be to improve this method
     * This method returns webDriver object base on browser type
     * If you want to use chrome browser, just providfe chrome as a parameter
     *
     * @param browserName
     * @return
     */
    public static WebDriver createDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }


    }

}