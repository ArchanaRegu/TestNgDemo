package StepDefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.GraphsPageObjects;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class GraphsStepDefinition extends Parent {

	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void graphs_Topic(String username,String password,String vaildinvalidcode,String vaInva) throws Exception {
		graphsPageObjects.click_graphsGetStarted();
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    String title= graphsPageObjects.get_Title();
	    arraysdocpage.click_Tryhere_btn();
		//User Enters valid code in editorpage
	    System.out.println(title+": "+vaInva+"code ="+vaildinvalidcode);
		datastructpage.enter_valideditor(vaildinvalidcode);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Graph_Representation(String[] validInvalidcode) throws Exception {
		graphsPageObjects.click_graphsGetStarted();
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph Representations";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    String title= graphsPageObjects.get_Title();
	    arraysdocpage.click_Tryhere_btn();
		//User Enters valid code in editorpage
	    System.out.println(title+": "+validInvalidcode[3]+",code for "+validInvalidcode[2]+" is:");
		datastructpage.enter_valideditor(validInvalidcode[2]);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	

}