package TestClasses;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Pageobjects.ArraysDocPageObjects;
import Pageobjects.DataStructPage;
import Pageobjects.GraphsPageObjects;
import Pageobjects.LinkedListPageObjects;
import Pageobjects.QueuesPageObjects;
import Pageobjects.Signinpageobjects;
import Pageobjects.StackPageobjects;
import Pageobjects.TreesPageObjects;
import Pageobjects.landingpageobjects;
import Utils.ExcelDataprovider;
import Utils.TestContextSetup;
import io.qameta.allure.Allure;
public class Parent {
	TestContextSetup testcontextsetup;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	DataStructPage datastructpage;
	ExcelDataprovider excelnew;
	ArraysDocPageObjects arraysdocpage;
	GraphsPageObjects graphsPageObjects;
	QueuesPageObjects queuesPageObjects;
	LinkedListPageObjects linkedPageObject;
	StackPageobjects stackPageObjects;
	TreesPageObjects treePageObjects;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	@BeforeMethod
	public void callingobjects(ITestContext context) throws Exception{
		testcontextsetup = new TestContextSetup(); // browser initiation
		landingpage = testcontextsetup.pageobjectmanager.getLandingpageobjects(); // object creation for page objects
		signinpage = testcontextsetup.pageobjectmanager.getSigninpageobjects();
		datastructpage = testcontextsetup.pageobjectmanager.getDataStructPage();
		arraysdocpage = testcontextsetup.pageobjectmanager.getArrayDocPage();
		graphsPageObjects = testcontextsetup.pageobjectmanager.getGraphsPageObjects();
		queuesPageObjects = testcontextsetup.pageobjectmanager.getQueuesPageObject();
		linkedPageObject = testcontextsetup.pageobjectmanager.getLinkedPageObject();
		stackPageObjects = testcontextsetup.pageobjectmanager.getStackpageobjects();
		treePageObjects = testcontextsetup.pageobjectmanager.getTreesPageObjects();
		excelnew = new ExcelDataprovider(); // test data
		Assert.assertTrue(landingpage.h1_ptag_getstarted());
		landingpage.click_getstartbtn();
		//assertion for sign in link and register link is displayed
		Assert.assertTrue(signinpage.regis_sign());		
		signinpage.click_signin_link();
		String username=excelnew.getData(1,0);
		String password=excelnew.getData(1,1);
		signinpage.enter_username(username, password);
		System.out.println(username+" is username and password is "+password);
		signinpage.click_login_btn();
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
	    byte[] screenshot=((TakesScreenshot)testcontextsetup.testbase.WebDriverManager()).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Failed Screenshot",new ByteArrayInputStream(screenshot));
	    
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
