package StepDefinitions;

import PageObjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends BasePage {

	LoginPage loginPage;


@Given("^User Launch browser and navigate to app url$")
public void user_Launch_browser_and_navigate_to_app_url() throws Throwable {
	invoke();
	loginpage = new LoginPage(driver);
}

@Then("^Page title should be \"([^\"]*)\"$")
public void page_title_should_be(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
}

@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
public void user_enters_Email_as_and_Password_as(String Email, String Password) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    loginpage.EnterEmail(Email);
    loginpage.EnterPassword(Password);
}

@When("^Click on login$")
public void click_on_login() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    loginpage.ClickLoginButton();
}

@When("^User click on Log Out link$")
public void user_click_on_Log_Out_link() throws Throwable {

    
}

@Then("^Page Title should be \"([^\"]*)\"$")
public void page_Title_should_be(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^Close Browser$")
public void close_Browser() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}


}
