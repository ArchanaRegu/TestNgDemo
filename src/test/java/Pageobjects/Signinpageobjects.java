package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signinpageobjects {
	@FindBy(linkText="Register")WebElement register_link;
	@FindBy(linkText="Sign in")WebElement signin;
	@FindBy(linkText="Data Structures")WebElement datastructure;
	@FindBy(css="div.dropdown-menu")WebElement dropdownlist;
	private By elements=By.cssSelector("a");
//	@FindBy(css="a")WebElement elements;
//	@FindBy(css="div.dropdown-menu")List<WebElements>elements;
	@FindBy(css="#id_username")WebElement username;
	@FindBy(css="#id_password")WebElement password;
	@FindBy(xpath="//input[@value='Login']")WebElement login_btn;
	@FindBy(xpath="//div[@role='alert']")WebElement alert_message;
	WebDriver driver;
	public Signinpageobjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean regis_sign(){
		return register_link.isDisplayed() && signin.isDisplayed();
	}public List<String> datastructure() {
		datastructure.click();
		List<String>ListData=new ArrayList<>();
		List<WebElement>listitems=dropdownlist.findElements(elements);
		for(WebElement datastructure:listitems) {
			String text=datastructure.getText();
			ListData.add(text);
		}
		return ListData;
		
	}
	
	public void click_signin_link() {
		signin.click();
		
	}
	
	public void enter_username(String username2, String password2) {
		username.sendKeys(username2);
		password.sendKeys(password2);

	}
	
	public void click_login_btn() {
		login_btn.click();
		
		}
	
	public WebElement logged_in() {
		return alert_message;
	}
	


}
