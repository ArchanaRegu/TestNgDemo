package TestClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Utils.DataproviderSupplier;
import Utils.RerunautomationScript;


public class Registrationrerun extends capturescreen {
		
    @Test(testName = "Registration", retryAnalyzer = RerunautomationScript.class,
    		dataProvider ="Registationdatapro",
    		dataProviderClass = DataproviderSupplier.class) 
	public void Registrationpage(String username,String password,String code,String valIn) throws IOException {
    	registerpage=testcontextsetup.pageobjectmanager.getRegistrationPage();
    	landingpage.click_getstartbtn();
    	extentTest.info("navigated to Homepage");
    	registerpage.click_Register();
    	extentTest.info("navigated to Registerpage");
    	registerpage.enter_username(username);
		registerpage.enter_password(password);
		registerpage.enter_confirmpassword(password);
		registerpage.click_register_button();
		String Actualmessage=registerpage.alert_message();
		String Expectedmessage="Credentials already exists";
		Assert.assertEquals(Actualmessage, Expectedmessage);
		//extentTest.pass("Assertion is passed ");
		
    }
    @AfterTest
    public void teardown() throws IOException {
    	testcontextsetup.testbase.WebDriverManager().quit();
    }
  
}
