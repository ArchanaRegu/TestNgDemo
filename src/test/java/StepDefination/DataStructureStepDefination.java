package StepDefination;

import java.io.IOException;
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
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.DataproviderSupplier;
import Utils.ExcelDataRetriver;
import Utils.ExcelDataprovider;
import Utils.ExcelUtil;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
public class DataStructureStepDefination extends Parent{
	
	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	//@Given("Click  GetStarted button of Data Structures-Introduction pane.")
	public void Dspage(String username,String password,String code,String validinvalid) throws IOException {
		System.out.println("This is from datastructure"+Thread.currentThread().getName());
		datastructpage.click_DSgetstart();
		Assert.assertTrue(datastructpage.topic_displayed());
	    datastructpage.click_timecomplex();
	    String title=datastructpage.get_Title();
	    //[3] is for valid or invalid title;[2] is code
	    System.out.println(title+": "+validinvalid+"code ="+code);
		datastructpage.click_tryhere();
	    datastructpage.enter_valideditor(code);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	}
	
		}
