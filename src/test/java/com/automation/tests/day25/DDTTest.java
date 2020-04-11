package com.automation.tests.day25;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//this class just for demo, do not execute

public class DDTTest extends AbstractTestBase {

    @DataProvider()
    public Object [][] userList(){
        //read from excel in 2D array format
        ExcelUtil qa3short = new ExcelUtil("VytrackTestUsers.xlsx", "QA3-short");
        String[][] dataArray = qa3short.getDataArray();

        //return the 2D array
        return dataArray;

    }

    @Test(dataProvider = "userList")
    public void test(String execute, String username, String password, String firstname, String lastname){
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);



    }

}
