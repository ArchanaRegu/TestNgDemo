package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedListPageObjects {

	private By linkGetBtn = By.xpath("//a[@href =\"linked-list\" and text()='Get Started']");
	private By heading = By.xpath("//h4[text()=\"Linked List\"]");
	private By topicsCoveredBtn = By.xpath("//p[text() =\"Topics Covered\"]");
	private By introLink = By.linkText("Introduction");
	private By createLink = By.linkText("Creating Linked LIst");
	private By typesLink = By.linkText("Types of Linked List");
	private By impPythonLink = By.linkText("Implement Linked List in Python");
	private By traversalLink = By.linkText("Traversal");
	private By insertionLink = By.linkText("Insertion");
	private By deletionLink = By.linkText("Deletion");
	private By tryHereBtn = By.xpath("//a[text() = \"Try here>>>\"]");
	private By listTopics = By.cssSelector(".list-group-item");
	WebDriver driver;

	public LinkedListPageObjects(WebDriver driver) {

		this.driver = driver;
	}
	public String get_Title() {
		return driver.getTitle();
	}

	public void click_LinkedgetButton() {
		driver.findElement(linkGetBtn).click();
		System.out.println("Title of new page " + driver.getTitle());

	}

	public boolean displayHeading() {
		WebElement linkedHeading = driver.findElement(heading);
		return linkedHeading.isDisplayed();
	}

	public List<String> topics_displayed() {
		List<String> LinkedListNames = new ArrayList<>();
		List<WebElement> list_Topics = driver.findElements(listTopics);
		for (WebElement List_name : list_Topics) {
			String arrayName = List_name.getText();
			LinkedListNames.add(arrayName);
		}
		return LinkedListNames;

	}

	public void user_clicks(String string) {
		driver.findElement(By.linkText(string)).click();
	}

}