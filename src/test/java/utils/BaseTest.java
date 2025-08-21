package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;

public class BaseTest {
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected WebDriver driver; // add driver here

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent = ExtentManager.getInstance(); // ✅ shared instance
    }

    @BeforeMethod
    public void setUp(Method method) {
        test = extent.createTest(method.getName());
        
        
        // ✅ Launch browser before each test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        
        
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.fail("Test Failed").addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }

        driver.quit();
    }

    @AfterSuite
    public void closeReport() {
        extent.flush();
    }
}
