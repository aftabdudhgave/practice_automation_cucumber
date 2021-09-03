package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtsObject {

	WebDriver odriver;
	WebDriverWait wait;
	Actions action;
	String tPrice, tName;
	
	public TshirtsObject(WebDriver driver) {
		odriver = driver;
		PageFactory.initElements(odriver, this);
		wait = new WebDriverWait(odriver, 20);
		action = new Actions(odriver);
	}
	
	@FindBy(className = "cat-name")
	WebElement categoryName;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	WebElement firstProduct;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li/div/div[2]/h5/a")
	WebElement productName;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li/div/div[2]/div/span")
	WebElement productPrice;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addtoCartBtn;
	
	@FindBy(className = "layer_cart_product_info")
	WebElement cartInfo;
	
	@FindBy(className = "cross")
	WebElement cartInfoClose;
	
	@FindBy(xpath="//div[@class='shopping_cart']/a/b")
	WebElement cartBtn;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement checkOutBtn;
	
	@FindBy(name = "message")
	WebElement messageBox;
	
	@FindBy(name = "processAddress")
	WebElement addressCheckOut;
	
	@FindBy(xpath="//div[@id='uniform-cgv']")
	WebElement termsAcceptBox;
	
	@FindBy(name = "processCarrier")
	WebElement carrierCheckOut;
	
	@FindBy(xpath="//td[@id='total_product']")
	WebElement totalprice;
	
	@FindBy(xpath="//p[@class='product-name']")
	WebElement finalName;
	
	
	public void TshirtsVerify() {
		Assert.assertEquals(categoryName.getText(), "T-SHIRTS ");
	}
	
	public void addToCart() {
		
		//action.moveToElement(firstProduct).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(addtoCartBtn));
		tPrice = productPrice.getText();
		tName = productName.getText();
		addtoCartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(cartInfo));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cartInfoClose.click();
	}
	
	public void goToCart() {
		cartBtn.click();
	}
	
	public void checkOut() {
		checkOutBtn.click();
		wait.until(ExpectedConditions.visibilityOf(messageBox));
		addressCheckOut.click();
		wait.until(ExpectedConditions.visibilityOf(termsAcceptBox));
		termsAcceptBox.click();
		carrierCheckOut.click();
	}
	
	public void finalCheck() {
		Assert.assertEquals(tName, finalName.getText());
		Assert.assertEquals(tPrice, totalprice.getText());
	}
}
