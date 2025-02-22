Feature: First nithin api testing
@getTest
  Scenario: my first get api check
    Given I have get api "https://reqres.in/api/users/2"
    When I call the api
    Then I validate the HTTP status code 200
    Then I validate the body of the api "data.first_name" is "Janet"

  Scenario Outline: my first get api
    Given I have get api "<apiUrl>"
    When I call the api
    Then I validate the HTTP status code <HTTPStatusCode>
    Then I validate the body of the api
    Examples:
      | apiUrl                        | HTTPStatusCode |
      | https://reqres.in/api/users/2 | 200            |
      | https://http.cat/789          | 404            |





