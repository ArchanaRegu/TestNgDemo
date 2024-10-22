package TestClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.DataproviderSupplier;
public class HomepageFile extends capturescreen{
		
	@Test(priority=2,dataProvider ="Registationdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Homepage(String username,String password,String code,String vaIn) throws IOException {
	System.out.println(testcontextsetup.testbase.WebDriverManager().getTitle()+" from Landingpage");
	Assert.assertTrue(landingpage.h1_ptag_getstarted());
	landingpage.click_getstartbtn();
	extentTest.info("navigated to Graph page");
	Assert.assertTrue(signinpage.regis_sign());
	extentTest.pass("Signin link and Registration links are visible");
	signinpage.click_signin_link();
	extentTest.info("navigated to Signinpage");
	signinpage.enter_username(username, password);
	extentTest.info("Entered username and password");
	signinpage.click_login_btn();
	extentTest.info("navigated to Homepage");
	System.out.println(username+" is username; "+password+" is password" );
	String Actual_title=testcontextsetup.testbase.WebDriverManager().getTitle();
	String Expected_title=landingpage.get_Title();
	Assert.assertEquals(Expected_title,Actual_title);
	extentTest.pass("actual title:"+Actual_title+"Expected title:"+Expected_title);
}
	@Test(priority=3)
    public void quitmethod() throws IOException {
    	testcontextsetup.testbase.WebDriverManager().quit();
    }
	
}
