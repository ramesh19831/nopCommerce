package StepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;

public class baseClass {
	
	public WebDriver driver;
	public LoginPage loginpage;
	public CustomerPage customerpage;
	
	public static String Randomstring() {
		String randomnumber = RandomStringUtils.randomAlphabetic(5);
		return randomnumber;
	}

}
