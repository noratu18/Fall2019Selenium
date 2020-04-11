package com.automation.pages;

import com.automation.tests.day10.ActionsTests;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will be extended by page classes
 * And common webelements/locators can be stored here
 * Since navigation menu doesn"t belong to particular page
 * We cannot really create a dedicated page class to store
 * elements from that menu
 *
 */
public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 15);


    @FindBy(css= "#user-menu > a")
    protected WebElement currentUser;


    //constructor
    public AbstractPageBase(){
        //it is VERY important ! it serves to initialize the object and it finds the Elements!!
        //without it NO PAGE Object Model class will work !!!
        //finding web elements in POM : selenium has smth to improve this process : Page Factory class
        // It helps to find element easier, syntax is shorter, more organized
        PageFactory.initElements(driver,this);

    }

    /**
     * we come up with this method that will wrap up locator not to have
     * duplication by using WebElements directly in test cases
     * @return
     */
    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     * Method for VyTrack navigation,. Provide tab name and module name to navigate
     * @param tabName, like Dashboards, Fleet or Customers
     * @param moduleName like Vehicles, Vehicle Odometer and Vehicles Costs
     */
    public void navigateTo(String tabName, String moduleName){
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleXpath="//span[@class='title title-level-2' and text()='"+moduleName+"']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtils.wait(4);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        //increase this time wait if sill failing
        BrowserUtils.wait(4);

    }
}
