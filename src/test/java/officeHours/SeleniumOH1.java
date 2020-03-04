package officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {

    /*
    Iterator
    -List,Set,Map and other types of collection can use Iterator class to iterate over that collection
    -List has indexes ( fori, for each, while, Iterator)
    -Map (for each, Iterator - to loop through keys)
    Basic Selenium Navigators
     */

    public static void main(String[] args) {
        //Create arrayList of Strings - iterate over it

        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator<String> iterator = keysToSearch.iterator();
        //iterator() - return Iterator type which we can use with all iterator methods

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //print before modification and
        //add* to each estring and print again
        //[fruuits,veggies,berries]
        Iterator<String>iterator1 = keysToSearch.iterator();
        while (iterator1.hasNext()){
            String item = iterator1.next();
            System.out.println(item);
            System.out.println("*"+item);
        }
        //create a MAp with <String,String>
        HashMap<String,String>personalInfo = new HashMap<>();
        personalInfo.put("name","Bryan");
        personalInfo.put("studentId","123456");
        personalInfo.put("major","computer science");

        Iterator<String> mapIterator = personalInfo.keySet().iterator();
        while (mapIterator.hasNext()){
            String key = mapIterator.next();
            System.out.println(mapIterator.next()+":"+personalInfo.get(key));
        }

        System.out.println("================Selenium===================");

        /*
        8 type of locators:

        id - always unique ( but it is not always available) - we always want to use it when it is available
        class-className
        name
        tag - every element will have a tag(mandatory)

        // this will work only with the link
        Link Test
        partial LinkTest

        //locator that using html to locate special syntax
        css
        Xpath



        input - tag
        key = "value" - attributes
        id = "glodal-enhancements-search-qeury" - one of the attributes
        we can use id to locate the element

        name ="search_query"-attribute we can use name to locate the element

        class="wt-input-btn-group_input
        global-enhancements-search-input-btn-group_input wt-pr-xs-7"
        -we can use class to locate element

        When we want to find element it is always must be unique
        id - always unique
        name,tag,class - are not unique very often

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://etsy.com");
        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-qeury"));
        //findElement()--> returns WebElement
        // as param we put By.locator("value of attribute")
        //                  (id,name,classname,class,...)




    }
}
