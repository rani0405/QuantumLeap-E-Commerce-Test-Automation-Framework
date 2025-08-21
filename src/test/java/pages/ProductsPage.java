package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	WebDriver driver;
	
	// Locators
	//By firstAddToCartBtn=By.cssSelector(".inventory_item:first-of-type button");
	By firstAddToCartBtn=By.id("add-to-cart-sauce-labs-backpack");
	By cartIcon=By.className("shopping_cart_link");
	
	//Constructor
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	// Page Actions
	public boolean isOnProductsPage() {
		return driver.getCurrentUrl().contains("inventory");
	}
	public void addFirstProductToCart() {
		driver.findElement(firstAddToCartBtn).click();
	}

	// Method to go to cart
    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
    
	public void openCart() {
		driver.findElement(cartIcon).click();
	}
}
