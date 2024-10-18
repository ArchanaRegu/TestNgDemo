package StepDefination;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.DataproviderSupplier;

public class DataStructure extends Parent{
	
	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Dspage(String username,String password,String code,String validinvalid) throws IOException {
		System.out.println("This is from datastructure"+Thread.currentThread().getName());
		datastructpage.click_DSgetstart();
		extentTest.info("navigated to DataStructure page");
		Assert.assertTrue(datastructpage.topic_displayed());
	    datastructpage.click_timecomplex();
	    String title=datastructpage.get_Title();
	    extentTest.info(title+": "+validinvalid+"code ="+code);
		datastructpage.click_tryhere();
		extentTest.info("navigated to Editor page");
	    datastructpage.enter_valideditor(code);
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
	}
	
		}
