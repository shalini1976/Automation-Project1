package Swag_Labs_TestNG;

import org.openqa.selenium.WebDriver;

public class closeBrowserPOM {
WebDriver driver;

	public closeBrowserPOM(WebDriver ldriver)
	{
		driver=ldriver;
	}
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("Swag Labs web site checked, going to quit");
		Thread.sleep(3000);
		driver.quit();
	}

}
