package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHomePageObject {
	
	WebDriver odriver;
	WebDriverWait wait;
	
	public UserHomePageObject(WebDriver driver) {
		odriver = driver;
		PageFactory.initElements(odriver, this);
		wait = new WebDriverWait(odriver, 20);
	}
	
	@FindBy(xpath="//a[@class='account']/span")
	WebElement userName;
	
	@FindBy(className = "logout")
	WebElement signOutBtn;
	
	@FindBy(xpath = "//div/ul/li[3]/a[text()='T-shirts']")
	WebElement tshirtsLink;
	
	public void verifyName(String name) 
	{
		String userNameTxt = userName.getText();
		Assert.assertEquals(name, userNameTxt);
	}
	
	public void logOut() {
		signOutBtn.click();
	}
	
	public void tshirtsClick() {
		tshirtsLink.click();
	}

}
