package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHolder {

    /**
     * Thread-safe WebDriver holder using ThreadLocal.
     * This ensures each thread has its own instance of WebDriver,
     * preventing conflicts in parallel test executions.
     */

    public final static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    /**
     * Retrieves the WebDriver instance associated with the current thread.
     *
     * @return the WebDriver instance for the current thread
     */
    public static WebDriver getDriver(){
        return driver.get();
    }


    /**
     * Sets the WebDriver instance for the current thread.
     *
     * @param driver the WebDriver instance to associate with the current thread
     */
    public static void setDriver(WebDriver driver){
        DriverHolder.driver.set(driver);
    }
}