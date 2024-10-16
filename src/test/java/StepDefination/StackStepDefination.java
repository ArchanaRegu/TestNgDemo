package StepDefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.StackPageobjects;
import Utils.DataproviderSupplier;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class StackStepDefination extends Parent {
	@Test(dataProvider = "StacksTopics", dataProviderClass = DataproviderSupplier.class)
	public void Valid_Stackpane(String[] sTopics) throws Exception {
		stackPageObjects.get_title();
		stackPageObjects.click_stack_pane();
		Assert.assertTrue(stackPageObjects.display_topic_cover());	
		stackPageObjects.get_title();
		System.out.println(sTopics[9]);
		stackPageObjects.user_clicks(sTopics[9]);
		
		stackPageObjects.get_title();
		queuesPageObjects.click_tryhere();
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();		
	
	}
	
	@Test(dataProvider = "StacksTopics",dataProviderClass = DataproviderSupplier.class)
	public void invalid_Stackpan(String[] sTopics) throws Exception {
		stackPageObjects.get_title();
		stackPageObjects.click_stack_pane();
		Assert.assertTrue(stackPageObjects.display_topic_cover());
		stackPageObjects.get_title();
		System.out.println(sTopics[9]);
		stackPageObjects.user_clicks(sTopics[9]);
		stackPageObjects.get_title();
		queuesPageObjects.click_tryhere();
		String Invalidcode=excelnew.getData(1, 3);
		datastructpage.enter_valideditor(Invalidcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	    }
}
