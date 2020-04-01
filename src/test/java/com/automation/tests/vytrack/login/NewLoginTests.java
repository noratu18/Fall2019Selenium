package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    /**
     * Login and verify that page title is a "Dashboard"
     */
    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        String expected = "Dashboard";
        String actual = Driver.getDriver().getTitle();
     //   wait.until(ExpectedConditions.titleIs("Dashboard"));
        //we can use this if the actual result will be loading...
        Assert.assertEquals(actual,expected,"Page title is not correct!");
        //this is the shorter way of code :
        //Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
       // BrowserUtils.getScreenShot("verify_title");

    }

    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        BrowserUtils.getScreenShot("warning_message");
    }

    //negative scenario test for login page

    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager","wrongpassword");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        //takes a screenshot
        BrowserUtils.getScreenShot("loginPage");
    }

    @Test
    public void loginAsDriverTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("user19", "UserUser123");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }


}
