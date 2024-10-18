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


public class GraphsFile extends Parent {

	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void graphs_Topic(String username,String password,String code,String validinvalid) throws Exception {
		graphsPageObjects.click_graphsGetStarted();
		extentTest.info("navigated to Graph page");
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    extentTest.info("navigated to"+ graphTopics +"page");
	    graphsPageObjects.click_Tryhere_btn();
	    String title= graphsPageObjects.get_Title();
	    extentTest.info(title+": "+validinvalid+"code ="+code);
		datastructpage.enter_valideditor(code);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	@Test(dataProvider = "Graphsdatapro",dataProviderClass = DataproviderSupplier.class)
	public void Graph_Representation(String username,String password,String code,String validinvalid) throws Exception {
		graphsPageObjects.click_graphsGetStarted();
		extentTest.info("navigated to Graph page");
	   	graphsPageObjects.scroll_topicscovered();
	    System.out.println("actaual list:"+graphsPageObjects.graph_topicsDisplayed());
	    String graphTopics="Graph Representations";
	    graphsPageObjects.clickGraphsListLinks(graphTopics);
	    extentTest.info("navigated to"+ graphTopics +"page");
	    arraysdocpage.click_Tryhere_btn();
	    String title= graphsPageObjects.get_Title();
	    extentTest.info(title+": "+validinvalid+"code ="+code);
		datastructpage.enter_valideditor(code);
		//click run button and capture output
		System.out.println("output : "+datastructpage.Output());
		testcontextsetup.testbase.WebDriverManager().quit();
    }
	

}