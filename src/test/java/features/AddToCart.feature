Feature: Add item to cart

  Scenario: User adds an item to the cart successfully
    Given the user is on the Login Page
    When the user logs in with "standard_user" and "secret_sauce"
    And the user adds "Sauce Labs Backpack" to the cart
    Then the cart should contain "Sauce Labs Backpack"
