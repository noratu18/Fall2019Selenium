package officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class Office_Hour_03_17 {
    public static void main(String[] args) {


    WebDriver driver = DriverFactory.createDriver("chrome");
    driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        BrowserUtils.wait(3);
        //click on contacts
        //create contact
        //Use map to store information and use it later to enter in UI

        // //tag[@attribute='value']

        WebElement contact_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        BrowserUtils.wait(3);

        String currentTitle = driver.getTitle();
        if(currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")){
            System.out.println("Title is expected");
        }else{
            System.out.println("Title is NOT expected");
        }
        HashMap<String,String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last name", "Smith");
        contact1.put("Phone", "517-236-4567");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");
        contact1.put("Country", "United States");

        System.out.println("contact1 = " + contact1);

        WebElement firstName =driver.findElement(By.xpath("(//input[@data-name = 'field__first-name'])[1]"));
        WebElement lastName =driver.findElement(By.xpath("(//input[@data-name = 'field__last-name'])[1]"));
         WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
         WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
         WebElement city = driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
         WebElement state = driver.findElement(By.xpath("//input[@data-name = 'field__region-text']"));
         WebElement zipCode = driver.findElement(By.xpath("//input[@data-name = 'field__postal-code']"));
         WebElement salesGroup = driver.findElement(By.xpath("(//input[@data-name = 'field__1'])[2]"));

         firstName.sendKeys(contact1.get("First Name"));
         lastName.sendKeys(contact1.get("Last Name"));
         phone.sendKeys(contact1.get("Phone"));
         street.sendKeys(contact1.get("Street"));
         city.sendKeys(contact1.get("City"));
         state.sendKeys(contact1.get("State"));
         zipCode.sendKeys(contact1.get("Zip Code"));

         /*
         to handle dropdowns in selenium we use Select class
         to use it we have to ensure we have <select>,</select> tag in outr dropdown
         to create Select class we are using webelement of <select></select> element from html ( we need to locate our
         dropdown which should have select tag).

         // this is  another option to find United States
         //span[contains(text(),'United States')]
          */

        WebElement country = driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select country_dropdown = new Select(country); // this is special class in selenium to handle dropdowns
        /*
        it has different methods that help us interact with dropdown
         */
        country_dropdown.selectByVisibleText(contact1.get("Country"));//to make it dynamic we choose country
        if(contact1.get("Sales Group").equalsIgnoreCase("true")){
            salesGroup.click();
        }



}
}