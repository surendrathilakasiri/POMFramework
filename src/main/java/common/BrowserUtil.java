package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrowserUtil {
	public WebDriver driver;

	public BrowserUtil(WebDriver driver) {
		this.driver = driver;
	}

	// Open URL
	public WebDriver openURL(String URL, String browser) {

		int browserid = browser.compareToIgnoreCase("chrome");

		if (browserid == 0) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_win.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else {
			System.out.println("Invalid Browser");
			System.exit(0);
		}
		return driver;
	}

	// without objects
	public void openURL1(String URL) {

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// Login to OKTA
	public void LoginOKTA(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals(title1, "AE Networks - Preview - Sign In");
		driver.findElement(By.xpath("//*[@class='logo']")).click();

	}

}
