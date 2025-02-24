Feature: crud operations

  Scenario: I create a record in the api
    Given I call create api
    Then  I validate the HTTP status code 201
    And I validate the body of the api

  Scenario: I update a record in the api
    Given I call update api
    Then  I validate the HTTP status code 200
    And I validate the body of the api for deleted record

  Scenario: I delete a record in the api
    Given I call delete api
    Then I validate the HTTP status code 204

