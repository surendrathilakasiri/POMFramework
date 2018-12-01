package common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.IOUtils.ReadExcel;

public class BrowserUtil {
	public WebDriver driver;

	public BrowserUtil(WebDriver driver) {
		this.driver = driver;
	}

	// without objects
	public void openURL(String sName) throws IOException {
		//ReadExcel readexcel=new ReadExcel();
		ReadExcel.openFile("TestData.xlsx",getClass().getSimpleName() );
		String sURL=ReadExcel.readData(sName, "UserName");
	    driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
