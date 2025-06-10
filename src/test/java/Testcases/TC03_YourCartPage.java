package Testcases;

import Pages.P03_YourCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC03_YourCartPage extends TestBase{

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the CartPage functionality.
     */

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void Click_CheckOutFromYourCart() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P03_YourCartPage(getDriver()).Click_CheckOut_BUTTON();
        //Hard Assertion After successfully login

        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");

    }
}
