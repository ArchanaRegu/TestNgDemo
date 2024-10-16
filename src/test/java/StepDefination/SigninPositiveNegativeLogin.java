package StepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.ExcelDataSupplier;
import Utils.ExcelUtil;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;

public class SigninPositiveNegativeLogin extends capturescreen{
	
	@Test(dataProvider="Logindata",dataProviderClass = ExcelDataSupplier.class)
	public void LoginTest(String username,String password,String expected_Result) throws IOException {
		landingpage.click_getstartbtn();
		signinpage.click_signin_link();
		signinpage.enter_username(username, password);
		signinpage.click_login_btn();
		String exp_title="NumpyNinja";
		String act_title=landingpage.get_Title();
		if(expected_Result.equals("Valid")) {
			if(exp_title.equals(act_title)) {
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
				}
		else if(expected_Result.equals("InValid")) {
			if(exp_title.equals(act_title)) {
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
					}
		System.out.println(username+" "+password+" "+expected_Result);
		testcontextsetup.testbase.WebDriverManager().quit();
	}


}
