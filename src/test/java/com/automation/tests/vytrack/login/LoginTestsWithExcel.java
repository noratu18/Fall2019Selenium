package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.ExcelUtil;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestsWithExcel extends AbstractTestBase {



   @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel2(String execute, String username, String password, String firstname, String lastname, String result){
        //determine excel file name
        String path = "VytrackTestUsers.xlsx";
        //spreadsheet name
        String spreadSheet = "QA3-short";
        //create object of excel utility class so we can write into the file
        excelUtil = new ExcelUtil(path,spreadSheet);

        test = report.createTest("Login test for username :: " + username);
        //if value of first column is y, test will be executed
        if(execute.equals("y")) {
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as "+ username); // log some tests
            test.info(String.format("First name: %s, Last name: %s, Username: %s", firstname,lastname,username));
            test.pass("Successfully logged in as " + username);
            //write into excel file that test passed
            excelUtil.setCellData("PASSED", "result", row++); // every test is going to be different, it will increase the row, like counter

        }else if (execute.equals("n")){
            test.skip("Test was skipped for user: " + username);
            excelUtil.setCellData("SKIPPED", "result", row++);
            //to skip some test in TestNg
            // this method coming from TestNg
            throw new SkipException("Test was skipped for user: " +username);
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
