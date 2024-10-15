package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listenerspackage.ITestListenersclass;
import Pageobjects.ArraysDocPageObjects;
import Pageobjects.DataStructPage;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.ExcelDataprovider;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
//@Listeners(ITestListenersclass.class)
public class ArraysDocPageStepDefination extends Parent{
	@Test(dataProvider = "Arraysdatapro",dataProviderClass = DataproviderSupplier.class)
	//@And("User Clicks GetStated button of Arrays pane.")
	public void usingDp(String ArraysLinks) throws Exception {
		arraysdocpage.click_getstarted();
	    System.out.println("actaual list:"+arraysdocpage.List_arraysTopics());
	    System.out.println(ArraysLinks+" This link ");
		arraysdocpage.clickPaneListLinks("Arrays in Python");
		
		arraysdocpage.click_Tryhere_btn();
		//User Enters valid code in editorpage
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		//click run button and capture output
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
		}
	

	@Test(dataProvider = "Arraysdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Arraypage(String ArraysLinks) throws Exception {
		arraysdocpage.click_getstarted();
	    System.out.println("actaual list:"+arraysdocpage.List_arraysTopics());
	    System.out.println(ArraysLinks+" This link ");
		arraysdocpage.clickPaneListLinks(ArraysLinks);
		arraysdocpage.click_Tryhere_btn();
		//User Enters invalid code in editorpage
		String Invalidcode=excelnew.getData(1, 3);	
		datastructpage.enter_Invalideditor(Invalidcode);
		//click run button and capture output
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();	
	}
  	}
