package Swag_Labs_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkMenuItemPOM {
WebDriver driver;

	//Methods to check if menu items are working properly
	//Test Cases from TS_06 are automated


	public checkMenuItemPOM(WebDriver ldriver)
	{
		driver=ldriver;
	}

	public void url() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		java.util.Set<String> s=driver.getWindowHandles();
		for (String window : s)
		{
		driver.switchTo().window(window);
		}

	}

	public void menuItemAllItems() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='inventory_item_name ']")).click();

		Thread.sleep(3000);
		//Clicking on Open menu button
		if(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed())
		{
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		//All Items
		driver.findElement(By.xpath("//div[@id='menu_button_container']/child::div/child::div[@class='bm-menu-wrap']/child::div/child::nav/child::a[1]")).click();
		java.util.Set<String> s1=driver.getWindowHandles();
		for (String window : s1)
		{
		driver.switchTo().window(window);
		}

		String currURL=driver.getCurrentUrl();
		System.out.println(currURL);
		String actualURL="https://www.saucedemo.com/inventory.html";
		if(currURL.equals(actualURL))
		{
			System.out.println("Checking Menu Item - All items");
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed!");
		}
		}
		Thread.sleep(2000);
		}


	public void menuItemAbout() throws InterruptedException
	{

		Thread.sleep(3000);
		//Clicking on Open menu button
		if(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed())
		{
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		//About
		driver.findElement(By.xpath("//div[@id='menu_button_container']/child::div/child::div[@class='bm-menu-wrap']/child::div/child::nav/child::a[2]")).click();

		java.util.Set<String> s1=driver.getWindowHandles();
		for (String window : s1)
		{
		driver.switchTo().window(window);
		}

		String currURL=driver.getCurrentUrl();
		System.out.println(currURL);
		String actualURL="https://saucelabs.com/";
		if(currURL.equals(actualURL))
		{
			System.out.println("Checking Menu Item - About");
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed!");
		}
		}
		Thread.sleep(2000);
		//Going back to the Products page
		driver.navigate().back();
	}


		public void menuItemResetAppState() throws InterruptedException
	{
			java.util.Set<String> swin=driver.getWindowHandles();
			for (String window : swin)
			{
			driver.switchTo().window(window);
			}
			
			
		String num=driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
		System.out.println("Checking Reset App State");
		System.out.println("Initially number of items in shopping cart is: "+num);
		String s1=driver.findElement(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div/child::div/child::div/child::div/following-sibling::div/button[1]")).getText();
		System.out.println("Initially text on button is: "+s1);

		Thread.sleep(3000);
		//Clicking on Open menu button
		if(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed())
		{
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		//System.out.println("Menu button clicked");
		Thread.sleep(2000);
		//Reset App State
		driver.findElement(By.xpath("//div[@id='menu_button_container']/child::div/child::div[@class='bm-menu-wrap']/child::div/child::nav/child::a[4]")).click();
		//System.out.println("Reset button clicked");
		String num2=driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
		System.out.println("Number of items in Shopping cart after clicking on Reset is: "+num2);
		String s3=driver.findElement(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div/child::div/child::div/child::div/following-sibling::div/button[1]")).getText();
		System.out.println("Text on button after clicking on Reset is: "+s3);
		
		if(s3.equals("Add to cart"))
		 {
			System.out.println("Reset App State menu item working\nTest Case Passed");
		 }
		else
		{
			System.out.println("Reset App State menu item not working\nWould have changed to 'Add to cart'\nTest Case Failed!");
		}

	 }

	}
		public void menuItemLogout() throws InterruptedException
		{
			Thread.sleep(3000);
			//System.out.println("Logging Out");
			//Clicking on Open menu button
			/*if(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed())
			{
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
			Thread.sleep(2000);*/
			//Logout
			driver.findElement(By.xpath("//div[@id='menu_button_container']/child::div/child::div[@class='bm-menu-wrap']/child::div/child::nav/child::a[3]")).click();
			java.util.Set<String> s1=driver.getWindowHandles();
			for (String window : s1)
			{
			driver.switchTo().window(window);
			}

			String currURL=driver.getCurrentUrl();
			System.out.println(currURL);
			String actualURL="https://www.saucedemo.com/";
			if(currURL.equals(actualURL))
			{
				System.out.println("Checking Menu Item - Logout");
				System.out.println("Test Case Passed");
			}
			else
			{
				System.out.println("Test Case Failed!");
			}
			
			Thread.sleep(2000);
			}



}


