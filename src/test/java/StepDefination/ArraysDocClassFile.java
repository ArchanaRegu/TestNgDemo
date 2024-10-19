package StepDefination;

import org.testng.annotations.Test;

import Utils.DataproviderSupplier;

//@Listeners(ITestListenersclass.class)
public class ArraysDocClassFile extends Parent{
	@Test(dataProvider = "Arraysdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Array_valid(String ArraysTopicLink) throws Exception {
		arraysdocpage.click_getstarted();
		extentTest.info("navigated to Arrays's page");
	    System.out.println("actaual list:"+arraysdocpage.List_arraysTopics());
	    System.out.println(ArraysTopicLink+" This link ");
		arraysdocpage.clickPaneListLinks(ArraysTopicLink);
		extentTest.info("navigated to "+ArraysTopicLink+" page");
		arraysdocpage.click_Tryhere_btn();
		String title=arraysdocpage.get_Title();
		extentTest.info("navigated to "+title+" page");
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		//click run button and capture output
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
		}
	

	@Test(dataProvider = "Arraysdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Array_invalid(String ArraysTopicLink) throws Exception {
		arraysdocpage.click_getstarted();
		extentTest.info("navigated to Arrays's page");
	    System.out.println("actaual list:"+arraysdocpage.List_arraysTopics());
	    System.out.println(ArraysTopicLink+" This link ");
		arraysdocpage.clickPaneListLinks(ArraysTopicLink);
		extentTest.info("navigated to "+ArraysTopicLink+" page");
		arraysdocpage.click_Tryhere_btn();
		String title=arraysdocpage.get_Title();
		extentTest.info("navigated to "+title+" page");
		//User Enters invalid code in editorpage
		String Invalidcode=excelnew.getData(1, 3);	
		datastructpage.enter_Invalideditor(Invalidcode);
		//click run button and capture output
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();	
	}
  	}
