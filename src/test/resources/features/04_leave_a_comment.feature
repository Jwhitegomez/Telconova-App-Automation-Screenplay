# Author: Jimmy
# Language: en

Feature: Leave a comment on a car model page
  In order to share my opinion about a car
  As a registered user
  I want to leave a comment and see it published

  Scenario: User cannot post a comment when not logged in
    Given I am on the model page for Lamborghini Veneno
    When I try to leave a comment
    Then I should see that I need to be logged in to comment

  Scenario: Leave a comment on the model after logging in
    Given I am on the model page for Lamborghini Veneno
    And I log in from the model page
    When I leave a comment.
    Then I should see the posted comment.
