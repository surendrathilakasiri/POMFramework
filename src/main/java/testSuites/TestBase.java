package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.IOUtils.PropertyHandler;

public class TestBase {
	public WebDriver driver;
	private String browser;

	@BeforeTest
	public void setup() throws Exception {
		System.out.println("Test Case is Started");
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
	}

	@AfterMethod
	public void closetab() {
		driver.close();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	@AfterTest
	public void teardown() {
		System.out.println("Test Case is Completed");
		driver.quit();

	}
}
