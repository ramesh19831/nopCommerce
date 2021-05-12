package StepDefinitions;

import PageObjects.CustomerPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomerStepDefinition extends BasePage {

	CustomerPage customerPage;

@Given("^User click on sideBar Customers link$")
public void user_click_on_sideBar_Customers_link() throws Throwable {
   customerPage = new CustomerPage(driver);
   customerPage.ClickCustomerMenu();

}

@When("^User click on customer link inside customer side bar$")
public void user_click_on_customer_link_inside_customer_side_bar() throws Throwable {
   customerPage.CLickCustomeritem();
    
}

@When("^I Click on Add New button$")
public void i_Click_on_Add_New_button() throws Throwable {
   
    customerPage.NewCustomerbutton();
}

@When("^User enter the email address \"([^\"]*)\"$")
public void user_enter_the_email_address(String email) throws Throwable {
	String random = Randomstring();
   customerPage.Enteremail(email+random+"@gmail.com");

}

@When("^I Enter the FirstName \"([^\"]*)\" and Lastname \"([^\"]*)\"$")
public void i_Enter_the_FirstName_and_Lastname(String fname, String lname) throws Throwable {
   customerPage.Enterfirstname(fname);
   customerPage.EnterLastname(lname);
    
}

@Then("^I Click on Save button$")
public void i_Click_on_Save_button() throws Throwable {
   
    customerPage.ClickSavebtn();
}

@Then("^I verify the successfull message \"([^\"]*)\"$")
public void i_verify_the_successfull_message(String arg1) throws Throwable {
   
//    customerPage.Verifyactivate();
}
@Then("^I Close the Browser$")
public void i_Close_the_Browser() throws Throwable {
    closeBrowser();
}


}
