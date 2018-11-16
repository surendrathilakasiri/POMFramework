package testSuites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import common.BrowserUtil;
import common.BrowserUtil2;

public class TS_SmokeTest extends TestBase {
//public WebDriver driver;
	
	@Test
	public void tc_LoginTest() {
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL1("https://aenetworks.oktapreview.com/login/default");
		//driver.get("https://www.google.com");
		//BrowserUtil2 browser2 = new BrowserUtil2(driver);
		//browser2.LoginOKTA("loadt01", "Global01");
		System.out.println("Test 1");
	}

}
