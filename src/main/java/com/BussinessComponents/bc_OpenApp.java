/**
 * 
 */
package com.BussinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Surendra T This component is used to launch the provided OKTA app
 */
public class bc_OpenApp {

	private WebDriver driver;
	private By app = By.xpath("//*[@alt=\"Graphic Link Bridge - QA2\"]");
	private By logo = By.xpath("//*[@alt=\"bridge logo text image\"]");

	public bc_OpenApp(WebDriver driver) {
		this.driver = driver;
	}

	public void openApp(String appName) throws Exception {
		if (appName.compareToIgnoreCase("Bridge-QA2") == 0) {
			driver.findElement(app).click();
			//WebDriverWait wait=new WebDriverWait(driver,10);
			//wait.wait();
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
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Bridge :: Home", " Bridge Home Page is Loaded");
		} else {
			System.out.println("App is NOT Found...");
		}
	}

}
