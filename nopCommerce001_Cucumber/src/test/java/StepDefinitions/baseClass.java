package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;

public class baseClass {
	
	public WebDriver driver;
	public LoginPage loginpage;
	public CustomerPage customerpage;
	public static Logger logger;
	public static Properties configpro;
	
	public static String Randomstring() {
		String randomnumber = RandomStringUtils.randomAlphabetic(5);
		return randomnumber;
	}

}
