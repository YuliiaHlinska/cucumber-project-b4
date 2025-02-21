Feature: Scenario outline practice

  @google_search_outline

  Scenario Outline:
    Given user is on Google page
    When user search for "<country>"
    Then user should see the "<capital>" in the results
    And we love Loop Academy

    Examples:
      | country    | capital          |
      | Azerbaijan | Baku             |
      | Ukraine    | Kyiv             |
      | USA        | Washington, D.C. |
      | Turkey     | Ankara           |
      | Georgia    | Tbilisi          |



