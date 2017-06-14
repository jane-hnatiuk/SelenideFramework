@runnable
@searchUser
Feature: Search User
  As a site user
  I want to successfully search for user
  So I will be able to check employee details

  Background:
    Given I am logged to MyPGS portal

  @positive
  Scenario Outline: Important links list displayed
    When I search for <valid> user
    Then user details <should> be displayed on results list

    Examples:
      | valid   | should     |
      | valid   | should     |
      | invalid | should not |