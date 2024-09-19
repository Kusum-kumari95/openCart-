package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void verify_login() {
		
		logger.info("****** TC002_LoginTest Started ****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLoginBtn();
		
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetpage = myacc.isMyAccountPageExists();
		Assert.assertTrue(targetpage);
		}
		catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("****** TC002_LoginTest Finished ****");
		
		
		
	}
}
