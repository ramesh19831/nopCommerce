Feature: Customers

Background: Below are common steps for every scenario
    Given User launch a chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard
    And Close browse

  Scenario: Add a new customer
    When User click on Customer Menu
    And Click on customers menu item
    And Click on Add new button
    Then User can view add new customer page
    When User enter custoemr info
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully."

 Scenario: Search Customer by Emailid	 		
    When User click on customers menu
 		And User click on custoemrs menu item
 		And Enter customer email
 		When Click on  search button
 		Then User should found email in the search table
 		
 Scenario: Search Customer by name 		
 		When User click on customers menu
 		And User click on custoemrs menu item
 		And USer enter first name
 		And User enter lastname
 		When Click on  search button
 		Then User should found name in the search table
 		
 		
