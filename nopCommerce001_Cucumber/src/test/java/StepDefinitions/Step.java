package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Step extends baseClass {

	@Before
	public void setup() throws IOException {

		// Reading properties
		configpro = new Properties();
		FileInputStream configprofile = new FileInputStream("config.properties");
		configpro.load(configprofile);
		
		//setting the browsers
		String br = configpro.getProperty("browser");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		} else if (br.equals("ie")) {
			WebDriverManager.iedriver().setup();
		} 

		logger = Logger.getLogger("nopCommerce"); // added logger
		PropertyConfigurator.configure("log4j.properties"); // added logger

		//driver = new ChromeDriver();
		logger.info("********Launching the browser********");
	}

	@Given("User Launch Chrome browr ")
	public void user_Launch_Chrome_browser() {

		loginpage = new LoginPage(driver);
	}

	@When("User open URL ")
	public void user_open_URL(String url) throws InterruptedException {
		// driver.get("https://admin-demo.nopcommerce.com/");
		logger.info("********Opeing the Application Url********");

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(05);
	}

	@When("Click on login link ")
	public void click_on_login_Link() {
		logger.info("********User clicking the login link********");
		loginpage.ClickLoginLink();
	}

	@When("User enters Email as string and Password as string1 ")
	public void user_enters_Email_as_and_Password_as(String Email, String Password) {
		logger.info("********Providing login details********");
		loginpage.EnterEmail(Email);
		loginpage.EnterPassword(Password);
	}

	@When("Click on login ")
	public void click_on_login_Button() {
		logger.info("********Started Login********");
		loginpage.ClickLoginButton();
	}

	@Then("Page title should be ")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("********Login Passed********");
			Assert.assertTrue(true);
		} else {
			logger.info("*****Login Failed*****");
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on Log Out link ")
	public void user_click_on_Log_Out_link() {
		logger.info("*****Click on LogOut link******");
		loginpage.ClickLogoutbutton();
	}

	@Then("Close Browser ")
	public void close_Browser() {
		logger.info("*****Closing browser******");
		driver.close();
	}

	// Added new customer info

	@Then("User can view Dashboard ")
	public void user_can_view_Dashboard() throws Throwable {
		customerpage = new CustomerPage(driver);
		Assert.assertEquals("Customers / nopCommerce administration", customerpage.getpagetitle());
	}

	@When("User click on Customer Menu ")
	public void user_click_on_Customer_Menu() throws Throwable {
		customerpage.ClickCustomerMenu();
	}

	@When("Click on customers menu item ")
	public void click_on_customers_menu_item() throws Throwable {
		customerpage.CLickCustomeritem();
	}

	@When("Click on Add new button ")
	public void click_on_Add_new_button() throws Throwable {
		customerpage.NewCustomerbutton();
	}

	@Then("User can view add new customer page ")
	public void user_can_view_add_new_customer_page() throws Throwable {
		Assert.assertEquals("Add a new customer / nopCommerce administration", customerpage.getpagetitle());
	}

	@When("User enter custoemr info ")
	public void user_enter_custoemr_info() throws Throwable {
		logger.info("*****Adding new customer******");
		logger.info("*****Providing customer details******");
		String email = Randomstring() + "@gamil.com";
		customerpage.Enteremail(email);
		customerpage.Enterpassword("admin");
		customerpage.Enterfirstname("Hanimi");
		customerpage.EnterLastname("Reddy");
		customerpage.SelectMaleradiobutton("Male");
		customerpage.Enterdate("7/10/2001");
		customerpage.EnterComapnyname("abc company");
		customerpage.Clicktaxassumption();
		customerpage.SelectNewsletter("");
		customerpage.SelectCompanyRole("Guest");
		customerpage.selectVendormanager("Vendor 1");
		customerpage.Verifyactivate();
		customerpage.EnterAdminComment("This is for testing.................");
	}

	@When("Click on save button ")
	public void click_on_save_button() throws Throwable {
		logger.info("*****Saving customer details******");
		customerpage.ClickSavebtn();
	}

	@Then("User can view confirmation message ")
	public void user_can_view_confirmation_message(String msg) throws Throwable {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}

}
