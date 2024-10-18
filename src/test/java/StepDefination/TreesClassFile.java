package StepDefination;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.DataproviderSupplier;
public class TreesClassFile extends Parent {
	@Test(dataProvider = "TreesTopics", dataProviderClass = DataproviderSupplier.class)	
	public void valid_trees_pane(String treesTopics) throws Exception {		
	
		treePageObjects.click_TreesgetButton();
		extentTest.info("navigated to Treespage");
		Assert.assertTrue(treePageObjects.displayHeading());		
		treePageObjects.get_title();
		System.out.println(treesTopics);
		treePageObjects.user_clicks(treesTopics);
		extentTest.info("navigated to "+treesTopics);
		treePageObjects.get_title();
		queuesPageObjects.click_tryhere();
		extentTest.info("navigated to "+treePageObjects.get_title()+" page");
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();		
		
		}
		
		@Test(dataProvider = "TreesTopics",dataProviderClass = DataproviderSupplier.class)
		public void invalid_trees_pane(String treesTopics) throws Exception {
			treePageObjects.click_TreesgetButton();
			extentTest.info("navigated to Treespage");
			Assert.assertTrue(treePageObjects.displayHeading());		
			treePageObjects.get_title();
			extentTest.info("user clicks "+treesTopics);
			treePageObjects.user_clicks(treesTopics);			
			extentTest.info("user navigated to "+treePageObjects.get_title()+" page");
			queuesPageObjects.click_tryhere();
			extentTest.info("user navigated to "+treePageObjects.get_title()+" page");
			String Invalidcode=excelnew.getData(1, 3);
			datastructpage.enter_valideditor(Invalidcode);
			System.out.println(datastructpage.Output());
			testcontextsetup.testbase.WebDriverManager().quit();
	 
		}
			
	    
	

}