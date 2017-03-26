
Feature: Games Management

  Scenario: Loging into Gamedb2
    Given Navigate to Gamedb
    When I type valid <email> and <password>
      |email|password|
      |aaar@gmail.com|aaar|
    Then I get logged
    And Add a New <name> <platform> <genre> Game
      |name|platform|genre|
      |Star Craft|PC|Stratey|
    Then Delete Game "Avengers"
    And Edit Game <game> <name> <platform> <genre>
      |game|name|platform|genre|
      |Batman|Resident Evil|PS4|Horror|

