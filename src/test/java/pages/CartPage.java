package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	private WebDriver driver;
	
	//Locators
	private By cartItem=By.className("inventory_item_name");
	
	// Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Page Actions
    public String getCartItemName() {
    	return driver.findElement(cartItem).getText();
    }
    public String getFirstProductName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

}
