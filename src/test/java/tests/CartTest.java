package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		// Page Objects
		loginPage=new LoginPage(driver);
		productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        
     // Open login page and log in
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
	}
	
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
	
	@Test
	public void testAddToCart() {
		Assert.assertTrue(productsPage.isOnProductsPage(),"Not on Products Page!");
		
		// Add item and go to cart
		productsPage.addFirstProductToCart();
		productsPage.openCart();
		
		// Verify cart item
		String itemName=cartPage.getCartItemName();
		Assert.assertNotNull(itemName,"Cart item should not be empty!");
		System.out.println("Item in cart: " + itemName);
	}
}
