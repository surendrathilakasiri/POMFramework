package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class BrowserUtil2 {
	WebDriver driver;
	
	public BrowserUtil2(WebDriver driver)
	{
		this.driver =driver;
	}
		
	// Login to OKTA
	public void LoginOKTA(String username, String password)
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals(title1, "AE Networks - Preview - Sign In");
		driver.findElement(By.xpath("//*[@class='logo']")).click();

	}
	
	
}
