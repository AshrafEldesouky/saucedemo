package Testcases;

import Pages.P01_LoginPage;
import Pages.P05_CheckoutOverview;
import Pages.P06_Checkout_Complete;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC06_CheckOutComplete extends TestBase {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the CheckOutComplete functionality.
     */

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void Check_ThanksMessage_Isavailable () throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P06_Checkout_Complete(getDriver()).Get_Thanks_Message_ByAssertEqual();

        System.out.println(new P06_Checkout_Complete(getDriver()).Get_Thanks_Message_ByAssertEqual());

        Assert.assertEquals(new P06_Checkout_Complete(getDriver()).Get_Thanks_Message_ByAssertEqual(),"Thank you for your order!");
    }
}
