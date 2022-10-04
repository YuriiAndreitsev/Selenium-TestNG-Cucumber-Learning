Feature: Ebay Sidebar contais elements

  Background: To Launch the browser
    Given SetupEnv with browser
    Given Launch the browser

  Scenario: Check Dropdown Categories contail all Sidebar Categories
    When Open ebay
    Then Click on Shop by category dropdown
    Then Select See All Categories
#    When "Categories" page is opened
#    Then Verify Dropdown Categories contain all Sidebar Categories
    Then Close Browser