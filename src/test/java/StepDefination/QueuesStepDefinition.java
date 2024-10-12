package StepDefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.QueuesPageObjects;
import Utils.ExcelDataprovider;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QueuesStepDefinition extends Parent{
	@Test(dataProvider = "Topics",dataProviderClass = DataproviderSupplier.class)
	public void queues_pane(String[] QueuesTopic ) throws Exception {
		queuesPageObjects.click_queuesGetStarted();
		Assert.assertTrue(queuesPageObjects.displayHeading());
		queuesPageObjects.get_Title();
		System.out.println(queuesPageObjects.topicsDisplayed());
		queuesPageObjects.user_clicks(QueuesTopic[4]);
		 arraysdocpage.click_Tryhere_btn();
		    String validcode=excelnew.getData(1, 2);
			datastructpage.enter_valideditor(validcode);
			System.out.println(datastructpage.Output());
			testcontextsetup.testbase.WebDriverManager().quit();
	    }
	@Test(dataProvider = "Topics",dataProviderClass = DataproviderSupplier.class)
	public void queues_paneIn(String[] QueuesTopic) throws Exception {
		queuesPageObjects.click_queuesGetStarted();
		Assert.assertTrue(queuesPageObjects.displayHeading());
		queuesPageObjects.get_Title();
		System.out.println(queuesPageObjects.topicsDisplayed());
		queuesPageObjects.user_clicks(QueuesTopic[5]);
		 arraysdocpage.click_Tryhere_btn();
		    String Invalidcode=excelnew.getData(1, 3);
			datastructpage.enter_valideditor(Invalidcode);
			System.out.println(datastructpage.Output());
			testcontextsetup.testbase.WebDriverManager().quit();
	    }

}
