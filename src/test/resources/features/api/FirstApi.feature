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
#    Then I validate the body of the api
    Examples:
      | apiUrl                         | HTTPStatusCode |
      | https://reqres.in/api/users/2  | 200            |
      | https://http.cat/789           | 404            |
      | https://reqres.in/api/users/23 | 404            |

  Scenario: Read a single user
    Given I set API endpoint for reading user with id 2
    When I send a GET request
    Then the response status code should be 200
    And the response body should contain "data.email" as "janet.weaver@reqres.in"


  Scenario Outline: Read a Multiple users
    Given I set API endpoint for reading user with id 2
    When I send a GET request for multiple users for "<path>"
    Then the response status code should be 200
    And the response body should contain expected output for "<api>"
    Examples:
      | path              | api                |
      | /api/unknown      | multipleYearUser   |
      | /api/users?page=2 | simpleMultipleUser |








