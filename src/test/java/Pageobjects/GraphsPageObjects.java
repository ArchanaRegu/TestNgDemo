package Pageobjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GraphsPageObjects {
	
	private By btnGetStarted = By.xpath("//a[@href = \"graph\" and text() = \"Get Started\"]");
	private By heading = By.xpath("//h4[text()= 'Graph']");
	private By topics = By.xpath("//p[text()= 'Topics Covered']");
	private By graphsLink = By.linkText("Graph");
	private By graphsRepLink = By.linkText("Graph Representations");
	private By btnTryhere = By.xpath("//a[text() = \"Try here>>>\"]");
	private By btnRun = By.xpath("//button[text() = \"Run\"]");
	private By graphTopics = By.cssSelector(".list-group-item");
	
	WebDriver driver;
	
	public GraphsPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void scroll_topicscovered() {
		Actions action = new Actions(driver);
		WebElement list = driver.findElement(topics); 
		action.moveToElement(list);
	}
	
	public void click_graphsGetStarted() {
		
		driver.findElement(btnGetStarted).click();
		System.out.println("Graphs Get started is clicked with title : " + driver.getTitle());		
		
	}
	public String get_Title() {
		return driver.getTitle();
	}
	public void clickGraphsListLinks(String string) {
		driver.findElement(By.linkText(string)).click();
		
	}
	
	public boolean verify_heading() {
		WebElement headingDisplayed = driver.findElement(heading);
		return headingDisplayed.isDisplayed();
	 		
	}
	
	public List<String> graph_topicsDisplayed() {
		List<String> graphTopicNames = new ArrayList<>();
		List<WebElement> graph_Topics = driver.findElements(graphTopics);
		for (WebElement List_name : graph_Topics) {
			String arrayName = List_name.getText();
			graphTopicNames.add(arrayName);
		}
		return graphTopicNames; 
		
	}
}
