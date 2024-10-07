package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage {
private By Register_link=By.linkText("Register");
private By username=By.cssSelector("#id_username");
private By password=By.cssSelector("#id_password1");
private By confirmpassword=By.cssSelector("#id_password2");
private By registerbtn=By.xpath("//input[@type='submit' and @value='Register']");
private By alert=By.xpath("//div[@role='alert']");
WebDriver driver;
public RegistrationPage(WebDriver driver) {
	this.driver=driver;
}
public void click_Register() {
driver.findElement(Register_link).click();
}
public String get_title() {
	
	return driver.getTitle();
}
public void enter_username(String uname) {
	WebElement usern=driver.findElement(username);
	new Actions(driver).sendKeys(usern, uname).perform();
	//usern.sendKeys(uname);
}
public void enter_password(String pword) {
	WebElement pname=driver.findElement(password);
	pname.sendKeys(pword);
}
public void enter_confirmpassword(String cpwd) {
	WebElement confpwd=driver.findElement(confirmpassword);
	confpwd.sendKeys(cpwd);
}
public void click_register_button() {
	driver.findElement(registerbtn).click();
}
public void alert_message() {
	WebElement alertmessage=driver.findElement(alert);
	System.out.println(alertmessage.getText());
}
}
