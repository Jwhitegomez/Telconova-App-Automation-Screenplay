# Author: Jimmy
# Language: en

Feature: Join the Buggy Cars Rating platform
  In order to join the Buggy Rating Platform
  As a new user
  I want to create an account successfully

  Scenario Outline: Account creation attempts
    Given I am in the Buggy Rating home page
    When I choose to create a new account
    And I enter the registration data:
      | username   | <username>   |
      | firstName  | <firstName>  |
      | lastName   | <lastName>   |
      | password   | <password>   |
    And I submit the registration form
    Then I should see the message "<expectedMessage>"

    Examples:
      | username       | firstName  | lastName   | password      | expectedMessage                               |
      | jwhite.gomez9  | Jimmy      | Gomez      | Password123@  | Account created                               |
      | jwhite.gomez9  | Jimmy      | Gomez      | Password123@  | UsernameExistsException: User already exists  |
