package Testcases;

import Pages.P04_CheckoutYourInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC04_CheckoutYourInformation extends TestBase{

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the CheckoutYourInformation functionality.
     */

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void CheckoutYourInformation() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P04_CheckoutYourInformation(getDriver()).Insert_FIRSTName_TXT().Insert_LastName_TXT().Insert_PostalCode_TXT().Click_Continue_BUTTON();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");

    }

}
