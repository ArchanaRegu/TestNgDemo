package StepDefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.TreesPageObjects;
import Utils.DataproviderSupplier;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TreesStepDefinition extends Parent {
	@Test(dataProvider = "TreesTopics", dataProviderClass = DataproviderSupplier.class)	
	public void valid_trees_pane(String[] treesTopics) throws Exception {		
	
		treePageObjects.click_TreesgetButton();
		Assert.assertTrue(treePageObjects.displayHeading());		
			treePageObjects.get_title();
			System.out.println(treesTopics[8]);
			treePageObjects.user_clicks(treesTopics[8]);			
			treePageObjects.get_title();
			queuesPageObjects.click_tryhere();
			String validcode=excelnew.getData(1, 2);
			datastructpage.enter_valideditor(validcode);
			System.out.println(datastructpage.Output());
			testcontextsetup.testbase.WebDriverManager().quit();		
		
		}
		
		@Test(dataProvider = "TreesTopics",dataProviderClass = DataproviderSupplier.class)
		public void invalid_trees_pane(String[] treesTopics) throws Exception {
			treePageObjects.click_TreesgetButton();
			Assert.assertTrue(treePageObjects.displayHeading());		
				treePageObjects.get_title();
				System.out.println(treesTopics[8]);
				treePageObjects.user_clicks(treesTopics[8]);			
				treePageObjects.get_title();
				queuesPageObjects.click_tryhere();
				String Invalidcode=excelnew.getData(1, 3);
				datastructpage.enter_valideditor(Invalidcode);
				System.out.println(datastructpage.Output());
				testcontextsetup.testbase.WebDriverManager().quit();
	 
		}
			
	    
	

}