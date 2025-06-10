package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P03_YourCartPage {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the Locator_Products Page & WebElment Methods.
     */

    //1.define webdriver
    //2.define constructor and initialize webdriver
    //3.define locators using By
    //4.define action method for each locator because it is fluent design

    WebDriver driver;
    public P03_YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver==null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }
    private final By CheckOut_BUTTON = By.xpath("//button[@id='checkout']");

    public P03_YourCartPage Click_CheckOut_BUTTON() {
        driver.findElement(this.CheckOut_BUTTON).click();
        return this;
    }


}
