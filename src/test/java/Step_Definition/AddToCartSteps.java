package Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class AddToCartSteps {
	WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
    CartPage cartPage;
    
    @Given("the user is on the Login Page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @When("the user logs in with {string} and {string}")
    public void the_user_logs_in_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @When("the user adds {string} to the cart")
    public void the_user_adds_to_the_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("the cart should contain {string}")
    public void the_cart_should_contain(String expectedProduct) {
        productsPage.goToCart();
        String actualProduct = cartPage.getCartItemName();
        Assert.assertEquals(actualProduct, expectedProduct, "Cart content mismatch!");
        driver.quit();
    }

	
}
