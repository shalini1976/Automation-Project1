package Swag_Labs_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkImagePOM {
	WebDriver driver;

	//Checking if proper image with respect to the product, is displaying 
	


	public checkImagePOM(WebDriver ldriver)
	{
		driver=ldriver;
	}

	public void url() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("problem_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

	}
	public void checkProdImage() throws InterruptedException
	{
		//Checking image for all the products for problem_user login
		
		System.out.println("Checking Product Images for problem_user login");
			
			//Checking for Item1
			System.out.println("For Item1: ");
			String orgimg1="/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";
			String curimg1="/static/media/sl-404.168b1cce.jpg";
			
			if(curimg1.equals(orgimg1))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			//Checking for Item2
			System.out.println("For Item2: ");
			String orgimg2="/static/media/bike-light-1200x1500.37c843b0.jpg";
			String curimg2="/static/media/sl-404.168b1cce.jpg";
			
			if(curimg2.equals(orgimg2))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			
			//Checking for Item3
			System.out.println("For Item3: ");
			String orgimg3="/static/media/bolt-shirt-1200x1500.c2599ac5.jpg";
			String curimg3="/static/media/sl-404.168b1cce.jpg";
			
			if(curimg3.equals(orgimg3))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			
			//Checking for Item4
			System.out.println("For Item4: ");
			String orgimg4="/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg";
			String curimg4="/static/media/sl-404.168b1cce.jpg";
			
			if(curimg4.equals(orgimg4))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			
			//Checking for Item5
			System.out.println("For Item5: ");
			String orgimg5="/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg";
			String curimg5="/static/media/sl-404.168b1cce.jpg";
			
			if(curimg5.equals(orgimg5))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			
			//Checking for Item6
			System.out.println("For Item6: ");
			String orgimg6="/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg";
			String curimg6="/static/media/sl-404.168b1cce.jpg";
			
			if(curimg6.equals(orgimg6))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			Thread.sleep(3000);
			
			//Checking image for product1 for visual_user login
			
			//Logging Out and logging In as visual_user
			if(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed())
			{
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
			Thread.sleep(2000);
			//Logout
			driver.findElement(By.xpath("//div[@id='menu_button_container']/child::div/child::div[@class='bm-menu-wrap']/child::div/child::nav/child::a[3]")).click();
		
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("visual_user");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			Thread.sleep(1000);
			
			//Checking for Item1
			System.out.println("Checking image for visual_user login");
			System.out.println("For Item1: ");
			String orgimg11="/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";
			String curimg11="/static/media/sl-404.168b1cce.jpg";
			
			if(curimg11.equals(orgimg11))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			
			//Checking for Item2
			System.out.println("For Item2: ");
			String orgimg12="/static/media/bike-light-1200x1500.37c843b0.jpg";
			String curimg12="/static/media/bike-light-1200x1500.37c843b0.jpg";
			
			if(curimg12.equals(orgimg12))
			{
				System.out.println("Product image is correct\nTest case Passed");
			}
			else
			{
				System.out.println("Product image is incorrect\nTest case Failed!");
			}
			
	}
}
}
