package StepDefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;



public class QueuesStepDefinition extends Parent{
	@Test(dataProvider = "Topics",dataProviderClass = DataproviderSupplier.class)
	public void queues_pane_validcode(String[] QueuesTopic ) throws Exception {
		queuesPageObjects.click_queuesGetStarted();
		Assert.assertTrue(queuesPageObjects.displayHeading());
		System.out.println(queuesPageObjects.topicsDisplayed());
		System.out.println(QueuesTopic[4]);
		queuesPageObjects.user_clicks(QueuesTopic[4]);
		queuesPageObjects.get_Title();
		queuesPageObjects.click_tryhere();
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	    }
	@Test(dataProvider = "Topics",dataProviderClass = DataproviderSupplier.class)
	public void queues_paneIn(String[] QueuesTopic) throws Exception {
		queuesPageObjects.click_queuesGetStarted();
		Assert.assertTrue(queuesPageObjects.displayHeading());
		System.out.println(queuesPageObjects.topicsDisplayed());
		System.out.println(QueuesTopic[4]);
		queuesPageObjects.user_clicks(QueuesTopic[4]);
		queuesPageObjects.get_Title();
		queuesPageObjects.click_tryhere();
		String Invalidcode=excelnew.getData(1, 3);
		datastructpage.enter_valideditor(Invalidcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	    }

}
