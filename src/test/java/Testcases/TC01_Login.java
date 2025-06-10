package Testcases;

import Pages.P01_LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static drivers.DriverHolder.getDriver;

public class TC01_Login extends TestBase {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the login functionality.
     */

    //define Test Data
    String email = " ";
    String Password = " ";

    @Test(priority = 1, description = "Login With valid Email and Password")
    public void LoginWithValidData_P() throws InterruptedException {
         email = "standard_user";
         Password = "secret_sauce";
        new P01_LoginPage(driver).Insert_UserNAME_TXT(email).Insert_PassWord_TXT(Password).clickLOGIN_BUTTON();
//        PageBase.ThreadSleep200();

        //Hard Assertion After successfully login

        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");


        //------------------------------Hard Assertion------------------------------------------//
//        WebDriverWait wait = new WebDriverWait(getDriver(), 50); // wait up to 10 seconds
        WebElement body = driver.findElement(By.tagName("body"));
        // Optionally, print the body text for debugging
//        System.out.println("Body text: " + body.getText());
        Assert.assertTrue(body.getText().contains("Products")); //not working
        System.out.println("====================================");


    }


}
