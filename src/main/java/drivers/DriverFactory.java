package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Task Received On: June 9, 2025
     * Created On: June 10, 2025
     * Description:
     * This method returns a new instance of WebDriver based on the specified browser.
     * Currently, it is configured for Chrome with custom options such as disabling notifications,
     * password manager, and running in incognito mode.
     */


    public static WebDriver getNewInstance(String browserName) {


        browserName=   browserName.toLowerCase();
        Map<String, Object> prefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions = new ChromeOptions();
        // TODO: handle browsers options
        prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(capabilities);
        return new ChromeDriver(chromeOptions);
    }
}


