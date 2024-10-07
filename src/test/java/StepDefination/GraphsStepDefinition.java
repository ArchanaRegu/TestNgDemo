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
	public void graphs_Topic(String[] validInvalidcode) throws Exception {
		graphsPageObjects.get_Title();
		graphsPageObjects.click_graphsGetStarted();
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    arraysdocpage.click_Tryhere_btn();
		//User Enters valid code in editorpage
	    System.out.println(validInvalidcode[3]+"code =");
		datastructpage.enter_valideditor(validInvalidcode[2]);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Graph_Representation(String[] validInvalidcode) throws Exception {
		graphsPageObjects.get_Title();
		graphsPageObjects.click_graphsGetStarted();
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph Representations";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    arraysdocpage.click_Tryhere_btn();
		//User Enters valid code in editorpage
	    System.out.println(validInvalidcode[3]+"code for "+graphTopics+" is:");
		datastructpage.enter_valideditor(validInvalidcode[2]);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	

}