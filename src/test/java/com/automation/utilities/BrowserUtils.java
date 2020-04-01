package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    public static void wait(int seconds){

        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param elements represents collection of WebElements
     * @return collection of Strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for(WebElement element: elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * //method that takes a screenshot
     * @param name screenshot name
     * @return path to the sscreendsot
     */
    public static String getScreenShot(String name){
        //adding date and time to screenshot name
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;

        name = new Date().toString() + "_" + name;
     //   name= LocalDateTime.now() +"_" + name; // we can use this one too
       //  for Windows we can try this
       String path = "";
        if(System.getProperty("os.name").toLowerCase().contains("mac")){
            path=System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
        }else{
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }
        System.out.println("OS name: "+System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);

        //where we gonna store a screenshot
        //we craete path and store our screenshot
//        String path = System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
//        System.out.println("Screenshot is here: " + path);
        //since our reference type is WebDriver
        //we cannot see methods from TakesScreenshot interface
        //that;s why we do casting
        TakesScreenshot takesScreenShot = (TakesScreenshot) Driver.getDriver();
        //take screenshot of web browser, and save it as a file
        //screenshot itself
        File source = takesScreenShot.getScreenshotAs(OutputType.FILE);
        //where screenshot will be saved
        File destination = new File(path);

        try {
            //copy file to the previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
