package StepDefination;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.RegistrationPage;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.RerunautomationScript;
import Utils.TestContextSetup;

public class Registrationrerun {
	TestContextSetup testcontextsetup;
	public RegistrationPage registerpage;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	@BeforeMethod
	public void callingobjects() throws Exception {
	testcontextsetup=new TestContextSetup();
	landingpage=testcontextsetup.pageobjectmanager.getLandingpageobjects();
	signinpage=testcontextsetup.pageobjectmanager.getSigninpageobjects();
	registerpage=testcontextsetup.pageobjectmanager.getRegistrationPage();
	} 
	
	
    @Test(retryAnalyzer = RerunautomationScript.class,dataProvider ="Registationdatapro",dataProviderClass = DataproviderSupplier.class) 
	//"User enter credentials and Click Register or Clicks login link"
	public void Registrationpage(String username,String password,String code,String valIn) throws IOException {
    	landingpage.click_getstartbtn();
    	registerpage.click_Register();
    	registerpage.enter_username(username);
		registerpage.enter_password(password);
		registerpage.enter_confirmpassword(password);
		registerpage.click_register_button();
		String Actualmessage=registerpage.alert_message();
		String Expectedmessage="Credentials already exists";
		Assert.assertEquals(Actualmessage, Expectedmessage);
		
    }
    @AfterTest
    public void teardown() throws IOException {
    	testcontextsetup.testbase.WebDriverManager().quit();
    }
  
}
