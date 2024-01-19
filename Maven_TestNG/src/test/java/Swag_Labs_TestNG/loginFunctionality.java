package Swag_Labs_TestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginFunctionality {
   WebDriver driver;

   @DataProvider(name = "loginValues")
   public Object[][] loginValues() {
       Object[][] testdata=new Object[][]{
               {"standard_user", "secret_sauce"},
               {"problem_user", "secret_sauce"},
               {"performance_glitch_user", "secret_sauce"},
               {"error_user", "secret_sauce"},
               {"visual_user", "secret_sauce"},
               {"locked_out_user","secret_sauce"},
               {"smart_user", "secret_sauce"},
               {"standard_user ", "secret_passwd"},
               {" ", " "}
             };
              return testdata;
   }


	@Test(dataProvider = "loginValues")
	public void login(String username,String password) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		Thread.sleep(3000);


		System.out.println(username+"  "+password);
		try {

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(1000);
		java.util.Set<String> s=driver.getWindowHandles();
		for (String window : s)
		{
		driver.switchTo().window(window);
		}
		if(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed())
		{
			System.out.println("Valid Credentials");
			driver.quit();

		}
		else
		{
			Alert a1=driver.switchTo().alert();
			a1.accept();
		}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Credentials");
			driver.quit();
		}
	}


}



