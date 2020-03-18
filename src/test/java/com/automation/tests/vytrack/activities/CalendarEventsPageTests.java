package com.automation.tests.vytrack.activities;

/*
Go to Activities --> Calendar Events
Verify that Create Calendar Event button is displayed
 */

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests {
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUsername = "storemanager78";
    private String storeManagerPassword = "UserUser123";
    private By acitivitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By calendarEventBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.id("s2id_oro_calendar_event_form_calendar");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    //or we can find by name
    //private By titleBy = By.name("oro_calendar_event_form[title]");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("id*='time_selector_oro_calendar_event_form_start-uid']");




    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();

        actions = new Actions(driver);

        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUsername);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(3);

        //hover over Activities
        actions.moveToElement(driver.findElement(acitivitiesBy)).perform();
        BrowserUtils.wait(3);

        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(3);

    }

    @Test(description = "Verify that Create Calendar Event button is displayed")
    public void verifyCreateButton(){
        WebElement createCalendarEventBtn = driver.findElement(calendarEventBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());

    }
    /*//in tne @BeforeMethod
    Test Case: Default Options
    Login as sales manager
    Go to Activities--> Calendar Events
    **

    Click on Create Calendar Event
    Default owner name should be current user
    Default title should be blank
    Default start date should be current date
    Default start time should be  current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues(){
     //Click on Create Calendar Event
     driver.findElement(calendarEventBy).click();
     BrowserUtils.wait(3);

//Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName,defaultOwnerName);

        //Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        //date time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format

        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualdate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualdate,expectedDate);

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        //Zoneid.of("GMT-7")
        String actualTime = driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualdate,expectedDate);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
