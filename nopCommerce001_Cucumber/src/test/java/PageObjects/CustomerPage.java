package PageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {

	public WebDriver driver;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	By CustomerMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	By CustomerItem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");

	By NewCustomerbtn = By.xpath("//*[@class=\"btn btn-primary\"]");

	By Emailtxt = By.id("Email");
	By Passwordtxt = By.id("Password");
	By Firstnametxt = By.id("FirstName");
	By Lastnametxt = By.id("LastName");
	By Malegender = By.id("Gender_Male");
	By Femalegender = By.id("Gender_Female");
	By Date = By.id("DateOfBirth");
	By Companynametxt = By.id("Company");
	By Taxcheckbox = By.id("IsTaxExempt");
	
	By Neslettertxt = By.xpath("//*[@class='k-widget k-multiselect k-multiselect-clearable']");
	By Store = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_taglist\"]/li[1]/span[1]");
	By TestStore = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_taglist\"]/li[2]/span[1]");

	By Custoemrroleselect = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");

	By Registerlink = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	By Adminlink = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li[2]/span[1]");
	By Guestlink = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li[3]/span[1]");
	By Vendorslink = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li[4]/span[1]");

	By Vendordropdown = By.id("VendorId");
	By activecheckbox = By.id("Active");
	By admincommenttxt = By.id("AdminComment");

	By Savebtn = By.name("save");

	public String getpagetitle() {
		return driver.getTitle();
	}
	
	public void ClickCustomerMenu() {
		driver.findElement(CustomerMenu).click();
	}

	public void CLickCustomeritem() {
		driver.findElement(CustomerItem).click();
	}

	public void NewCustomerbutton() {
		driver.findElement(NewCustomerbtn).click();
	}

	public void Enteremail(String email) {
		driver.findElement(Emailtxt).sendKeys(email);
	}

	public void Enterpassword(String Password) {
		driver.findElement(Passwordtxt).sendKeys(Password);
	}

	public void Enterfirstname(String Firstname) {
		driver.findElement(Firstnametxt).sendKeys(Firstname);
	}

	public void EnterLastname(String Lastname) {
		driver.findElement(Lastnametxt).sendKeys(Lastname);
	}

	public void SelectMaleradiobutton(String radiobutton) {
		if (radiobutton.equals("Male")) {
			driver.findElement(Malegender);
		} 
		if(radiobutton.equals("Female")) {
			driver.findElement(Femalegender);
		}
		else {
			driver.findElement(Malegender);
		}
	}
	
	public void Enterdate(String date) {
		driver.findElement(Date).sendKeys(date);
	}
	
	public void EnterComapnyname(String Companyname) {
		driver.findElement(Companynametxt).sendKeys(Companyname);
	}
	
	public void Clicktaxassumption() {
		driver.findElement(Taxcheckbox).click();
	}

	public void EnterNewsletter(String NewsLetter) {
		driver.findElement(Neslettertxt).sendKeys(NewsLetter);
	}

	public void SelectNewsletter(String value) {
		if(value.equals("Your Store name"))
		{
			driver.findElement(Store);
		}
		if(value.equals("Test Store2")) {
			driver.findElement(TestStore);
		}
		else {
			driver.findElement(Store); //default
		}
	}
	
	public void SelectCompanyRole(String role) throws InterruptedException {
		if (!role.equals("vendors")) {
			driver.findElement(Custoemrroleselect).isSelected();
		}
		driver.findElement(Custoemrroleselect).click();
		WebElement listitem;
		Thread.sleep(02);
		if (role.equals("Registre")) {
			listitem = driver.findElement(Registerlink);
		} else if (role.equals("Guest")) {
			listitem = driver.findElement(Guestlink);
		} else if (role.equals("Adminitration")) {
			listitem = driver.findElement(Adminlink);
		} else if (role.equals("Vendors")) {
			listitem = driver.findElement(Vendorslink);
		} else {
			listitem = driver.findElement(Guestlink);
		}

		listitem.click();
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", listitem);
	}
	
	public void selectVendormanager(String value) {
		Select vendor = new Select (driver.findElement(Vendordropdown));
		vendor.selectByVisibleText(value);
	}
	
	public void Verifyactivate() {
		driver.findElement(activecheckbox).isSelected();
	}
	
	public void EnterAdminComment(String Comment) {
		driver.findElement(admincommenttxt).sendKeys(Comment);
	}

	public void ClickSavebtn() {
		driver.findElement(Savebtn).click();
	}

}
