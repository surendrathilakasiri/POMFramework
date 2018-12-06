package testSuites;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.BussinessComponents.*;
import common.BrowserUtil;

public class TS_SmokeTest extends TestBase {
	// Test Data
	private String username = new String("Loadt01");
	private String password = new String("Global01");
	private String appName = new String("Bridge-QA2");

	@BeforeTest
	public void Navigate() throws IOException{

			driver.navigate().refresh();

	}
	
	@Test
	public void tc_LoginTest() throws Exception {
		
		
		// Open the browser with provided URL
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		// Sign Into OKTA Home Page
		bc_OKTALogin oKTALogin = new bc_OKTALogin(driver);
		oKTALogin.LoginOKTA(Thread.currentThread().getStackTrace()[1].getMethodName());

		// Launch Bridge QA1 app
		bc_OpenApp openApp = new bc_OpenApp(driver);
		openApp.openApp(appName);
	}

	@Test
	public void tc_AccountMaintenance() throws Exception {
		// Open the browser with provided URL
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL(Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin oKTALogin = new bc_OKTALogin(driver);
		oKTALogin.LoginOKTA(Thread.currentThread().getStackTrace()[1].getMethodName());
		//oKTALogin.LoginOKTA(username, password);

		// Launch Bridge QA1 app
		bc_OpenApp openApp = new bc_OpenApp(driver);
		openApp.openApp(appName);

		// Select a sub Menu
		bc_SelectSubMenu selectMenu = new bc_SelectSubMenu(driver);
		selectMenu.selectMenu(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	@Test
	public void tc_SalesProjections() throws Exception {
		// Open the browser with provided URL
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL(Thread.currentThread().getStackTrace()[1].getMethodName());

		// Sign Into OKTA Home Page
		bc_OKTALogin oKTALogin = new bc_OKTALogin(driver);
		oKTALogin.LoginOKTA(Thread.currentThread().getStackTrace()[1].getMethodName());

		// Launch Bridge QA1 app
		bc_OpenApp openApp = new bc_OpenApp(driver);
		openApp.openApp(appName);

		// Select a sub Menu
		bc_SelectSubMenu selectMenu = new bc_SelectSubMenu(driver);
		selectMenu.selectMenuIndex(Thread.currentThread().getStackTrace()[1].getMethodName());

	}
	
}
