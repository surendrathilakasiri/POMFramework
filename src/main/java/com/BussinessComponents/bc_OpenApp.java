/**
 * 
 */
package com.BussinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * @author Surendra T This component is used to launch the provided OKTA app
 */
public class bc_OpenApp {

	private static By app = By.xpath("//*[@alt=\"Graphic Link Bridge - QA2\"]");
	private static By bridgeLogo = By.xpath("//img[@class='loader-img float-left']");

	public static void openApp(WebDriver driver, String appName, ExtentTest test) throws Exception {
		if (appName.compareToIgnoreCase("Bridge-QA2") == 0) {
			driver.findElement(app).click();
			Thread.sleep(8000);

			System.out.println("Bridge QA2 is Loading...");
			for (String winHandle : driver.getWindowHandles()) { // Gets the new
																	// window
																	// handle
				System.out.println(winHandle);
				driver.switchTo().window(winHandle); // switch focus of
														// WebDriver to the next
														// found window handle

			}
			Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(bridgeLogo));

			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Bridge :: Home", " Bridge Home Page is Loaded");
			if (driver.findElement(bridgeLogo).isDisplayed()) {
				test.log(Status.PASS, "Bridge Home Page is Loaded ");
			} else {
				System.out.println("App is NOT Found...");
			}
		}

	}
}
