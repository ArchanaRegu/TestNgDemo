package StepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.ArraysDocPageObjects;
import Pageobjects.RegistrationPage;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.DataproviderSupplier;
import Utils.ExcelDataprovider;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class RegistratnStepDefination {
	TestContextSetup testcontextsetup;
	public RegistrationPage registerpage;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	@Test(priority=1)
	public void callingobjects() throws Exception {
	testcontextsetup=new TestContextSetup();
	landingpage=testcontextsetup.pageobjectmanager.getLandingpageobjects();
	signinpage=testcontextsetup.pageobjectmanager.getSigninpageobjects();
	registerpage=testcontextsetup.pageobjectmanager.getRegistrationPage();
	} 
	@Test(priority=2)
	public void enter_username_password_click_btn() throws IOException {
	System.out.println(testcontextsetup.testbase.WebDriverManager().getTitle()+" from BeforeTest");
	Assert.assertTrue(landingpage.h1_ptag_getstarted());
	landingpage.click_getstartbtn();
	Assert.assertTrue(signinpage.regis_sign());
	System.out.println(signinpage.datastructure()+" is displayed");
	
}
	//Click Registration Link and User is in Registration page.
	@Test(priority=3)
	public void click_registration_link_and_user_is_in_registration_page() {
		registerpage.click_Register();
	}
	
    @Test(priority=4,dataProvider ="Registationdatapro",dataProviderClass = DataproviderSupplier.class) 
	//"User enter credentials and Click Register or Clicks login link"
	public void user_enter_credentials(String username,String password,String code,String valIn) throws IOException {
		System.out.println(username+" is username");
    	registerpage.enter_username(username);
		registerpage.enter_password(password);
		registerpage.enter_confirmpassword(password);
    }
    @Test(priority=5)
    public void clickRegisterbtn() {
		registerpage.click_register_button();
		String Actualmessage=registerpage.alert_message();
		String Expectedmessage="Credentials already exists";
		Assert.assertEquals(Actualmessage, Expectedmessage);
	}
    @Test(priority=6)
    public void quitmethod() throws IOException {
    	testcontextsetup.testbase.WebDriverManager().quit();
    }

	
}
