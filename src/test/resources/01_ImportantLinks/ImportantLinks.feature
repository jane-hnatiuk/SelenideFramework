@runnable
@importantLinks
Feature: Important links
  As a site user
  I want to successfully access application important links
  So I will be redirected to appropriate pages

  Background:
    Given I am logged to MyPGS portal

  @positive
  Scenario: Important links list displayed
    When I press ImportantLinksTab on navigation bar
    Then The following links are displayed:
      | adminContact | jira | confluence | crucible | roomReservation |

  @positive
  Scenario Outline: Important link redirects
    When I press <link> on important links navigation bar
    Then The <link> page is opened in new window

    Examples:
      | link            |
      | adminContact    |
      | jira            |
      | confluence      |
      | crucible        |
      | roomReservation |