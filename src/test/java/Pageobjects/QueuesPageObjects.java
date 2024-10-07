
package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class QueuesPageObjects {

	private By queueStart = By.xpath("//a[@href =\"queue\" and text() = \"Get Started\"]");
	private By heading = By.xpath("//h4[text() =\"Queue\"]");	
	private By topics = By.xpath("//p[text() ='Topics Covered']");
	private By impQueue = By.linkText("Implementation of Queue in Python");
	private By impCollections = By.linkText("Implementation using collections.deque");
	private By impArrays = By.linkText("Implementation using array");
	private By queueOps = By.linkText("Queue Operations");
	private By tryHereBtn = By.xpath("//a[text() = \"Try here>>>\"]");
	private By queuesTopics = By.cssSelector(".list-group-item");
	
	WebDriver driver;
	
	public QueuesPageObjects(WebDriver driver){
		this.driver = driver;
	}
	public String get_Title() {
		return driver.getTitle();
	}
	public void click_Tryhere_btn() {
		driver.findElement(tryHereBtn).click();
	}
	public void scroll_topicscovered() {
		Actions action = new Actions(driver);
		WebElement list = driver.findElement(topics); 
		action.moveToElement(list);
	}
	
	public void click_queuesGetStarted() {
		driver.findElement(queueStart).click();
		System.out.println("Title of the page is: " +driver.getTitle());
	}
	
	public boolean displayHeading() {
		WebElement displayedHeading = driver.findElement(heading);
		return(displayedHeading.isDisplayed());
		
	}
	
	public List<String> topicsDisplayed() {
		List<String> QueuesNames = new ArrayList<String>();
		List<WebElement> queues_topics = driver.findElements(queuesTopics);
		for(WebElement queue_name : queues_topics ) {
			String ArrayName = queue_name.getText();
			QueuesNames.add(ArrayName);			
		}
		
		return QueuesNames;
		
	}
	
	public void user_clicks(String string) {
		driver.findElement(By.linkText(string)).click();
	}
}
