package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;




public class P05_CheckoutOverview {
    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the Locator_CheckoutOverview Page & WebElment Methods.
     */


    //1.define webdriver
    //2.define constructor and initialize webdriver
    //3.define locators using By
    //4.define action method for each locator because it is fluent design

    WebDriver driver;

    public P05_CheckoutOverview(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver == null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }

    private final By Total_AllPrice = By.xpath("//div[@class='summary_subtotal_label']");
    private final By Taxes = By.xpath("//div[@class='summary_tax_label']");
    private final By PriceAndTaxes = By.xpath("//div[@class='summary_total_label']");
    private final By FINISH_BUTTON = By.xpath("//button[@id='finish']");
    private final By YourFinish_Title = By.xpath("//div[@class='subheader']");
    public static float Total_Price_calcbySystem;

    public P05_CheckoutOverview GetTotalprice() {
        String TotalpriceText = driver.findElement(this.Total_AllPrice).getText();

        String[] parts = TotalpriceText.split("\\$");
        String currencySymbol = parts[0]; // Currency symbol
        String amount = parts[1]; // Amount without the symbol
        Total_Price_calcbySystem = Float.parseFloat(amount);
        System.out.println("Total_Price_calcbySystem : " + Total_Price_calcbySystem);
        return this;
    }

    public static float Total_Taxes;

    public P05_CheckoutOverview Get_Taxes() {
        String TaxesText = driver.findElement(this.Taxes).getText();

        String[] parts = TaxesText.split("\\$");
        String currencySymbol = parts[0]; // Currency symbol
        String amount = parts[1]; // Amount without the symbol
        Total_Taxes = Float.parseFloat(amount);
        System.out.println("Total_Taxes only : " + Total_Taxes);
        return this;
    }

    public static float PriceAndTaxesAmount;

    public P05_CheckoutOverview Get_PriceAndTaxes() {
        String PriceAndTaxesText = driver.findElement(this.PriceAndTaxes).getText();

        String[] parts = PriceAndTaxesText.split("\\$");
        String currencySymbol = parts[0]; // Currency symbol
        String amount = parts[1]; // Amount without the symbol
        PriceAndTaxesAmount = Float.parseFloat(amount);
        System.out.println("PriceAndTaxesAmount : " + PriceAndTaxesAmount);
        return this;
    }



    public P05_CheckoutOverview Click_FINISH_BUTTON() {
        driver.findElement(this.FINISH_BUTTON).click();
        return this;
    }




}
