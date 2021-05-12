Feature: Customers

  Scenario: Add a new customer
    Given User launch a chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard
    When User click on Customer Menu
    And Click on customers menu item
    And Click on Add new button
    Then User can view add new customer page
    When User enter custoemr info
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close browser

 Scenario: Search Customer by Emailid
 		Given User Launch Chrome browser
 		When User opens url "http://admin-demo.nopcommerce.com/login"
 		And User enters email as "admin@yourstore.com" and Password as "admin"
 		And Click on login
 		Then User can view dashboard
 		When User click on customers menu
 		And User click on custoemrs menu item
 		And Enter customer email
 		When Click on  search button
 		Then User should found email in the search table
 		And Close browser
 		
