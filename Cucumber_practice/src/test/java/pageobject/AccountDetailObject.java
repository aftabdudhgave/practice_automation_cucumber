package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDetailObject {

	WebDriver odriver;
	WebDriverWait wait;
	
	public AccountDetailObject(WebDriver driver) {
		odriver = driver;
		PageFactory.initElements(odriver, this);
		wait = new WebDriverWait(odriver, 20);
	}
	
	@FindBy(id="id_gender1")
	WebElement mrRadBtn;
	
	@FindBy(id="customer_firstname")
	WebElement firstNameText;
	
	@FindBy(id="customer_lastname")
	WebElement lastNameText;
	
	@FindBy(id="firstname")
	WebElement adFirstNameText;
	
	@FindBy(id="lastname")
	WebElement adLastNameText;
	
	@FindBy(id="days")
	WebElement dayMenu;
	
	@FindBy(id="months")
	WebElement monthMenu;
	
	@FindBy(id="years")
	WebElement yearMenu;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="company")
	WebElement companyTxt;
	
	@FindBy(id="address1")
	WebElement addressTxt;
	
	@FindBy(id="city")
	WebElement cityTxt;
	
	@FindBy(id="id_state")
	WebElement stateMenu;
	
	@FindBy(id="postcode")
	WebElement zipCodeTxt;
	
	@FindBy(id="phone_mobile")
	WebElement phoneNumberTxt;
	
	@FindBy(id="alias")
	WebElement aliasTxt;
	
	@FindBy(id="submitAccount")
	WebElement registerBtn;
	
	public void selectMr() 
	{
		mrRadBtn.click();
	}
	
	public void enterNames(String name, String lastName) 
	{
		firstNameText.sendKeys(name);
		lastNameText.sendKeys(lastName);
	}
	
	public void createPass(String pass) 
	{
		password.sendKeys(pass);
	}
	
	public void selectDateOfBirth(String date, String month, String year) {
		Select dateDD = new Select(dayMenu);
		dateDD.selectByValue(date);
		Select monthDD = new Select(monthMenu);
		monthDD.selectByIndex(Integer.parseInt(month) + 1);
		Select yearDD = new Select(yearMenu);
		yearDD.selectByValue(year);
	}
	
	public void addressNames(String name, String lastName) {
		adFirstNameText.clear();
		adLastNameText.clear();
		adFirstNameText.sendKeys(name);
		adLastNameText.sendKeys(lastName);
	}

	public void setCompanyName(String company) {
		companyTxt.sendKeys(company);
		
	}

	public void setAddress(String string) {
		addressTxt.sendKeys(string);
	}

	public void setCity(String city) {
		cityTxt.sendKeys(city);
	}

	public void setStateAndZip(String state, Integer zip) {
		Select stateDD = new Select(stateMenu);
		stateDD.selectByVisibleText(state);
		zipCodeTxt.sendKeys(zip.toString());
		
	}
	
	public void setPhoneAlias(Integer phone, String aliasAd) 
	{
		phoneNumberTxt.sendKeys(phone.toString());
		aliasTxt.clear();
		aliasTxt.sendKeys(aliasAd);
	}
	
	public void register() {
		registerBtn.click();
	}
	
	public void checkForPage() {
		
		wait.until(ExpectedConditions.visibilityOf(adFirstNameText));
	}
}
