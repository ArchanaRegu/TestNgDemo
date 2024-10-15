package StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobjects.ArraysDocPageObjects;
import Pageobjects.DataStructPage;
import Pageobjects.GraphsPageObjects;
import Pageobjects.QueuesPageObjects;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.DataproviderSupplier;
import Utils.ExcelDataprovider;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class HomepageStepDefination {
	WebDriver driver;
	TestContextSetup testcontextsetup;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	@Test(priority=1)
	public void callingObjects() throws IOException {
		testcontextsetup=new TestContextSetup();
		landingpage=testcontextsetup.pageobjectmanager.getLandingpageobjects();
		signinpage=testcontextsetup.pageobjectmanager.getSigninpageobjects();
	}
	@Test(priority=2,dataProvider ="Registationdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Homepage(String username,String password,String code,String vaIn) throws IOException {
	System.out.println(testcontextsetup.testbase.WebDriverManager().getTitle()+" from Landingpage");
	Assert.assertTrue(landingpage.h1_ptag_getstarted());
	landingpage.click_getstartbtn();
	Assert.assertTrue(signinpage.regis_sign());
	signinpage.click_signin_link();
	System.out.println("This is Beforeclass");
	signinpage.enter_username(username, password);
	signinpage.click_login_btn();
	System.out.println(username+" is username; "+password+" is password" );
	String Actual_title=testcontextsetup.testbase.WebDriverManager().getTitle();
	String Expected_title=landingpage.get_Title();
	Assert.assertEquals(Expected_title,Actual_title);
	
}
	@Test(priority=3)
    public void quitmethod() throws IOException {
    	testcontextsetup.testbase.WebDriverManager().quit();
    }
	
}
