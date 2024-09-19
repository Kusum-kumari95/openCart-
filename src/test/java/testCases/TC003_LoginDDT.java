package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	 @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups={"DataDriven","Master"}) //getting data from DataProviders class
     public void verify_loginDDT(String email, String pwd, String exp)  {
		
		logger.info("****** TC003_LoginDDT Started ****");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pwd);
		lp.clickLoginBtn();
		
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetpage = myacc.isMyAccountPageExists();
		
		/* 
		 Data is valid - login success - test pass
		                 login failed - test fail
		                 
		 Data is invalid - login success  - test fail - logout
		                   login failed - test pass
		 */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(false);
			}
			
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
		catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("****** TC003_LoginDDT Finished ****");
		
		
		
	}

}
