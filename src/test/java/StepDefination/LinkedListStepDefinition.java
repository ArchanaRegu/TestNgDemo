package StepDefination;

import java.util.List;

import org.testng.Assert;

import Pageobjects.LinkedListPageObjects;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LinkedListStepDefinition {
	TestContextSetup textContextSetup;
	LinkedListPageObjects linkedPageObject;
	
	public LinkedListStepDefinition(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		linkedPageObject = textContextSetup.pageobjectmanager.getLinkedPageObject();
		
	}
	@Then("User navigates to Homepage and Clicks GetStated button of LinkedList pane.")
	public void user_clicks_get_stated_button_of_linked_list_pane() {
		linkedPageObject.get_Title();
		linkedPageObject.click_LinkedgetButton();
		Assert.assertTrue(linkedPageObject.displayHeading());

	}
	 @Given("User is in LinkedList page.")
	 public void LinkedListpage() {
		 linkedPageObject.get_Title();
	 }

	@Then("LinkedList page is displayed with Topics covered.")
	public void linked_list_page_is_displayed_with_topics_covered(DataTable LinkedList_topics) {
		List<String>Expected_list=LinkedList_topics.asList();
	    System.out.println("expected list: "+Expected_list);
	    System.out.println("actaual list:"+linkedPageObject.topics_displayed());
	    Assert.assertEquals(linkedPageObject.topics_displayed(),Expected_list);
	}

	@Given("User clicks {string}")
	public void user_clicks(String string) {
		linkedPageObject.user_clicks(string);
	}

	

}