package officeHours;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class VytrackSoftSkillHomework extends AbstractTestBase {


    @Test(description = "Verify that sales manager should be able to see all car's" +
            "cost information on the Vehicle Costs page")
    public void verifySalesManagerCanSeeVehicleCostPage(){
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login("salesmanager125", "UserUser123");
        vehiclesPage.navigateTo("Fleet","Vehicle Costs");

        String expectedTitle = "All - Vehicle Costs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Test(description = "Verify that store manager should be able to see all car's" +
            "cost information on the Vehicle Costs page")
    public void verifyStoreManagerCanSeeVehicleCostThePage(){
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login("storemanager67", "UserUser123");
        vehiclesPage.navigateTo("Fleet","Vehicle Costs");

        String expectedTitle = "All - Vehicle Costs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
