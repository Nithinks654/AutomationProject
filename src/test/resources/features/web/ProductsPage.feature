@Product
Feature: Place Order - Register While Checkout

  Scenario: Register while placing an order
    Given I enter into Products webPage
    Then I should see the home page displayed successfully

    When I add products to the cart
    And I click the view cart link
    Then I should see the cart page displayed

    When I click Proceed To Checkout
    And I click Register Or Login button
    And I fill all details in Signup and create an account "nithin,K S,Channapatna,karnataka,Ramanagara,562160,7857893567"
    Then I should see ACCOUNT CREATED! message
    And I click the Continue button
    Then I should see Logged in as username at the top

    When I click the Cart button
    And I click Proceed To Checkout
    Then I should see the Address Details and Review Order section and verify all the details "Address Details,Mr. nithin K S,Channapatna,Ramanagara karnataka 562160,India,7857893567"
    And I should see items i have added with correct total amount "Green Side Placket Detail T-Shirt,Pure Cotton Neon Green Tshirt,Rs. 1850"

    When I enter a description in the comment text area
    And I click the Place Order button
    And I enter payment details "Nithin,4111111111111111,123,12,2029"
    And I click Pay and Confirm Order button
    Then I should see the success message "Your order has been placed successfully!"

    When I click the Delete Account button
    Then I should see "ACCOUNT DELETED!" message
    And I click the Continue button





