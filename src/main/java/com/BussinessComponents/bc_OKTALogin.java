/**
 * 
 */
package com.BussinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Surendra T
 * THis is used to Login to OKTA Home Page
 */
public class bc_OKTALogin {
	
private WebDriver driver;
private By userName =By.name("username");
private By passWord =By.name("password");
private By signIn =By.xpath("//*[@id=\"okta-signin-submit\"]");
		
	
	public bc_OKTALogin(WebDriver driver)
	{
		this.driver =driver;
	}
		
	// Login to OKTA
	public void LoginOKTA(String username, String password)
	{
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(signIn).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals(title1, "AE Networks - Preview - Sign In");
		driver.findElement(By.xpath("//*[@class='logo']")).click();

	}

}
