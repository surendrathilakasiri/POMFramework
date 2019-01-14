package testSuites;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.BussinessComponents.*;
import com.aventstack.extentreports.Status;

import common.BrowserUtil;
@Listeners(TestBase.class)
public class TS_SmokeTest extends TestBase {
	private String appName = "Bridge-QA2";

	@BeforeTest
	public void Navigate() throws IOException {
		driver.navigate().refresh();
	}

	@Test (priority=1)
	public void tc_LoginTest() throws Exception {
		//Create Test Case
		test = extent.createTest(" Test " + Thread.currentThread().getStackTrace()[1].getMethodName());
		// Open the browser with provided URL
		BrowserUtil.openURL(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin.LoginOKTA(driver, Thread.currentThread().getStackTrace()[1].getMethodName(),test);

		// Launch Bridge QA1 app
		bc_OpenApp.openApp(driver, appName,test);
		//System.exit(0);
	}

	@Test (priority=2)
	public void tc_AccountMaintenance() throws Exception {
		//Create Test Case
		test = extent.createTest(" Test " + Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(Status.PASS,"Test111");
		// Open the browser with provided URL
		BrowserUtil.openURL(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin.LoginOKTA(driver, Thread.currentThread().getStackTrace()[1].getMethodName(),test);

		// Launch Bridge QA1 app
		bc_OpenApp.openApp(driver, appName,test);

		// Select a sub Menu
		bc_SelectSubMenu.selectMenu(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.fail();


	}

	@Test (priority=3)
	public void tc_SalesProjections() throws Exception {
		
		//Create Test Case
		test = extent.createTest(" Test " + Thread.currentThread().getStackTrace()[1].getMethodName());
		// Open the browser with provided URL
		BrowserUtil.openURL(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin.LoginOKTA(driver, Thread.currentThread().getStackTrace()[1].getMethodName(),test);

		// Launch Bridge QA1 app
		bc_OpenApp.openApp(driver, appName,test);

		// Select a sub Menu
		bc_SelectSubMenu.selectMenuIndex(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

	}

}
