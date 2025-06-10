package Testcases;

import Pages.P02_Products;
import Pages.P03_YourCartPage;
import Pages.P05_CheckoutOverview;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC05_CheckoutOverview extends TestBase {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the CheckoutOverview functionality.
     */

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void CheckoutOverview() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P05_CheckoutOverview(getDriver()).GetTotalprice().Get_Taxes().Get_PriceAndTaxes().Click_FINISH_BUTTON();


        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");

    }

}