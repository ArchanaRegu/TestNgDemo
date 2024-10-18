package Listenerspackage;


import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utils.TestContextSetup;
import StepDefination.Parent;
import io.qameta.allure.Allure;

public class ITestListenersclass extends Parent implements ITestListener {
 TestContextSetup testcontextsetup;
	@Override
	public void onTestFailure(ITestResult result) {
		try	{
			WebDriver driver=testcontextsetup.testbase.WebDriverManager();
			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Screenshot",new ByteArrayInputStream(screenshot));
	} catch (Exception e) {
		e.getMessage();
		}}
	

//	private static String getTestMethodName(ITestResult iTestResult) {
//		return iTestResult.getMethod().getConstructorOrMethod().getName();
//	}
//	//Text attachment for failure
//	@Attachment(value="Page Screenshot",type="img/png")
//	public byte[] saveFailureScreenShot(WebDriver driver) {
//		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//	}
//	@Override
//	public void bhbj(TestResult result) {
//		
//		
//		
}