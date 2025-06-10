package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P06_Checkout_Complete {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the Locator_Checkout_Complete Page & WebElment Methods.
     */

    WebDriver driver;

    public P06_Checkout_Complete(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver == null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }

    private final By Thanks_Message = By.xpath("//h2[text()='Thank you for your order!']");

    public String  Get_Thanks_Message_ByAssertEqual() {
        return getDriver().findElement(this.Thanks_Message).getText();
    }


}
