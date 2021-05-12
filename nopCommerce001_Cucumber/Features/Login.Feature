Feature: Login

Scenario: Successful Login with valid credentials
	Given User Launch Chrome browser
	When  User open URL "https://admin-demo.nopcommerce.com/login"
	And   User enters Email as "admin@yourstore.com" and Password as "admin"
	And   Click on login
	Then  Page title should be "https://demo.nopcommerce.com/"
	When  User click on Log Out link
	Then  Page Title should be "nopCommerce demo store"
	And   Close Browser
	
