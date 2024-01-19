package AnnotationTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignmentOne {
	WebDriver driver;
	@BeforeSuite
	public void LaunchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/login.html");
		Thread.sleep(3000);
		}
	
	@Test
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shalini@yahoo.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("admin123");
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}
	@AfterSuite 
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
