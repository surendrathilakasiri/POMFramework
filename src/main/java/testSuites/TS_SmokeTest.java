package testSuites;

import org.testng.annotations.Test;
import com.BussinessComponents.*;
import common.BrowserUtil;

public class TS_SmokeTest extends TestBase {
	// Test Data
	private String username = new String("Loadt01");
	private String password = new String("Global01");
	private String URL = new String("https://aenetworks.oktapreview.com/login/default");
	private String appName=new String("Bridge-QA2");

	@Test
	public void tc_LoginTest() throws Exception {
		// Open the browser with provided URL
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL(URL);

		// Sign Into OKTA Home Page
		bc_OKTALogin oKTALogin = new bc_OKTALogin(driver);
		oKTALogin.LoginOKTA(username, password);
		
		// Launch Bridge QA1 app
		bc_OpenApp openApp=new bc_OpenApp(driver);
		openApp.openApp(appName);
		
	}
	

	@Test
	public void tc_AccountMaintenance() throws Exception {
		// Open the browser with provided URL
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL(URL);

		// Sign Into OKTA Home Page
		bc_OKTALogin oKTALogin = new bc_OKTALogin(driver);
		oKTALogin.LoginOKTA(username, password);
		
		// Launch Bridge QA1 app
		bc_OpenApp openApp=new bc_OpenApp(driver);
		openApp.openApp(appName);
		
		//Select a sub Menu
		bc_SelectSubMenu selectMenu=new bc_SelectSubMenu(driver);
		selectMenu.selectMenu("Sales Operations","Account Maintenance");
		
	}
	
	@Test
	public void tc_SalesProjections() throws Exception {
		// Open the browser with provided URL
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL(URL);

		// Sign Into OKTA Home Page
		bc_OKTALogin oKTALogin = new bc_OKTALogin(driver);
		oKTALogin.LoginOKTA(username, password);
		
		// Launch Bridge QA1 app
		bc_OpenApp openApp=new bc_OpenApp(driver);
		openApp.openApp(appName);
		
		//Select a sub Menu
		bc_SelectSubMenu selectMenu=new bc_SelectSubMenu(driver);
		selectMenu.selectMenu("Sales","Projections");
		
	}
}
