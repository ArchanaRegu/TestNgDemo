package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StackPageobjects {
private By stack_pane=By.xpath("//a[@href='stack' and text()='Get Started']");
private By topic_cover=By.xpath("//p[text()='Topics Covered']");
private By all_topics=By.xpath("//a[@class='list-group-item']");
private By oper_stack=By.linkText("Operations in Stack");
private By imple=By.linkText("Implementation");
private By appl_stack=By.linkText("Applications");
WebDriver driver;
public StackPageobjects(WebDriver driver) {
	this.driver=driver;
}
public String get_title() {
	
	return driver.getTitle();
}
public void scroll_topicscovered() {
	Actions action = new Actions(driver);
	WebElement list = driver.findElement(topic_cover); 
	action.moveToElement(list);
}
public void click_stack_pane() {
	driver.findElement(stack_pane).click();
	
}
public boolean display_topic_cover() {
	WebElement topics=driver.findElement(topic_cover);
	return topics.isDisplayed();
}
public List<String> alltopics() {
	List<String>all_topics_text=new ArrayList<>();
	List<WebElement>all_topics_stack=driver.findElements(all_topics);
	for(WebElement topics:all_topics_stack) {
		String topic=topics.getText();
		all_topics_text.add(topic);
			}
	return all_topics_text;
}
}
