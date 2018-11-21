package testSuites;

import org.testng.annotations.Test;
import com.BussinessComponents.bc_OKTALogin;
import common.BrowserUtil;

public class TS_SmokeTest extends TestBase {
	// public WebDriver driver;
	private String username = new String("Loadt01");
	private String password = new String("Global01");
	private String URL = new String("https://aenetworks.oktapreview.com/login/default");

	@Test
	public void tc_LoginTest() {
		// Open the browser with provided URL
		BrowserUtil browser = new BrowserUtil(driver);
		browser.openURL(URL);

		// Sign Into OKTA Home Page
		bc_OKTALogin oKTALogin = new bc_OKTALogin(driver);
		oKTALogin.LoginOKTA(username, password);
		System.out.println("Test 1");
	}

}
