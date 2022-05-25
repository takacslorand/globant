Feature: Book feature
  Scenario: Book in list
    Given A list of books is available
    When If the book with id 1 exists
    Then Books with id 1 is in list

  Scenario: Book not in list
    Given A list of books is available
    When If the book with id 11254 not exists
    Then Books with id 11254 is not in list