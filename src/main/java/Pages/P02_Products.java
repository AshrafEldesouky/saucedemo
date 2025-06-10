package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class P02_Products {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the Locator_Products Page & WebElment Methods.
     */

    WebDriver driver;

    public P02_Products(WebDriver driver) {
        // Initialize elements
        PageFactory.initElements(driver, this);
        this.driver = driver;

        if (this.driver == null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }

    private final By Sauce_Labs_Bike_Light = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private final By AddCartBtn_Sauce_Labs_Bike_Light = By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']");

    private final By Final_Cart = By.xpath("//a[@class='shopping_cart_link']");


    public P02_Products Click_Sauce_Labs_Bike_Light() {
        driver.findElement(Sauce_Labs_Bike_Light).click();
        return this;
    }
    public P02_Products Click_AddCartBtn_Sauce_Labs_Bike_Light() {
        driver.findElement(AddCartBtn_Sauce_Labs_Bike_Light).click();
        return this;
    }

    public P02_Products Click_Final_Cart() {
        driver.findElement(Final_Cart).click();
        return this;
    }

}
