package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageObject {

	WebDriver odriver;
	public HomePageObject(WebDriver driver) {
		odriver = driver;
		PageFactory.initElements(odriver, this);
	}
	
	@FindBy(className = "login")
	WebElement signInButton;
	
	public void clickOnSignIn() {
		signInButton.click();
	}
	

}
