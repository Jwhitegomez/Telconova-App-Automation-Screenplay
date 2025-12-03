# Author: Jimmy
# Language: en

Feature: Automatic assignment a technician to a work order
  In order to complete work orders,
  As a supervisor,
  I want to automatically assign a technician to a work order.

  Scenario: Automatically assigning a technician to a work order
    Given I am in the dashboard module
    And I go to automatic assignment module
    When I select a work order from the list
    And I assign automatically the work order
    Then I should confirm that the work order was assigned automatically