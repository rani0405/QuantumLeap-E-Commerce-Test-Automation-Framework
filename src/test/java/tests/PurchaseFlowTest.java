package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class PurchaseFlowTest {
	WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    
    @BeforeMethod
    public void setUp() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        
     // Page Objects
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        
        //Login
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testEndToEndPurchaseFlow() {
    	// Add product
    	productsPage.addFirstProductToCart();
    	productsPage.openCart();
    	
    	// Verify cart
    	String cartItem=cartPage.getCartItemName();
    	Assert.assertNotNull(cartItem,"Cart should have one item");
    	
    	//Checkout
    	checkoutPage.clickCheckout();
    	checkoutPage.enterUserInfo("John", "Doe", "12345");
    	checkoutPage.clickContinue();
    	checkoutPage.clickFinish();
    	
    	// Verify order complete
    	String completeMsg=checkoutPage.getOrderCompleteMessage();
    	//Assert.assertTrue(completeMsg.contains("THANK YOU"), "Order not completed!");
    	Assert.assertTrue(completeMsg.contains("Thank you for your order!"), "Order not completed!");
    	System.out.println("Order completed successfully: " + completeMsg);
    }
}
