package testSuites;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.BussinessComponents.*;
import common.BrowserUtil;

public class TS_SmokeTest extends TestBase {
	private String appName = "Bridge-QA2";

	@BeforeTest
	public void Navigate() throws IOException {
		driver.navigate().refresh();
	}

	@Test
	public void tc_LoginTest() throws Exception {
		// Open the browser with provided URL
		BrowserUtil.openURL(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin.LoginOKTA(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Launch Bridge QA1 app
		bc_OpenApp.openApp(driver, appName);
	}

	@Test
	public void tc_AccountMaintenance() throws Exception {

		// Open the browser with provided URL
		BrowserUtil.openURL(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin.LoginOKTA(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Launch Bridge QA1 app
		bc_OpenApp.openApp(driver, appName);

		// Select a sub Menu
		bc_SelectSubMenu.selectMenu(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	@Test
	public void tc_SalesProjections() throws Exception {
		// Open the browser with provided URL
		BrowserUtil.openURL(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin.LoginOKTA(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		// Launch Bridge QA1 app
		bc_OpenApp.openApp(driver, appName);

		// Select a sub Menu
		bc_SelectSubMenu.selectMenuIndex(driver, Thread.currentThread().getStackTrace()[1].getMethodName());

	}

}
