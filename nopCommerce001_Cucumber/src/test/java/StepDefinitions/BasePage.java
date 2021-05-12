package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	public LoginPage loginpage;
	public CustomerPage customerpage;
	public static Logger logger;
	public static Properties configpro;
	public static DesiredCapabilities cap;

	
	public static String Randomstring() {
		String randomnumber = RandomStringUtils.randomAlphabetic(5);
		return randomnumber;
	}
	
	public void invoke() throws IOException {
		properties();
		System.out.println("Running Browser name");
		invokeBrowser("Chrome");
		driver.get(configpro.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	@SuppressWarnings("deprecation")
	public void invokeBrowser(String browser) {

	System.out.println("Browser name");
			if (browser.contains("Chrome")) {
				System.out.println("Browser chrome");
			   WebDriverManager.chromedriver().setup();
			   ChromeOptions options = new ChromeOptions();
			   options.addArguments("--incognito");
			    new DesiredCapabilities();
				cap = DesiredCapabilities.chrome();
			   cap.setCapability(ChromeOptions.CAPABILITY, options);
			   driver = new ChromeDriver(cap);
				
			} else if (browser.contains("Firefox")) {

				
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions fp = new FirefoxOptions();
				String path = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
				fp.setBinary(path);
				driver = new FirefoxDriver(fp);
			} else {

			}
		
	}
	
	public void closeBrowser() {
		driver.close();
	}
	public  void properties() throws IOException {

		// Reading properties
		configpro = new Properties();
		FileInputStream configprofile = new FileInputStream("config.properties");
		configpro.load(configprofile);
		
		//setting the browsers

	}

}
