package com.automation.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void googleTest(){
        //Driver.getDriver()-->returns driver
        Driver.getDriver().get("http://google.com");
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();

    }
}
