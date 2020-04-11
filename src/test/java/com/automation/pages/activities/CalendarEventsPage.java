package com.automation.pages.activities;

//* Object repository also known as pages package
//* Where is your page classes->from page classes you create page objects

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css="[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;
    //when there is a frame we need to switch to frame first

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;
    //*[text()='Description']/../following-sibling::div//iframe

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;
    //label[text()='Title']/..//div[@class='control-label']

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;

    public void enterCalendarEventTitle(String titleValue){
        BrowserUtils.waitForPageToLoad(30);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterCalendarEventDescription(String description){
        BrowserUtils.waitForPageToLoad(20);
        //wait until frame is available and switch to it
        // the benefit of this method is we don't need to switch frame inside test
        //everything is covered inside page, all kind of page
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
        BrowserUtils.wait(3);
    }

    public void clickSaveAndClose(){
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
        BrowserUtils.wait(10);

    }

    public String getGeneralInfoTitle(){
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }
//////////////////the above code is new we added today/////////////////

    public List<String> getColumnNames(){
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }



    public String getStartTime() {
        BrowserUtils.waitForPageToLoad(20);
        //we can use if giving error no such element found in startTime
    //  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }


    public String getEndTime() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }


    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(20);
        //wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        //we can add  this line if we'll have problem with waiting
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();

    }

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(20);
        // we cann add this if it is failing
       wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(20);
    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);

        return startDate.getAttribute("value");
    }



}
