Feature: Validate the end to end functionality of customer Page

  Background: Login to application
    Given User Launch browser and navigate to app url
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login

  @Regression
  #Scenario: Adding a new Customer
  Given User click on sideBar Customers link
  When User click on customer link inside customer side bar
  And I Click on Add New button
  When User enter the email address "jirautomation"
  And I Enter the FirstName "Stephen" and Lastname "Raj"
  Then I Click on Save button
  Then I verify the successfull message "The new customer has been added successfully."
  Then I Close the Browser
  

  @NotReady
  Scenario: Search a customer with email address
  
  #@Regression
  #Scenario: Adding new Customer Role
  #@Regression
  #Scenario: Adding a new Vendor
  
  
