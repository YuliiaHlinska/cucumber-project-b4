Feature: Docuport Sample Scenario

  @sampleDocuport
  Scenario: Practice click buttons on different pages as a client
    Given user is on Docuport login page
    When user inserts "b1g1_client@gmail.com" to "username" field on "Login" page
    When user inserts "Group1" to "password" field on "Login" page
    And user clicks "login" button on "Login" page
    And user clicks "continue" button on "Choose account" page
    Then user should be able to see the home for client
    And user clicks "Received Doc" button on "Left Navigate" page
    And user clicks "Search" button on "Received Doc" page
    And user inserts "tax document" to "Document name" field on "Received Doc" page

    And user clicks "Tags" button on "Received Doc" page
    And user inserts "Annual Financials" to "Tags" field on "Received Doc" page
    And user clicks "Upload Date" button on "Received Doc" page
    And user inserts "7" to "Upload date" field on "Received Doc" page
    And user clicks "Upload by" button on "Received Doc" page
    And user inserts "advisor advisor" to "Upload by" field on "Received Doc" page
    And user clicks " Search " button on "Received Doc" page
    Then user should be able to see "There are no items to display"













