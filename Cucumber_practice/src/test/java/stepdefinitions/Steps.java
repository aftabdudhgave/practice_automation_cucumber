package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pageobject.AccountDetailObject;
import pageobject.HomePageObject;
import pageobject.LoginPageObject;
import pageobject.TshirtsObject;
import pageobject.UserHomePageObject;

public class Steps {
	
	public WebDriver driver;
	String firstname, lastname, email, psswrd;
	HomePageObject hpObject;
	LoginPageObject lpObject;
	AccountDetailObject adObject;
	UserHomePageObject uhpObject;
	TshirtsObject tObject;
	WebDriverWait wait;
	
	@Given("user launches chrome browser")
	public void user_launches_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    hpObject = new HomePageObject(driver);
	    lpObject = new LoginPageObject(driver);
	    adObject = new AccountDetailObject(driver);
	    uhpObject = new UserHomePageObject(driver);
	    tObject = new TshirtsObject(driver);
	    wait = new WebDriverWait(driver, 20);
	}

	@Given("opens URL {string}")
	public void opens_url(String string) {
	    driver.get(string);
	}

	@When("user click on sign in button")
	public void user_click_on_sign_in_button() {
	    hpObject.clickOnSignIn();
	}

	@Then("user is redirected to sign in page")
	public void user_is_redirected_to_sign_in_page() {
	    System.out.println("User on page creation");
	    lpObject.checkForPage();
	}

	@Given("enters email id to create account {string} and clicks on create and account")
	public void enterMailCreate(String mail) {
		lpObject = new LoginPageObject(driver);
		lpObject.enterMail(mail);
		email = mail;
	}

	@Then("user is redirected to account creation")
	public void user_is_redirected_to_account_creation() {
	    System.out.println("on page");
	}

	@When("user selects Mr as Title")
	public void user_selects_mr_as_title() {
	    adObject.selectMr();
	}

	@When("enters first name as {string} and last name as {string}")
	public void enters_first_name_as_and_last_name_as(String string, String string2) {
	    adObject.enterNames(string, string2);
	    firstname = string;
	    lastname = string2;
	}


	@When("password as {string}")
	public void password_as(String pass) {
	    adObject.createPass(pass);
	    psswrd = pass;
	}

	@When("date of birth as {string}{string}{string}")
	public void date_of_birth_as(String day, String month, String year) {
	    adObject.selectDateOfBirth(day, month, year);
	}

	@When("enters address with {string} and {string}")
	public void enters_address_with_first_name_and_last_name(String string, String string2) {
	    adObject.addressNames(string, string2);
	}

	@When("company name {string}")
	public void company_name(String company) {
	    adObject.setCompanyName(company);
	}

	@When("address as {string}")
	public void address_as(String string) {
	    adObject.setAddress(string);
	}

	@When("City as {string}")
	public void city(String city) {
	    adObject.setCity(city);
	}

	@When("selects state as {string} with zipcode {int}")
	public void stateAndZipcode(String string, Integer int1) {
	    adObject.setStateAndZip(string, int1);
	}

	@When("adding mobile number as {int} with alias address as {string}")
	public void mobileAliasAddress(Integer int1, String string) {
	    adObject.setPhoneAlias(int1, string);
	}

	@When("clicks on Register")
	public void clicks_on_register() {
	    adObject.register();
	}

	@Then("it should get user to landing page and verifies username")
	public void it_should_get_user_to_landing_page() {
	    uhpObject.verifyName(firstname + " " + lastname);
	}
	
	@Then("clicks on sign out")
	public void logout()
	{
		uhpObject.logOut();
	}
	@Then("close the browser")
	public void quitBrowser() {
		driver.quit();
	}
	
	@When("redirected to sign in page, enters {string} and {string} and signs in")
	public void enterCredentials(String mail, String pass){
		lpObject.setCredentials(mail, pass);
	}
	
	@When("on user home page, user selects T-shirts to buy and clicks on it")
	public void goToTshirts() {
		uhpObject.tshirtsClick();
	}
	
	@Then("user is redirected to tshirts page")
	public void tshirtsPageVerify() {
		tObject.TshirtsVerify();
	}
	
	@When("user clicks on first products add to cart button")
	public void addToCart() {
		tObject.addToCart();
	}
	
	@When("goes to cart and proceeds to checkout")
	public void cart() {
		tObject.goToCart();
		tObject.checkOut();
	}
	
	@Then("item will be shown with the same details in the cart")
	public void checkValues() {
		tObject.finalCheck();
	}
	

}
