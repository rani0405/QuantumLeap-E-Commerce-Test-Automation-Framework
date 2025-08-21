Feature: Add Item to Cart

  Scenario: User adds an item to the shopping cart
    Given the user is logged into the SauceDemo website
    When the user adds a product to the cart
    Then the cart should contain that product
