package common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.IOUtils.ReadExcel;

public class BrowserUtil {

	// without objects
	public static void openURL(WebDriver driver, String sName) throws IOException {
		// ReadExcel readexcel=new ReadExcel();
		ReadExcel.openFile("TestData.xlsx", BrowserUtil.class.getSimpleName());
		String sURL = ReadExcel.readData(sName, "URL");
		System.out.println(sURL);
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
