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
	private By mainMenu = By.xpath("//*[@id='sales-ops']");
	private By subMenu = By.xpath("//a[contains(text(),'Account Maintenance')]");
	
	public bc_SelectSubMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMenu() {
		driver.findElement(menu).click();
		driver.findElement(mainMenu).click();
		driver.findElement(subMenu).click();
		Assert.assertEquals(driver.getTitle(), "Account Maintenance","Validate Page Load");
	}

}
