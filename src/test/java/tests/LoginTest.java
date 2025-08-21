package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import utils.ExtentTestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

//import ExtentReports1.ExtentManager;
import pages.LoginPage;
import utils.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;   // ✅ make sure you created this helper class


public class LoginTest extends BaseTest{
    ExtentReports extent;
    ExtentTest test;
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void setUpReport() {
        extent = ExtentManager.getInstance(); // get report instance
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {  // ✅ added ITestResult
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            try {
                test.fail("Test Failed: " + result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit(); // close browser
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        test = extent.createTest("Login Test - User: " + username);//always create test instance

        loginPage.login(username, password);

        if (username.equals("standard_user")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
            test.pass("Standard user logged in successfully.");
        } else if (username.equals("locked_out_user")) {
            String error = loginPage.getErrorMessage();
            Assert.assertTrue(error.toLowerCase().contains("locked"));
            test.pass("Locked out user showed error message correctly.");
        } else {
            test.fail("Unexpected test case.");
        }
    }
    
    @Test
    public void invalidLoginShouldShowError() {
    	test = extent.createTest("Invalid Login Test");  // always create test instance
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
        driver.findElement(By.id("login-button")).click();

        // Fail on purpose to check screenshot
        Assert.assertTrue(driver.getPageSource().contains("No Such Text")); 
        test.pass("Error message displayed as expected."); // Won't reach here if assertion fails
    }
    
    
//    @Test
//    public void invalidLoginShouldShowError() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("invalid_user", "wrong_password");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
//
//        Assert.assertTrue(error.isDisplayed(), "Error message should be displayed for invalid login.");
//    }

    @AfterTest
    public void flushReport() {
        extent.flush(); // save report
    }
}
