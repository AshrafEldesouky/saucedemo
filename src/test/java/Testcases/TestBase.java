package Testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import com.aventstack.extentreports.reporter.configuration.Theme;
import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utilities.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    /**
     * Author: Ashraf Mohamed El-Desouki
     * Received Task On: June 9, 2025
     * Created On: June 10, 2025
     * Description: This class handles the Base Class and Exetend Report functionality.
     */


    protected static WebDriver driver;


    // extend report
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private static String PROJECT_NAME = null;
    private static String PROJECT_URL = null;
    // define Suite Elements
    static Properties prop;
    static FileInputStream readProperty;

    @BeforeSuite
    public void defineSuiteElements() throws IOException {
        // initialize the HtmlReporter
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        setProjectDetails();

        // initialize test
        test = extent.createTest(PROJECT_NAME + " Test Automation Project");

        //configuration items to change the look and fee add content, manage tests etc
        htmlReporter.config().setDocumentTitle(PROJECT_NAME + " Test Automation Report");
        htmlReporter.config().setReportName(PROJECT_NAME + " Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
    private void setProjectDetails() throws IOException, FileNotFoundException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
    }

    @Parameters("browser")
    @BeforeTest
    public void setupDriver(String browser) {
//        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getNewInstance("browser");
        DriverHolder.setDriver(driver);

        driver.get(PROJECT_URL);
//        driver.get("https://www.saucedemo.com/");

    }

    @AfterTest
    public void quit() {
        driver.quit();
//        Thread.currentThread().interrupt();
    }
    @AfterSuite
    public void tearDown() throws IOException {
        extent.flush();
        //start html report after test end
        utility.startHtmlReport(System.getProperty("user.dir"), "/testReport.html");
    }
    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName() + " failed with the following error: " + result.getThrowable());
            Reporter.log("Failed to perform " + result.getName(), 10, true);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
            Reporter.log("Successfully perform " + result.getName(), 10, true);
        } else {
            test.log(Status.SKIP, result.getName());
            Reporter.log("Skip " + result.getName(), 10, true);
        }
    }
}