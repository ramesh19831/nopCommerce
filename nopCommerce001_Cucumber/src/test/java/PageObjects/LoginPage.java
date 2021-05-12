package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By LoginLink = By.xpath("//*[@class='ico-login']");
	By Emailtxt = By.id("Email");
	By Passwordtxt = By.id("Password");
	By Loginbtn = By.xpath("//*[@class='button-1 login-button']");
	By LogOutLink = By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a");
	
	public void ClickLoginLink() {
		driver.findElement(LoginLink).click();
	}
	
	public void EnterEmail(String Email) {
		driver.findElement(Emailtxt).clear();
		driver.findElement(Emailtxt).sendKeys(Email);
	}
	
	public void EnterPassword(String Password) {
		driver.findElement(Passwordtxt).clear();
		driver.findElement(Passwordtxt).sendKeys(Password);
	}
	
	public void ClickLoginButton() {
		driver.findElement(Loginbtn).click();
	}
	
	public void ClickLogoutbutton() {
		driver.findElement(LogOutLink).click();
	}
	
	
	
	
}
