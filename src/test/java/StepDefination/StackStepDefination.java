package StepDefination;

import java.util.List;

import org.testng.Assert;

import Pageobjects.StackPageobjects;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class StackStepDefination {
	TestContextSetup testcontestsetup;
	StackPageobjects stackpageobjects;
public StackStepDefination(TestContextSetup testcontestsetup) {
	this.testcontestsetup=testcontestsetup;
	this.stackpageobjects=testcontestsetup.pageobjectmanager.getStackpageobjects();
	
}
@Then("User navigates to Homepage and Clicks GetStated button of Stack pane.")
public void user_clicks_get_started_buttonStackpane() {
stackpageobjects.get_title();
stackpageobjects.click_stack_pane();
Assert.assertTrue(stackpageobjects.display_topic_cover());
}
@Given("User is in Stack Page.")
public void Stackpage() {
	stackpageobjects.get_title();
}
@Then("Stacks page is displayed with Topics covered.")
public void stack_information_is_displayed(DataTable dataTable) {
	List<String>Expected_list=dataTable.asList();
	System.out.println(Expected_list);
	Assert.assertEquals(Expected_list, stackpageobjects.alltopics());
}
}
