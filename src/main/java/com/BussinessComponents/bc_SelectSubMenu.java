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

	private WebDriver driver;
	private By menu = By.xpath("//*[@id='menu-toggle']");
	private By mainMenu;
	private By subMenu;
	String paget;

	public bc_SelectSubMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMenuIndex(String sName) throws InterruptedException, IOException {
		mainMenu = By.xpath("//*[contains(text(),'" + ReadExcel.readData(sName, "MainMenu") + "')]");
		subMenu = By.xpath("//a[contains(text(),'" + ReadExcel.readData(sName, "SubMenu") + "')]");

		driver.findElement(menu).click();
		System.out.println(mainMenu.toString());
		int index=Integer.parseInt(ReadExcel.readData(sName, "Index"));
		driver.findElements(mainMenu).get(index).click();
		System.out.println(subMenu.toString());
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), ReadExcel.readData(sName, "SubMenu"), " Validate Page Load");
		System.out.println(driver.getTitle() + " page is Loaded..");
	}
	
	
	public void selectMenu(String sName) throws InterruptedException, IOException {
		mainMenu = By.xpath("//*[contains(text(),'" + ReadExcel.readData(sName, "MainMenu") + "')]");	
		subMenu = By.xpath("//a[contains(text(),'" + ReadExcel.readData(sName, "SubMenu") + "')]");

		driver.findElement(menu).click();
		System.out.println(mainMenu.toString());
		driver.findElement(mainMenu).click();
		System.out.println(subMenu.toString());
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), ReadExcel.readData(sName, "MainMenu"), " Validate Page Load");
		System.out.println(driver.getTitle() + " page is Loaded..");
	}

}
