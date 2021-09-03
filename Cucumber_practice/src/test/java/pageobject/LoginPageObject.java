package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
	WebDriver odriver;
	WebDriverWait wait;
	
	public LoginPageObject(WebDriver driver) {
		odriver = driver;
		PageFactory.initElements(odriver, this);
		wait = new WebDriverWait(odriver, 20);
	}
	
	@FindBy(id = "email_create")
	WebElement enterCreateMailText;
	
	@FindBy(id = "SubmitCreate")
	WebElement createBtn;
	
	@FindBy(id = "email")
	WebElement userEmail;
	
	@FindBy(id = "passwd")
	WebElement userPass;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	public void enterMail(String email) {
		enterCreateMailText.sendKeys(email);
		createBtn.click();
	}

	public void checkForPage() {
		wait.until(ExpectedConditions.visibilityOf(createBtn));
	}

	public void setCredentials(String mail, String pass) {
		userEmail.sendKeys(mail);
		userPass.sendKeys(pass);
		signInBtn.click();
	}

}
