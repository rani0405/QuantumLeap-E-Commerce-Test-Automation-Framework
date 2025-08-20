package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.saucedemo.com/");
        
        // Create page object
        loginPage=new LoginPage(driver);
        loginPage.open();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // close browser
    }

    @Test
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        loginPage.login(username, password);
        // Add assertions here
    }
}   
//    public void testValidLogin() {
//    	loginPage.login("standard_user", "secret_sauce");
//        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
//    }
//
//    @Test
//    public void testInvalidLogin() {
//    	loginPage.login("locked_out_user", "secret_sauce");
//        String error = loginPage.getErrorMessage();
//        Assert.assertTrue(error.toLowerCase().contains("locked"));
//    }


