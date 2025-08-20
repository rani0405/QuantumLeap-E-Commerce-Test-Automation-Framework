package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	
	// Locators
	By checkoutBtn=By.id("checkout");
	By firstNameField=By.id("first-name");
	By lastNameField=By.id("last-name");
	By postalCodeField=By.id("postal-code");
	By continueBtn=By.id("continue");
	By finishBtn=By.id("finish");
	By orderCompleteMsg=By.cssSelector(".complete-header");
	
	 // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Page Actions
    public void clickCheckout() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }
    
    public void enterUserInfo(String firstName,String lastName, String postalCode) {
    	driver.findElement(firstNameField).sendKeys(firstName);
    	driver.findElement(lastNameField).sendKeys(lastName);
    	driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    
    public void clickContinue() {
    	driver.findElement(continueBtn).click();
    }
    public void clickFinish() {
    	driver.findElement(finishBtn).click();
    }
    public String getOrderCompleteMessage() {
    	return driver.findElement(orderCompleteMsg).getText();
    }
}
