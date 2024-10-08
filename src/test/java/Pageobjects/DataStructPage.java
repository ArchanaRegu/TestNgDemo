package Pageobjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DataStructPage {
private By DS_GeTS_link=By.xpath("//h5[text()='Data Structures-Introduction']/../..//a[text()='Get Started']");
private By page=By.xpath("//h4[text()='Data Structures-Introduction']");
private By Topic_cover=By.xpath("//p[text()='Topics Covered']");
private By timecomplex=By.linkText("Time Complexity");
private By tryhere=By.linkText("Try here>>>");
private By input=By.cssSelector("pre.CodeMirror-line");
private By Runbtn=By.xpath("//button[@onclick='runit()']");
private By output=By.cssSelector("pre#output");
public WebDriver driver;
public 	DataStructPage(WebDriver driver) {
	this.driver=driver;
}
public String get_Title() {
	return driver.getTitle();
}
public void click_DSgetstart() {
	driver.findElement(DS_GeTS_link).click();
	System.out.println("Title of new page "+driver.getTitle());
	
}
public boolean topic_displayed() {
	WebElement DS_page=driver.findElement(page);
	WebElement Topic=driver.findElement(Topic_cover);
	return DS_page.isDisplayed() && Topic.isDisplayed();
}public void click_timecomplex() {
	driver.findElement(timecomplex).click();
	System.out.println("Title of new page:"+ driver.getTitle());
}
public void click_tryhere() {
	driver.findElement(tryhere).click();
	System.out.println("Title of new page: "+driver.getTitle());
}
public void enter_valideditor(String validcode) {
	WebElement editor_page=driver.findElement(input);
	
    new Actions(driver).sendKeys(editor_page,validcode).perform();
		}
public void enter_Invalideditor(String Invalidecode) {
	WebElement editor_page=driver.findElement(input);
    new Actions(driver).sendKeys(editor_page,Invalidecode).perform();
	}
public String Output() {
	driver.findElement(Runbtn).click();
	String outputActualResult=null;
	try {
		WebElement output_result=driver.findElement(output);
		outputActualResult=output_result.getText();
	} catch (Exception e) {
		outputActualResult=e.getMessage();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e2) {
			System.out.println(e2.getStackTrace());
		}
		
}
	//System.out.println(outputActualResult);
	return outputActualResult;
}
}

