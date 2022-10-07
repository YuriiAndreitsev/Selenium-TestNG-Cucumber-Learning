Feature: Ebay iPhone Search

  Background: To Launch the browser
    Given SetupEnv with browser
    Given Launch the browser

  Scenario: Search for Cucumber in Google
    When Open ebay
    Then Enter "iPhone" in the search text box
    Then verify result contains "iPhone"
    Then Close Browser