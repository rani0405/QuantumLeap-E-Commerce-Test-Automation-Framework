package Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;;

public class AddToCartSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Given("the user is logged into the SauceDemo website")
    public void the_user_is_logged_into_the_saucedemo_website() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {
        productsPage.addFirstProductToCart();
        productsPage.goToCart();
    }

    @Then("the cart should contain that product")
    public void the_cart_should_contain_that_product() {
        String productName = cartPage.getCartItemName();
        Assert.assertNotNull(productName, "Cart should contain at least one product");
        driver.quit();
    }
}

