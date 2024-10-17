package StepDefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.GraphsPageObjects;
import Utils.DataproviderSupplier;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class GraphsStepDefinition extends Parent {

	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void graphs_Topic(String username,String password,String code,String validinvalid) throws Exception {
		graphsPageObjects.click_graphsGetStarted();
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    String title= graphsPageObjects.get_Title();
	    graphsPageObjects.click_Tryhere_btn();
		//User Enters valid code in editorpage
	    System.out.println(title+": "+validinvalid+"code ="+code);
		datastructpage.enter_valideditor(code);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Graph_Representation(String username,String password,String code,String validinvalid) throws Exception {
		graphsPageObjects.click_graphsGetStarted();
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph Representations";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    String title= graphsPageObjects.get_Title();
	    arraysdocpage.click_Tryhere_btn();
		//User Enters valid code in editorpage
	    System.out.println(title+": "+validinvalid+",code for "+code+" is:");
		datastructpage.enter_valideditor(code);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	

}