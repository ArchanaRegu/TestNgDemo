package StepDefination;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.DataStructPage;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.TestContextSetup;

public class signinStepDefination {
	TestContextSetup testcontextsetup;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	public DataStructPage datastructpage;
	@BeforeSuite
	public void BeforeScenario() throws IOException {
	System.out.println("This is Before Suite");
	testcontextsetup=new TestContextSetup();
	landingpage=testcontextsetup.pageobjectmanager.getLandingpageobjects();
	signinpage=testcontextsetup.pageobjectmanager.getSigninpageobjects();
	datastructpage=testcontextsetup.pageobjectmanager.getDataStructPage();
	}
	
	@BeforeTest
	public void BeforeScenario1() throws IOException {
		System.out.println(testcontextsetup.testbase.WebDriverManager().getTitle()+" from BeforeTest");
		Assert.assertTrue(landingpage.h1_ptag_getstarted());
		landingpage.click_getstartbtn();
		Assert.assertTrue(signinpage.regis_sign());
		System.out.println(signinpage.datastructure()+" is displayed");
		}
	@BeforeClass
	//@Given("User clicks Sign in link.")
	//@When("User enters Username and password and clicks login button.")
	public void enter_username_password_click_btn() throws IOException {
	signinpage.click_signin_link();
	System.out.println("This is Beforeclass");
	String Username=testcontextsetup.exceldata.getExceldata(1, 0);
	String Password=testcontextsetup.exceldata.getExceldata(1, 1);
	signinpage.enter_username(Username, Password);
	signinpage.click_login_btn();
	
}
	@Test
		//@Then("User enters home page.")
	public void get_title_home_page() {
		System.out.println("you are in first method");
		System.out.println(landingpage.get_Title());
	}

}
