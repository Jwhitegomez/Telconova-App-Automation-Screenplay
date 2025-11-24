# Author: Jimmy
# Language: en

Feature: Login to the Buggy Cars Rating platform
  In order to access my user account
  As a registered user
  I want to log in successfully

  Scenario Outline: Login attempts
    Given I am in the home page
    When I enter login credentials:
      | username | <username> |
      | password | <password> |
    And I submit the login form
    Then I should see "<expectedResult>"

    Examples:
      | username      | password       | expectedResult             |
      | jwhite.gomez8 | Password123@   | Login successful           |
      | jwhite.gomez8 | Password123    | Invalid username/password  |
