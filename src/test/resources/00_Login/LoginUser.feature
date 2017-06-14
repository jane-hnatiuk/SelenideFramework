@runnable
@login
Feature: Login user into application
  As site user
  I want to log in
  In order to access site pages

  @negative
  Scenario Outline: 01 Unsuccessful login using incorrect credentials
    Given I open MyPGS portal login page
    When I enter <valid> username
    And I enter <valid> password
    And I submit login
    Then I am not logged into MyPGS portal

  Examples:
    | valid		|
    | invalid	|
    | empty		|

  @negative
  Scenario: 01 Unsuccessful login using incorrect credentials (cont.)
    Then Login error messages are displayed

  @positive
  Scenario: 02 Successful login using correct credentials
    Given I open MyPGS portal login page
    When I enter valid username
    And I enter valid password
    And I submit login
    Then I am logged into MyPGS portal