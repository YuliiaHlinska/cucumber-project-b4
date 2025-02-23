Feature: Google Search Functionality Title Verification
  User story: As u user, when I am on  aGiigle search page
  I should be able to search whataewer I want and see the relevant information


  Scenario: Search functionality result title verification
    Given user is on Google page
    When user types Loop Academy in the google search box and click here
    Then user should be see Loop Academy in the google title

  @google_search
  Scenario: Search functionality result title verification
  Given user is on Google page
  When user types "Loop Academy" in the google search box and clicks enter
  Then user should see "Loop Academy - Google Search" in the google title


  Scenario: Search functionality result title verification
    Given user is on Google page
    When user types "Yuliia Hlinska" in the google search box and clicks enter
    Then user should see "Yuliia Hlinska - Google  Search" in the google title
