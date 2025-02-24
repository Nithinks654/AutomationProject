Feature: To validate Auth token scenario's

  Scenario Outline: Authentication Error scenario
    Given I call api url "https://reqres.in/api/login" with body "<validation>"
    Then I validate Api response code <statusCode>
    And I validate the response in api body "<errorMessage>"
    Examples:
      | validation | statusCode | errorMessage              |
      | Negative   | 400        | Missing email or username |
      | Mispwd     | 400        | Missing password          |
      | Positive   | 200        |                           |
