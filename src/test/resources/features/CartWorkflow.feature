Feature:Implementation of the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html

  Scenario: I open a web store, choose a laptop and buy it
    Given I open home page
    When I navigate to Laptop
    And I open Sony vaio i5
    And I click on Add to cart
    And I accept pop up confirmation
    And I navigate to Laptop
    And I open Dell i7 8gb
    And I click on Add to cart
    And I accept pop up confirmation
    And I navigate to Cart
    And I delete Dell i7 8gb from cart
    And I click on Place order
    And I fill in all web form fields
    And I click on Purchase
    And I click on Ok
    Then I assert purchase amount equals expected
