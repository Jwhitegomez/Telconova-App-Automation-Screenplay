# Author: Jimmy
# Language: en

Feature: Register a new technician
  In order to increase the workforce,
  As an admin user,
  I want to register a technician.

  Scenario Outline: Register a new technician
    Given I am in the admin dashboard
    And I navigate to register a new technician
    When I fill the form with information:
      | name  | <name>   |
      | email | <email>  |
      | phone | <phone>  |
    And I submit the registration form
    Then I should confirm that technician was registered

    Examples:
      | name        | email                   | phone        |
      | Pedro Pablo | pedropablo@gmail.com    | 3194048080   |