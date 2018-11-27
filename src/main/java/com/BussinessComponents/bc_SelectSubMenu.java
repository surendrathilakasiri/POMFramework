package com.BussinessComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

	public void selectMenu(String mMenu, String sMenu) {
		mainMenu = By.xpath("//*[contains(text(),'" + mMenu.toString() + "')]");
		System.out.println(mainMenu.toString());
		subMenu = By.xpath("//a[contains(text(),'" + sMenu.toString() + "')]");

		driver.findElement(menu).click();
		driver.findElement(mainMenu).click();
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), "Account Maintenance", "Validate Page Load");
		System.out.println(driver.getTitle() + " page is Loaded..");
	}

}
