package com.BussinessComponents;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.IOUtils.ReadExcel;

/**
 * @author Surendra T This component is used to select a sub menu item.
 */
public class bc_SelectSubMenu {

	private static By menu = By.xpath("//*[@id='menu-toggle']");
	private static By mainMenu;
	private static By subMenu;


	public static void selectMenuIndex(WebDriver driver,String sName) throws InterruptedException, IOException {
		ReadExcel.openFile("TestData.xlsx", bc_SelectSubMenu.class.getSimpleName());
		mainMenu = By.xpath("//*[contains(text(),'" + ReadExcel.readData(sName, "MainMenu") + "')]");
		subMenu = By.xpath("//a[contains(text(),'" + ReadExcel.readData(sName, "SubMenu") + "')]");
		driver.findElement(menu).click();
		int index = Integer.parseInt(ReadExcel.readData(sName, "Index"));
		driver.findElements(mainMenu).get(index).click();
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), ReadExcel.readData(sName, "SubMenu"), " Validate Page Load");
		System.out.println(driver.getTitle() + " page is Loaded..");
	}

	public static void selectMenu(WebDriver driver,String sName) throws InterruptedException, IOException {
		ReadExcel.openFile("TestData.xlsx", bc_SelectSubMenu.class.getSimpleName());
		mainMenu = By.xpath("//*[contains(text(),'" + ReadExcel.readData(sName, "MainMenu") + "')]");
		subMenu = By.xpath("//a[contains(text(),'" + ReadExcel.readData(sName, "SubMenu") + "')]");
		driver.findElement(menu).click();
		driver.findElement(mainMenu).click();
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), ReadExcel.readData(sName, "SubMenu"), " Validate Page Load");
		System.out.println(driver.getTitle() + " page is Loaded..");
	}

}
