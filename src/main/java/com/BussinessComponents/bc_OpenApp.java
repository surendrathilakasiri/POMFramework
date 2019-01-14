/**
 * 
 */
package com.BussinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * @author Surendra T This component is used to launch the provided OKTA app
 */
public class bc_OpenApp {

	private static By app = By.xpath("//*[@alt=\"Graphic Link Bridge - QA2\"]");


	public static void openApp(WebDriver driver,String appName, ExtentTest test) throws Exception {
		if (appName.compareToIgnoreCase("Bridge-QA2") == 0) {
			driver.findElement(app).click();
			// WebDriverWait wait=new WebDriverWait(driver,10);
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@alt='bridge
			// logo text image']")));
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
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Bridge :: Home", " Bridge Home Page is Loaded");
			test.log(Status.PASS, "Bridge Home Page is Loaded ");
		} else {
			System.out.println("App is NOT Found...");
		}
	}

}
