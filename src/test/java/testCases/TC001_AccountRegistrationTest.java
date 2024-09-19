package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	 @Parameters ({"os", "browser"})
	public void verify_account_registration() {
		//logger.info("***** Starting TC001_AccountRegistrationTest ****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		//logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		//logger.info("Clicked on Register Link");
		
		AccountRegistrationPage accReg = new AccountRegistrationPage(driver);
		//logger.info("Providing Customer Details");
		accReg.setFirstName(randomString().toUpperCase());
		accReg.setLastName(randomString().toUpperCase());
		accReg.setEmail(randomString() + "@gmail.com");
		accReg.setTelephone(randomNumber());
		
		String password = randomAlphaNumber();
		accReg.setPassword(password);
		accReg.setConfirmPassword(password);
		accReg.setPrivacyPolicy();
		accReg.clickContinue();
		
		//logger.info("Validating Expected Message");
		String confmsg = accReg.getConfirmationMsg();
        if (confmsg != null && confmsg.equals("Your Account Has Been Created!")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Expected confirmation message not found or returned null");
        }
		}
//		String confmsg = accReg.getConfirmationMsg();
//		if(confmsg.equals("Your Account Has Been Created!")) 
//		{
//			Assert.assertTrue(true);
//		}
//		else 
//		{
//			//logger.error("Test failed..");
//			//logger.debug("Debug logs..");
//			Assert.assertFalse(false);
//		}	//	Assert.assertEquals(confmsg, "Register Account");
//		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		//logger.info("******* Finished TC001_AccountRegistrationTest *****");
	}
	
	
	
}
