package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpageobjects {
private By h1tag_launchpage=By.cssSelector("h1");
private By ptag_launchpage=By.cssSelector("p");
private By getStarted=By.linkText("Get Started");
private By drop_dn_btn=By.xpath("//a[@data-toggle='dropdown']");
private By drop_down=By.cssSelector(".dropdown-menu");
private By drop_downmenu=By.cssSelector(".dropdown-menu a.dropdown-item");
private By listelements=By.tagName("a");
WebDriver driver;
public landingpageobjects(WebDriver driver) {
	this.driver=driver;
}
public String get_Title() {
	return driver.getTitle();
}
public List<String> dropdownmenu() {
	driver.findElement(drop_dn_btn).click();
	List<String>listnames=new ArrayList<>();
	List<WebElement>dropdownlist=driver.findElements(drop_downmenu);
	for(WebElement element:dropdownlist) {
		String ele=element.getText();
		listnames.add(ele);
	}
	return listnames;
}
public boolean h1_ptag_getstarted() {
	WebElement h1=driver.findElement(h1tag_launchpage);
	System.out.println(h1.getText());
	WebElement ptag=driver.findElement(ptag_launchpage);
	WebElement getstarted_btn=driver.findElement(getStarted);
	return h1.isDisplayed() && ptag.isDisplayed() && getstarted_btn.isDisplayed();
}
public boolean h1_display() {
	WebElement h1tag=driver.findElement(h1tag_launchpage);
	System.out.println(h1tag.getText());
	return h1tag.isDisplayed();
}public boolean p_diaplay() {
	WebElement ptag=driver.findElement(ptag_launchpage);
	System.out.println(ptag.getText());
	return ptag.isDisplayed();
}public boolean getstarteddp() {
	WebElement getstarted_link=driver.findElement(getStarted);
	return getstarted_link.isDisplayed();
}public void click_getstartbtn() {
	driver.findElement(getStarted).click();
}

}
