package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
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

    }

    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
    }

}
