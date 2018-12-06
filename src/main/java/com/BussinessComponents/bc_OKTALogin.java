/**
 * 
 */
package com.BussinessComponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.IOUtils.ReadExcel;
import com.thoughtworks.selenium.Wait;

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
	public void LoginOKTA(String sName) throws IOException
	{

		//ReadExcel readexcel=new ReadExcel();
		ReadExcel.openFile("TestData.xlsx",getClass().getSimpleName() );
		
		driver.findElement(userName).sendKeys(ReadExcel.readData(sName, "UserName"));
		driver.findElement(passWord).sendKeys(ReadExcel.readData(sName, "Password"));
		driver.findElement(signIn).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals(title1, "AE Networks - Preview - Sign In");
		Assert.assertNotNull(driver.findElement(By.xpath("//*[@class='logo']")));	

	}

}
