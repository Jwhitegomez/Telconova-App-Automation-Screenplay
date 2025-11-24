  #Autor: Jimmy
    #Languaje: en

  Feature: Join the Buggy Cars Rating platform
    In order to join to the Buggy Rating Platform As a new user I want to create an account successfully
    Scenario: Successful account creation
      Given I am in the Buggy Rating home page
      When I choose to create a new account
      And I provide valid registration credentials
      And I submit the registration form
      Then I should confirm that the account was created

    Scenario: Attempt to register with an existing username
      Given I am in the Buggy Rating home page
      When I choose to create a new account
      And I provide registration credentials for an already registered user
      And I submit the registration form
      Then I should see a message indicating that the username is already taken
