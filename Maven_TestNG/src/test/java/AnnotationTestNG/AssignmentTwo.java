package AnnotationTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwo {
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
	
	@DataProvider(name = "loginValues")
    public Object[][] loginValues() {
        return new Object[][]{
                {"shalini@yahoo.com", "admin123"},
                {"shikha@gmail.com", "passShikha123"},
                {" ", "password"},
               	        };
    }
 
	
	@Test(dataProvider = "loginValues")
	public void login(String username,String password) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}
	@AfterSuite 
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
