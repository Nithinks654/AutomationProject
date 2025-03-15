@check
Feature: To sign up and create the user


  Scenario: sign up user
    Given I enter into webPage
    Then I validate that I am in signUp page
    When Try to signup with existing email and check the error message

  @checking
  Scenario: Create user
    Given I enter into webPage
    Then I validate that I am in signUp page
    And I validate that I am in create account page
    Then I enter all the signUp details "nithin,K S,Channapatna,karnataka,Ramanagara,562160,7857893567"
    When I click create account button
    Then Account created message should be displayed
    When I Click on continue Button
    Then It should display logged in username
    When I click on delete account Button
    Then account deleted message should be displayed and click continue button






