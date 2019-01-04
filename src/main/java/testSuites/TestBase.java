package testSuites;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.IOUtils.PropertyHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//@Listeners(ReportLister.class)
public class TestBase implements ITestListener{
	public WebDriver driver;
	private String browser;
	public static ExtentReports extent;
	public static ExtentTest test;


	@BeforeTest
	public void setup() throws Exception {
		PropertyHandler properties = new PropertyHandler("runtime.properties");
		browser = properties.getRuntimeProperty("BROWSER");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_win.exe");
			System.out.println("Statring Test with " + browser + " Browser");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid Browser");
			System.exit(0);
		}
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\test-output\\AutomationResults.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.out.println("1********+++++++++++**********");

	}

	@AfterMethod
	public void cleanup(ITestResult result) throws IOException {
/*
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "\\test-output\\Error.png"));
			test.fail("Error Screen Print : ", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\test-output\\Error.png").build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is " + result.getName());
		}
		// HTML report
		extent.flush();*/
		driver.close();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	@AfterTest
	public void teardown() {
		System.out.println("Test Case is Completed");
		driver.quit();
		extent.flush();
	}

	//@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() );
		//test.log(Status.INFO, "Test Case Started " + result.getName());
	}

	//@Override
	public void onTestSuccess(ITestResult result) {
		
		//if (result.getStatus() == ITestResult.SUCCESS) {
		//	test.log(Status.PASS, "Test Case Passed is " + result.getName());
		//}
		test.log(Status.PASS, "Test Case Passed is " + result.getName());
		System.out.println("Test Case Passed is " + result.getStatus());
				 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "\\test-output\\Error.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			test.fail("Error Screen Print : ", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\test-output\\Error.png").build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("2********+++++++++++**********");
		context.setAttribute("WebDriver", this.driver);
		System.out.println("I am in onStart method " + context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//extent.flush();
		
	}
}
