package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;
import static utilities.utility.*;

public class P04_CheckoutYourInformation {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the Locator_CheckoutYourInformation Page & WebElment Methods.
     */


    //1.define webdriver
    //2.define constructor and initialize webdriver
    //3.define locators using By
    //4.define action method for each locator because it is fluent design

    WebDriver driver;
    public P04_CheckoutYourInformation(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver==null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }
    private final By FIRSTName_TXT = By.xpath("//input[@id='first-name']");
    private final By LastName_TXT = By.xpath("//input[@id='last-name']");
    private final By PostalCode_TXT = By.xpath("//input[@id='postal-code']");
    private final By Continue_BUTTON = By.xpath("//input[@type='submit']");

    private final By YourCheckoutOverView_Title = By.xpath("//div[@class='subheader']");
    public P04_CheckoutYourInformation Insert_FIRSTName_TXT() {
        driver.findElement(this.FIRSTName_TXT).sendKeys(generateRandomFirstName());
        return this;
    }
    public P04_CheckoutYourInformation Insert_LastName_TXT() {
        driver.findElement(this.LastName_TXT).sendKeys(generateRandomLastName());
        return this;
    }
    public P04_CheckoutYourInformation Insert_PostalCode_TXT() {
        driver.findElement(this.PostalCode_TXT).sendKeys(generatePostalCode());
        return this;
    }
    public P04_CheckoutYourInformation Click_Continue_BUTTON() {
        driver.findElement(this.Continue_BUTTON).click();
        return this;
    }
    public void NavigateBack(WebDriver driver) {
        driver.navigate().back();
    }
    public boolean VerifyYourCheckoutOverViewPageSucessfully() {
        return driver.findElement(this.YourCheckoutOverView_Title).getText().contains("Checkout: Overview");
    }
    public boolean  VerifYourCheckoutOverView_isVisible() {
        return getDriver().findElement(this.YourCheckoutOverView_Title).isDisplayed();
 
    }
    public String  VerifYourCheckoutOverView_ByAssertEqual() {
        return getDriver().findElement(this.YourCheckoutOverView_Title).getText();
    }

}
