package StepDefination;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pageobjects.RegistrationPage;
import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.TestContextSetup;

public class capturescreen {
	TestContextSetup testcontextsetup;
	public RegistrationPage registerpage;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	@BeforeMethod
	public void callingobjects(ITestContext context) throws Exception {
	testcontextsetup=new TestContextSetup();
	landingpage=testcontextsetup.pageobjectmanager.getLandingpageobjects();
	signinpage=testcontextsetup.pageobjectmanager.getSigninpageobjects();
	
	extentTest=extentReports.createTest(context.getName());
	} 
	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		sparkReporter_all.config().setReportName("All Tests report");
		
		ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		sparkReporter_failed.config().setReportName("Failure report");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all, sparkReporter_failed);
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	
	@AfterSuite
	public void generateExtentReports() throws Exception {
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
	}
@AfterMethod
public void captureString(Method m,ITestResult result) throws Exception {
	if(result.getStatus()==ITestResult.FAILURE) {
		String screenshotpath=null;
	    screenshotpath=captureScreenshot(result.getMethod().getMethodName()+".jpg");
	    extentTest.addScreenCaptureFromPath(screenshotpath);
	    extentTest.fail(result.getThrowable());
	    
	}else if(result.getStatus()==ITestResult.SUCCESS) {
		extentTest.pass(m.getName()+" is passed");
	}
	
	
	}

public String captureScreenshot(String filename) throws Exception {
	WebDriver driver=testcontextsetup.testbase.driver;
	TakesScreenshot takescreenshot=(TakesScreenshot)driver;
	File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
	File destFile=new File("./Screenshots/"+filename);
	FileUtils.copyFile(sourcefile, destFile);
	System.out.println("screenshot saved successfully");
	return destFile.getAbsolutePath();
	}

}

