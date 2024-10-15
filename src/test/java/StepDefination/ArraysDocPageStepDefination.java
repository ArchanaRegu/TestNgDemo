package StepDefination;

import org.testng.annotations.Test;

import Utils.DataproviderSupplier;

//@Listeners(ITestListenersclass.class)
public class ArraysDocPageStepDefination extends Parent{
	@Test(dataProvider = "Arraysdatapro",dataProviderClass = DataproviderSupplier.class)
	//@And("User Clicks GetStated button of Arrays pane.")
	public void usingDp(String ArraysLinks) throws Exception {
		arraysdocpage.click_getstarted();
	    System.out.println("actaual list:"+arraysdocpage.List_arraysTopics());
	    System.out.println(ArraysLinks+" This link ");
		arraysdocpage.clickPaneListLinks("Arrays in Python");
		arraysdocpage.click_Tryhere_btn();
		//User Enters valid code in editorpage
		String validcode=excelnew.getData(1, 2);
		datastructpage.enter_valideditor(validcode);
		//click run button and capture output
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
		}
	

	@Test(dataProvider = "Arraysdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Arraypage(String ArraysLinks) throws Exception {
		arraysdocpage.click_getstarted();
	    System.out.println("actaual list:"+arraysdocpage.List_arraysTopics());
	    System.out.println(ArraysLinks+" This link ");
		arraysdocpage.clickPaneListLinks(ArraysLinks);
		arraysdocpage.click_Tryhere_btn();
		//User Enters invalid code in editorpage
		String Invalidcode=excelnew.getData(1, 3);	
		datastructpage.enter_Invalideditor(Invalidcode);
		//click run button and capture output
		System.out.println(datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();	
	}
  	}
