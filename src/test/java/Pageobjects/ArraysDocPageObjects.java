package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ArraysDocPageObjects {
public WebDriver driver;
private By Array_getstart=By.xpath("//a[@href='array' and text()='Get Started']");
//private By Array_doc=By.xpath("Array");
private By array_list=By.cssSelector("ul a.list-group-item");
private By topics_cov=By.xpath("//p[text()='Topics Covered']");
private By Arrays_in_python=By.linkText("Arrays in Python");
private By Arrays_Use_List=By.linkText("Arrays Using List");
private By BasicOperations_Lists=By.linkText("Basic Operations in Lists");
private By ApplicationsOfArray=By.linkText("Applications of Array");
private By tryhere=By.linkText("Try here>>>");
public ArraysDocPageObjects(WebDriver driver) {
	this.driver=driver;
	
}
public void scroll_topicscovered() {
	Actions action = new Actions(driver);
	WebElement list = driver.findElement(topics_cov); 
	action.moveToElement(list);
}
public void click_getstarted() {
	driver.findElement(Array_getstart).click();
}
public boolean topic_display() {
	WebElement topic_covered=driver.findElement(topics_cov);
	return topic_covered.isDisplayed(); 
}
public List<String> List_arraysTopics() {
	List<String>ArrayNames=new ArrayList<>();
	List<WebElement> topics_arrays=driver.findElements(array_list);
	for(WebElement Array_name:topics_arrays) {
		String arrayName=Array_name.getText();
		ArrayNames.add(arrayName);
	}
	return ArrayNames;
}
public void clickPaneListLinks(String string) {
	driver.findElement(By.linkText(string)).click();
	
}public void click_Tryhere_btn() {
	driver.findElement(tryhere).click();
}



}
