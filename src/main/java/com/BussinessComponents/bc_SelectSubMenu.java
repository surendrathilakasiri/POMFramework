package com.BussinessComponents;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.IOUtils.ReadExcel;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * @author Surendra T This component is used to select a sub menu item.
 */
public class bc_SelectSubMenu {

	private static By menu = By.xpath("//*[@id='menu-toggle']");
	private static By mainMenu;
	private static By subMenu;

	public static void selectMenuIndex(WebDriver driver, String sName, ExtentTest test)
			throws InterruptedException, IOException {
		ReadExcel.openFile("TestData.xlsx", bc_SelectSubMenu.class.getSimpleName());
		mainMenu = By.xpath("//*[contains(text(),'" + ReadExcel.readData(sName, "MainMenu") + "')]");
		subMenu = By.xpath("//a[contains(text(),'" + ReadExcel.readData(sName, "SubMenu") + "')]");
		driver.findElement(menu).click();
		int index = Integer.parseInt(ReadExcel.readData(sName, "Index"));
		driver.findElements(mainMenu).get(index).click();
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), ReadExcel.readData(sName, "SubMenu"), " Validate Page Load");
		if (driver.getTitle().equalsIgnoreCase(ReadExcel.readData(sName, "SubMenu"))) {
			test.log(Status.PASS, driver.getTitle() + "  Page Loaded");
		} else {
			test.log(Status.FAIL, driver.getTitle() + "  Page NOT Loaded");
		}
		System.out.println(driver.getTitle() + " page is Loaded..");
	}

	public static void selectMenu(WebDriver driver, String sName, ExtentTest test)
			throws InterruptedException, IOException {
		ReadExcel.openFile("TestData.xlsx", bc_SelectSubMenu.class.getSimpleName());
		mainMenu = By.xpath("//*[contains(text(),'" + ReadExcel.readData(sName, "MainMenu") + "')]");
		subMenu = By.xpath("//a[contains(text(),'" + ReadExcel.readData(sName, "SubMenu") + "')]");
		driver.findElement(menu).click();
		driver.findElement(mainMenu).click();
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), ReadExcel.readData(sName, "SubMenu"), " Validate Page Load");
		if (driver.getTitle().equalsIgnoreCase(ReadExcel.readData(sName, "SubMenu"))) {
			test.log(Status.PASS, driver.getTitle() + "  Page Loaded");
		} else {
			test.log(Status.FAIL, driver.getTitle() + "  Page NOT Loaded");
		}
		System.out.println(driver.getTitle() + " page is Loaded..");
	}

}
