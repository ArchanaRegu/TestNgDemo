package TestClasses;


import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.DataproviderSupplier;


public class StackClassFile extends Parent {
	@Test(priority=1,dataProvider = "StacksTopics", dataProviderClass = DataproviderSupplier.class)
	public void Valid_Stackpane(String sTopics) throws Exception {
		stackPageObjects.get_title();
		stackPageObjects.click_stack_pane();
		extentTest.info("navigated to Stackpage");
		Assert.assertTrue(stackPageObjects.display_topic_cover());	
		stackPageObjects.get_title();
		System.out.println(sTopics);
		stackPageObjects.user_clicks(sTopics);
		extentTest.info("navigated to "+sTopics+"page");
		stackPageObjects.click_tryhere();
		String title=stackPageObjects.get_title();
		extentTest.info("naviagted to "+title+"page");
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		String output=datastructpage.Output();
		extentTest.info("output:"+output);
		testcontextsetup.testbase.WebDriverManager().quit();		
	
	}
	
	@Test(priority=2,dataProvider = "StacksTopics",dataProviderClass = DataproviderSupplier.class)
	public void invalid_Stackpan(String sTopics) throws Exception {
		stackPageObjects.get_title();
		stackPageObjects.click_stack_pane();
		Assert.assertTrue(stackPageObjects.display_topic_cover());
		stackPageObjects.get_title();
		System.out.println(sTopics);
		stackPageObjects.user_clicks(sTopics);
		stackPageObjects.get_title();
		stackPageObjects.click_tryhere();
		String Invalidcode=excelnew.getData(1, 3);
		datastructpage.enter_valideditor(Invalidcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	    }
}
