@runnable
Feature: Logout user from application
  As a site user
  I want to successfully logout from application
  So I cannot explore the application pages any further

  Background:
    Given I am logged to MyPGS portal


  @positive
  @close
  Scenario: Logout from application
    When I press MyPGS logout button
    Then I am not logged into MyPGS portal