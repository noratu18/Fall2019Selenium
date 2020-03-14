package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    //runs only once before @BeforeClass and @BEforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test!");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test!");
    }

// Runs only once in  the class before @beforeMethod and before any test
// regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass(){
        //something that should be done only once in the class before all tests
        System.out.println("Before Class!");

    }

    @AfterClass
    public void afterClass(){
        //something that should be done only once in the class after all tests
        System.out.println("After Class!");
    }


    //runs before every Test automatically
    //works as a pre-condition or setup
    @BeforeMethod
    public  void setup(){
        System.out.println("Before method!");

    }

    //runs automatically  after every test
    @AfterMethod
    public void tearDown(){
        System.out.println("After method!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1 = 5;
        int num2 = 10;
        //it calls hard assertion
        //if assertion fails -> it stops the execution (due to exception)
        Assert.assertTrue(num1 > num2);

    }

    @Test
    public void test3(){
        System.out.println("Test 3");
        int num1 = 345;
        int num2 = 356;
        Assert.assertTrue(num1 <num2);
    }
}
