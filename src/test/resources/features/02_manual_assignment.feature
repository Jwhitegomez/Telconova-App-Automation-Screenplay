# Author: Jimmy
# Language: en

Feature: Manual assignment a technician to a work order
    In order to complete work orders,
    As a supervisor,
    I want to manually assign a technician to a work order.

    Scenario: Manually assigning a technician to a work order
      Given I am in the dashboard
      And I go to manual assignment module
      When I select a technician from the list
      And I assign the technician to a work order
      Then I should confirm that the work order was assigned