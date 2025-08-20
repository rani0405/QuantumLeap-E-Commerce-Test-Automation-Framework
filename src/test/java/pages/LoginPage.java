package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	// Locators
	By UsernameField=By.id("user-name");
	By passwordField=By.id("password");
	By loginBtn=By.id("login-button");
	By errorMsg=By.cssSelector("h3[data-test='error']");
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	 // Page Actions
	public void open() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void enterUsername(String username) {
		driver.findElement(UsernameField).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	public void login(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	public String getErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}
//	public boolean isLoginSuccessful() {
//	    return driver.getCurrentUrl().contains("inventory.html");
//	}

}
