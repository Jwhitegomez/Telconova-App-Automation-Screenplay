# Author: Jimmy
# Language: en

Feature: Navigate from the Home page to the selected model
  In order to rank a car model
  As a registered user
  I want to navigate from the home page to a car model.

  Scenario: Navigate from the home page to the selected model
    Given I am on the Buggy Rating home page
    When I navigate to the vehicles list
    And I select the Lamborghini Veneno model
    Then I should see the model page for Lamborghini Veneno
