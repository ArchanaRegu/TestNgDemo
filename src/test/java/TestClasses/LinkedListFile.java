package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.DataproviderSupplier;

public class LinkedListFile extends Parent {
	@Test(dataProvider = "LinkedTopics", dataProviderClass = DataproviderSupplier.class)

	public void userClicks_linked_list(String LinkedListTopics) throws Exception {
		linkedPageObject.get_Title();
		linkedPageObject.click_LinkedgetButton();
		extentTest.info("navigated to LinkedList page");
		Assert.assertTrue(linkedPageObject.displayHeading());
		linkedPageObject.get_Title();
		System.out.println("actaual list:" + linkedPageObject.topics_displayed());
		linkedPageObject.user_clicks(LinkedListTopics);
		extentTest.info("navigated to "+LinkedListTopics);
		linkedPageObject.get_Title();
		queuesPageObjects.click_tryhere();
		extentTest.info("navigated to "+linkedPageObject.get_Title());
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	}		
	
	@Test(dataProvider = "LinkedTopics",dataProviderClass = DataproviderSupplier.class)
	public void invalid_linked_list(String LinkedListTopics) throws Exception {
		linkedPageObject.get_Title();
		linkedPageObject.click_LinkedgetButton();
		extentTest.info("navigated to LinkedList page");
		Assert.assertTrue(linkedPageObject.displayHeading());
		linkedPageObject.get_Title();
		System.out.println("actaual list:" + linkedPageObject.topics_displayed());
		linkedPageObject.user_clicks(LinkedListTopics);
		extentTest.info("navigated to "+LinkedListTopics);
		linkedPageObject.get_Title();
		queuesPageObjects.click_tryhere();
		extentTest.info("navigated to "+linkedPageObject.get_Title());
		String Invalidcode=excelnew.getData(1, 3);
		datastructpage.enter_valideditor(Invalidcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	    }
}