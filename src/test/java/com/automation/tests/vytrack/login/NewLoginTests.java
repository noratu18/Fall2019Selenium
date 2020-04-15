package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    static int row = 1;

    /**
     * Login and verify that page title is a "Dashboard"
     */
    @Test(groups = "smoke")
    public void verifyPageTitle(){
        //test-->ExtentTest
        //we must add to every test at the beginning
        //report.createTest("Test name");
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as store manager");
        String expected = "Dashboard";
        String actual = Driver.getDriver().getTitle();
     //   wait.until(ExpectedConditions.titleIs("Dashboard"));
        //we can use this if the actual result will be loading...
        Assert.assertEquals(actual,expected,"Page title is not correct!");
        //this is the shorter way of code :
        //Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
       // BrowserUtils.getScreenShot("verify_title");
        //if assertion passed, it will set test status in report to passed
        test.pass("Page title Dashboard was verified");

    }

    /*
    Enter wrong
     */
    @Test
    public void verifyWarningMessage(){
        //we need to add this every test to get report
        test = report.createTest("Verify warning message");

        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        BrowserUtils.getScreenShot("warning_message");

        test.pass("Warning message is displayed");
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

    //DDT--> Data Driven
    @Test(dataProvider = "credentials")
    public void loginWithDDT(String username,String password){
        test = report.createTest("Verify page title");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as "+ username); // log some tests

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title Dashboard was verified");

    }
    //data provider is a method, has to have an annotation
    //most common way to use with multidimensional array its like a table with rows and columns
    //Object[][] or Object[] or Iterator<Object[]>
    //Object[] --> 1 column with a data
    //Object[][] --> 2+ column with data

    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{ // this test runs 3 times with 3 different credentials
                {"storemanager85",  "UserUser123"}, // these are like inner array and outer array
                {"salesmanager110", "UserUser123"},
                {"user16",          "UserUser123"}
        };

    }

    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel(String execute, String username, String password, String firstname, String lastname, String result){
        test = report.createTest("Login test for username :: " + username);
        if(execute.equals("y")) {
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as "+ username); // log some tests
            test.info(String.format("First name: %s, Last name: %s, Username: %s", firstname,lastname,username));
            test.pass("Successfully logged in as " + username);

        }else{
            test.skip("Test was skipped for user: " + username);
            //to skip some test in TestNg
            throw new SkipException("Test was skipped for user: " +username); // this method coming from TestNg
        }


    }
    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel2(String execute, String username, String password, String firstname, String lastname, String result){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);

        test = report.createTest("Login test for username :: " + username);
        if(execute.equals("y")) {
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as "+ username); // log some tests
            test.info(String.format("First name: %s, Last name: %s, Username: %s", firstname,lastname,username));
            test.pass("Successfully logged in as " + username);
            excelUtil.setCellData("PASSED", "result", row++); // every test is going to be different, it will increase the row, like counter

        }else if ( execute.equals("n")){
            test.skip("Test was skipped for user: " + username);
            excelUtil.setCellData("PASSED", "result", row++);
            //to skip some test in TestNg
            throw new SkipException("Test was skipped for user: " +username); // this method coming from TestNg
        }else{
            excelUtil.setCellData("FAILED", "result", row++);
        }


    }

   @DataProvider
    public Object[][] credentialsFromExcel(){
        String path = "VyTrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        //execute  username  password  firstname   lastname   result
        return excelUtil.getDataArray();
    }



}
