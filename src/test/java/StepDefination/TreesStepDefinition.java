package StepDefination;

import java.util.List;

import org.testng.Assert;

import Pageobjects.TreesPageObjects;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TreesStepDefinition {
	TestContextSetup textContextSetup;
	TreesPageObjects treesPageObjects;	
	
	public TreesStepDefinition(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		treesPageObjects = textContextSetup.pageobjectmanager.getTreesPageObjects();
		
	}
	 @Then("User navigates to Homepage and Clicks GetStated button of Trees pane.")
	public void user_clicks_get_stated_button_of_trees_pane() {
		treesPageObjects.click_TreesgetButton();
		Assert.assertTrue(treesPageObjects.displayHeading());
	    
	}
	 @Given("User is in Tree Page.")
	 public void Treepage() {
		 treesPageObjects.get_title();
	 }

	@Then("Trees page is displayed with Topics covered.")
	public void trees_page_is_displayed_with_topics_covered(DataTable dataTable) {		
		List<String>Expected_list= dataTable.asList();
	    System.out.println("expected list: "+Expected_list);
	    System.out.println("actaual list:"+ treesPageObjects.topics_displayed());
	    Assert.assertEquals(treesPageObjects.topics_displayed(), Expected_list);		
	    
	}

}