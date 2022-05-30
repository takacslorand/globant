Feature: House feature
  Scenario: House in list
    Given A list of houses is available
    When If the house with id 1 exists
    Then House with id 1 is in list

  Scenario: House not in list
    Given A list of houses is available
    When If the house with id 11254 not exists throws exception
    Then I got exception BadRequest