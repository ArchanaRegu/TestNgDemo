package StepDefination;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listenerspackage.ITestListenersclass;
import Utils.DataproviderSupplier;
import Utils.RerunautomationScript;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class QueuesFile extends Parent{
	@Severity(SeverityLevel.MINOR)	
	@Description("Verify Queues and Topics........")
	@Epic("EP001")
	@Feature("Feature1: Logo")
	@Story("Story:Logo Presence")
	@Step("Verify logo Presence")
	@Test(dataProvider = "QueuesTopics",dataProviderClass = DataproviderSupplier.class,description="Verify Queuepane on DsAlgo")
	public void queues_pane_validcode(String QueuesTopic ) throws Exception {
		queuesPageObjects.click_queuesGetStarted();
		extentTest.info("navigated to Queue's page");
		Assert.assertTrue(queuesPageObjects.displayHeading());
		extentTest.pass("Queue's Topics are displayed");
		System.out.println(queuesPageObjects.topicsDisplayed());
		extentTest.pass(QueuesTopic+" is displayed");
		queuesPageObjects.user_clicks(QueuesTopic);
		extentTest.info("user navigated to  "+QueuesTopic);
		String title=queuesPageObjects.get_Title();
		queuesPageObjects.click_tryhere();
		extentTest.info("user is in "+title+" page");
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	    }
	@Test(dataProvider = "QueuesTopics",dataProviderClass = DataproviderSupplier.class)
	public void queues_paneIn(String QueuesTopic) throws Exception {
		queuesPageObjects.click_queuesGetStarted();
		extentTest.info("navigated to Queue's page");
		Assert.assertTrue(queuesPageObjects.displayHeading());
		extentTest.pass("Queue's Topics are displayed");
		System.out.println(queuesPageObjects.topicsDisplayed());
		queuesPageObjects.user_clicks(QueuesTopic);
		extentTest.info("user navigated to  "+QueuesTopic);
		queuesPageObjects.get_Title();
		queuesPageObjects.click_tryhere();
		String title=queuesPageObjects.get_Title();
		extentTest.info("user is in "+title+" page");
		String Invalidcode=excelnew.getData(1, 3);
		datastructpage.enter_valideditor(Invalidcode);
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	    }

}
