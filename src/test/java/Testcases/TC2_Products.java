package Testcases;


import Pages.P02_Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC2_Products extends TestBase {
    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the Products functionality.
     */

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void  Check_Click_AddCartBtn_Sauce_Labs_Bike_Light() throws InterruptedException {


        new P02_Products(driver).Click_AddCartBtn_Sauce_Labs_Bike_Light().Click_Final_Cart();

       Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

    }

}
