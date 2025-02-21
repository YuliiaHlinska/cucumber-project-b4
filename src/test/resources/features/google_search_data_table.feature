Feature: Passing multiple parameters to the same step

  @google_search_data_table
  Scenario: Searching multiple items
    Given user is on Google page
    Then user searches the following items
      | loop academy |
      | java         |
      | selenium     |
      | cucumber bd  |
      | sql          |
      | Nadir        |
  And we love Loop Academy
