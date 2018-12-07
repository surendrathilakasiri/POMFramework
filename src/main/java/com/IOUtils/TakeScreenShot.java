/**
 * 
 */
package com.IOUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author QAAUTOTEST
 *
 */
public class TakeScreenShot {

	public static void takeScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile
			// //method
			FileUtils.copyFile(src, new File("C:/temp/error.png"));
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}

	}
}
