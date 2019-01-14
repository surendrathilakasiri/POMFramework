/**
 * 
 */
package com.BussinessComponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.IOUtils.ReadExcel;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * @author Surendra T This is used to Login to OKTA Home Page
 */
public class bc_OKTALogin {

	private static By userName = By.name("username");
	private static By passWord = By.name("password");
	private static By signIn = By.xpath("//*[@id=\"okta-signin-submit\"]");


	// Login to OKTA
	public static void LoginOKTA(WebDriver driver,String sName, ExtentTest test) throws IOException {

		// ReadExcel readexcel=new ReadExcel();
		ReadExcel.openFile("TestData.xlsx", bc_OKTALogin.class.getSimpleName());
		driver.findElement(userName).sendKeys(ReadExcel.readData(sName, "UserName"));
		driver.findElement(passWord).sendKeys(ReadExcel.readData(sName, "Password"));
		driver.findElement(signIn).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals(title1, "AE Networks - Preview - Sign In");
		Assert.assertNotNull(driver.findElement(By.xpath("//*[@class='logo']")));
		if (driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed())
		{
			test.log(Status.PASS, "Bridge Home Page is Loaded ");
		}
		else
		{
			test.log(Status.FAIL, "Bridge Home Page is NOT Loaded ");
		}
		
		
		

	}

}
