package com.automation.tests.day25;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestWithDataProvider {

    //this method will provide test data
    @DataProvider
    public Object [][] testData(){
        String [][] data = {
            {"Kung fury", "10"},
            {"Titanic", "9"},
            {"Interstellal", "2"},
                {"I am legend", "10"}

        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String name, String rating){
        System.out.println("Movie " + name + " has rating " + rating);;


    }

}
