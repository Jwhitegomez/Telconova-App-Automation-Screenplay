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

  Scenario Outline: Login Blocked when failed three times
    Given I am in the home page
    When I try to login with wrong credentials three times in a row with:
      | username | <username> |
      | password | <password> |
    Then I should see "<expectedResult>" blocking message

    Examples:
      | username | password | expectedResult                                                        |
      | user1    | user1234 | Cuenta bloqueada por 15 minutos debido a múltiples intentos fallidos. |
