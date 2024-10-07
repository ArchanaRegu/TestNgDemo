package StepDefination;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.ArraysDocPageObjects;
import Pageobjects.DataStructPage;
import Pageobjects.GraphsPageObjects;
import Pageobjects.QueuesPageObjects;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.ExcelDataprovider;
import Utils.TestContextSetup;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Parent {
	
	WebDriver driver;
	TestContextSetup testcontextsetup;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	DataStructPage datastructpage;
	ExcelDataprovider excelnew;
	ArraysDocPageObjects arraysdocpage;
	GraphsPageObjects graphsPageObjects;
	QueuesPageObjects queuesPageObjects;
	@BeforeMethod
	@Test
	public void username_password() throws IOException {
	testcontextsetup=new TestContextSetup();
	landingpage=testcontextsetup.pageobjectmanager.getLandingpageobjects();
	signinpage=testcontextsetup.pageobjectmanager.getSigninpageobjects();
	datastructpage=testcontextsetup.pageobjectmanager.getDataStructPage();
	arraysdocpage=testcontextsetup.pageobjectmanager.getArrayDocPage();
	graphsPageObjects = testcontextsetup.pageobjectmanager.getGraphsPageObjects();
	queuesPageObjects = testcontextsetup.pageobjectmanager.getQueuesPageObject();
	excelnew=new ExcelDataprovider();
	System.out.println(testcontextsetup.testbase.WebDriverManager().getTitle()+" from BeforeTest");
	Assert.assertTrue(landingpage.h1_ptag_getstarted());
	landingpage.click_getstartbtn();
	Assert.assertTrue(signinpage.regis_sign());
	System.out.println(signinpage.datastructure()+" is displayed");
	signinpage.click_signin_link();
	System.out.println("This is Beforeclass");
	String Username=excelnew.getData(1, 0);
	String Password=excelnew.getData(1, 1);
	signinpage.enter_username(Username, Password);
	signinpage.click_login_btn();
	
}
	@BeforeSuite
	public void BeforeSuite() throws IOException {
	System.out.println("This is Before Suite");
		}
	@BeforeTest
	public void BeforeScenario1() throws IOException {
		System.out.println("This is in Before Test");
		
			}
	
	
	}
	

	

