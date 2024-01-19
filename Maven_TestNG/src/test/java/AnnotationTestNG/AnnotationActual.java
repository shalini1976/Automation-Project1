package AnnotationTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationActual {
	WebDriver driver;
	@BeforeSuite
	public void LaunchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		String actualTitle=driver.getTitle();
		String expectedTitle ="OrangeHRM";
		/*if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Test Case Passed");
		}
		else
		{	
		System.out.println("Test Case Failed");
		}*/
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void login() throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}
	@Test
	public void pim() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(3000);
	}
	@Test
	public void reports() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Reports']")).click();
		Thread.sleep(3000);
	}
	@Test
	public void sumEmployee() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		Thread.sleep(3000);
	}
	@AfterSuite 
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}

