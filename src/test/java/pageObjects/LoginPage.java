package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtinputemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtinputpwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	public void enterEmail(String email) {
		txtinputemail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		txtinputpwd.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		loginbtn.click();
	}
}
