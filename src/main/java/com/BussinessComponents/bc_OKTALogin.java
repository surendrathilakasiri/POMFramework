/**
 * 
 */
package com.BussinessComponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	private static By logo = By.xpath("//*[@class='logo']");

	// Login to OKTA
	public static void LoginOKTA(WebDriver driver, String sName, ExtentTest test) throws IOException {

		// ReadExcel readexcel=new ReadExcel();
		ReadExcel.openFile("TestData.xlsx", bc_OKTALogin.class.getSimpleName());
		driver.findElement(userName).sendKeys(ReadExcel.readData(sName, "UserName"));
		driver.findElement(passWord).sendKeys(ReadExcel.readData(sName, "Password"));
		driver.findElement(signIn).click();
		String title1 = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		Assert.assertEquals(title1, "AE Networks - Preview - Sign In");
		Assert.assertNotNull(driver.findElement(logo));
		if (driver.findElement(logo).isDisplayed()) {
			test.log(Status.PASS, "OKTA Home Page is Loaded ");
		} else {
			test.log(Status.FAIL, "OKTA Home Page is NOT Loaded ");
		}

	}

}
