# Author: Jimmy
# Language: en

Feature: Log into Telconova platform
  In order to access my user account,
  As a registered user,
  I want to log in successfully.

  Scenario Outline: Login attempts
    Given I am in the home page
    When I enter login credentials:
      | username | <username> |
      | password | <password> |
    And I submit the login form
    Then I should see "<expectedResult>"

    Examples:
      | username        | password       | expectedResult             |
      | supervisor_test | password123    | Inicio de sesión exitoso   |
      | supervisor_test | password12     | Credenciales incorrectas   |
