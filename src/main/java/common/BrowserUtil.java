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

	// without objects
	public void openURL(String URL) {

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}



}
