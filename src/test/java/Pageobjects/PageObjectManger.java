package Pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManger {
public WebDriver driver;
public landingpageobjects landingpage;
public Signinpageobjects signinpage;
public DataStructPage datastructpage;
public ArraysDocPageObjects arraysdocpage;
public StackPageobjects stackpageobject;
public LinkedListPageObjects linkedPage;
public QueuesPageObjects queuesPageObject;
public GraphsPageObjects graphsPageObjects;
public TreesPageObjects treesPageObjects;
public RegistrationPage registerpage;
public PageObjectManger(WebDriver driver) {
	this.driver=driver;
}
public RegistrationPage getRegistrationPage() {
	registerpage=new RegistrationPage(driver);
	return registerpage;
}
public landingpageobjects getLandingpageobjects() {
	landingpage=new landingpageobjects(driver);
	return landingpage;
}
public Signinpageobjects getSigninpageobjects() {
	signinpage=new Signinpageobjects(driver);
	return signinpage;
}public DataStructPage getDataStructPage() {
	datastructpage=new DataStructPage(driver);
	return datastructpage;
}public ArraysDocPageObjects getArrayDocPage() {
	arraysdocpage=new ArraysDocPageObjects(driver);
	return arraysdocpage;
}public StackPageobjects getStackpageobjects() {
	stackpageobject=new StackPageobjects(driver);
	return stackpageobject;
}
public LinkedListPageObjects getLinkedPageObject() {
	linkedPage = new LinkedListPageObjects(driver);
	return linkedPage;
}

public QueuesPageObjects getQueuesPageObject() {
	queuesPageObject = new QueuesPageObjects(driver);
	return queuesPageObject;
}

public GraphsPageObjects getGraphsPageObjects() {
	graphsPageObjects = new GraphsPageObjects(driver);
	return graphsPageObjects;

}	
public TreesPageObjects getTreesPageObjects() {
	treesPageObjects = new TreesPageObjects(driver);
	return treesPageObjects;
}
}
