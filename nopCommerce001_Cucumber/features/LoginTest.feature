Feature: Validate the end to end functionality of Login Page

  @Smoke
  Scenario: Successful Login with valid credentials
    Given User Launch browser and navigate to app url
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then I Close the Browser
