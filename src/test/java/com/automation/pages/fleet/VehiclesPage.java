package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")
    public WebElement createCar;
    //we creating private so no one will change it

    //why do we create method for simple click?beacuse
    //the application has issues with wait
    //we are creating more dynamic click method
    public void clickToCreateCar(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }


}
