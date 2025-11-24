# Author: Jimmy
# Language: en

Feature: Login to the Buggy Cars Rating platform
  In order to access my user account
  As a registered user
  I want to log in successfully

  Scenario: Successful login
    Given I am in the home page
    When I enter valid login credentials
    And I submit the login form
    Then I should see that I have logged in successfully

  Scenario: Failed login due to invalid credentials
    Given I am in the home page
    When I enter invalid login credentials
    And I submit the login form
    Then I should see an error message indicating that the login failed
