package Swag_Labs_TestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkLoginPOM {
	WebDriver driver;

	//Method to validate user names and passwords
	//Test Cases from TS_01 are automated


	public checkLoginPOM(WebDriver ldriver)
	{
		driver=ldriver;
	}

	public void url() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com");
		Thread.sleep(3000);
	}

	public void checkLogin()
	{
	String []user= {"standard_user","problem_user","performance_glitch_user","error_user","visual_user","locked_out_user","smart_user","standard_user"," "};
    String []passwd= {"secret_sauce","secret_sauce","secret_sauce","secret_sauce","secret_sauce","secret_sauce","secret_sauce","secret_passwd"," "};

    String []accepted_user= {"standard_user","problem_user","performance_glitch_user","error_user","visual_user","locked_out_user"};

    for(int i=0;i<9;i++)
    {

	System.out.println(user[i]+"  "+passwd[i]);
	try {
		driver.findElement(By.xpath("//input[@id='user-name']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user[i]);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user-name']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passwd[i]);
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
			System.out.println("Valid Credentials\nPassed");
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
			Thread.sleep(2000);
			//Logout
			driver.findElement(By.xpath("//div[@id='menu_button_container']/child::div/child::div[@class='bm-menu-wrap']/child::div/child::nav/child::a[3]")).click();
		}
		else
		{
			Alert a1=driver.switchTo().alert();
			a1.accept();
			
		}
	}
	catch(Exception e)
	{
		
			//System.out.println("inside Catch");	
			if(i<6)
			{
				if(user[i].equals(accepted_user[i]))
				{
					//System.out.println("inside if");
					if(passwd[i].equals("secret_sauce"))  
						{
						System.out.println("Valid Credentials, Cannot login\nTest Case Failed!");
						}
				}
			}
			else
			{
				System.out.println("Invalid credentials, Cannot login\nTest Case Passed");
			}
		
		}

	}
   
}
}

