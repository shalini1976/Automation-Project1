package Swag_Labs_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class checkItemPOM {
	WebDriver driver;

	//Methods to check if all the items can be clicked and once clicked open in a new page.
	//Also checks if item name on both the pages match,description starts with upper case,and title follows the naming convention
	//Color of the item name changes on mouse over
	//Test Cases from TS_02 are automated


	public checkItemPOM(WebDriver ldriver)
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

	}
	public void checkItem1()
	{
		java.util.Set<String> s1=driver.getWindowHandles();
		for (String window : s1)
		{
		driver.switchTo().window(window);
		}

		String str1=driver.findElement(By.xpath("//div[@class='inventory_container']/child::div/child::div/child::div/child::div/child::a/child::div")).getText();

		System.out.println("Item 1: "+str1);
		String actual1="Sauce Labs Backpack";
		try
		{
			if(str1.equals(actual1))

			{
			System.out.println("Item1 exists");

			driver.findElement(By.xpath("//div[@class='inventory_container']/child::div/child::div/child::div/child::div/child::a/child::div[text()='Sauce Labs Backpack']")).click();
			Thread.sleep(2000);
			String str2=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
			System.out.println("Item name: "+str2);
			if(str1.equals(str2))
			{
				System.out.println("Item name matches and it is clickable and displayed separately on a new page");
				System.out.println("Test Case Passed");
			}
			}
		}
			catch(Exception e)
			{
				System.out.println("Test Case Failed!");
			}

		//Clicking the 'Back to Products' link
		java.util.Set<String> s2=driver.getWindowHandles();
		for (String window : s2)
		{
		driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
	}

	public void checkItem2() throws InterruptedException
	{
		String str1=driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Bike Light']")).getText();
		System.out.println("Item 2: "+str1);
		String actual2="Sauce Labs Bike Light";
		try
		{
			if(str1.equals(actual2))
			{
			System.out.println("Item2 exists");

			driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Bike Light']")).click();
			Thread.sleep(2000);
			String str2=driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getText();
			if(str1.equals(str2))
			{
				System.out.println("Item name matches and it is clickable and displayed separately on a new page");
				System.out.println("Test Case Passed");
			}
			}
		}
			catch(Exception e)
			{
				System.out.println("Item Mismatch");
				System.out.println("Test Case Failed!");
			}

		//Clicking the 'Back to Products' link
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		Thread.sleep(3000);
	}

	public void checkItem3() throws InterruptedException
	{
		String str1=driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Bolt T-Shirt']")).getText();
		System.out.println("Item 3: "+str1);
		String actual3="Sauce Labs Bolt T-Shirt";
		try
		{
			if(str1.equals(actual3))
			{
			System.out.println("Item3 exists");

			driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Bolt T-Shirt']")).click();
			Thread.sleep(2000);
			String str2=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
			if(str1.equals(str2))
			{
				System.out.println("Item name matches and it is clickable and displayed separately on a new page");
				System.out.println("Test Case Passed");
			}
			}
		}
		catch(Exception e)
		{
			System.out.println("Item Mismatch");
			System.out.println("Test Case Failed!");
		}
		//Clicking the 'Back to Products' link
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		Thread.sleep(3000);
	}

	public void checkItem4() throws InterruptedException
	{
		String str1=driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Fleece Jacket']")).getText();
		System.out.println("Item 4: "+str1);
		String actual4="Sauce Labs Fleece Jacket";
		try
		{
			if(str1.equals(actual4))
			{
			System.out.println("Item4 exists");

			driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Fleece Jacket']")).click();
			Thread.sleep(2000);
			String str2=driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
			if(str1.equals(str2))
			{
				System.out.println("Item name matches and it is clickable and displayed separately on a new page");
				System.out.println("Test Case Passed");
			}
			}
		}
		catch(Exception e)
		{
			System.out.println("Item Mismatch");
			System.out.println("Test Case Failed!");
		}
		//Clicking the 'Back to Products' link
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		Thread.sleep(3000);
	}

	public void checkItem5() throws InterruptedException
	{
		String str1=driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Onesie']")).getText();
		System.out.println("Item 5: "+str1);
		String actual5="Sauce Labs Onesie";
		try
		{
			if(str1.equals(actual5))
			{
			System.out.println("Item5 exists");

			driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Sauce Labs Onesie']")).click();
			Thread.sleep(2000);
			String str2=driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
			if(str1.equals(str2))
			{
				System.out.println("Item name matches and it is clickable and displayed separately on a new page");
				System.out.println("Test Case Passed");
			}
			}
		}
		catch(Exception e)
		{
			System.out.println("Item Mismatch");
			System.out.println("Test Case Failed!");
		}

		//Clicking the 'Back to Products' link
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		Thread.sleep(3000);
	}

	public void checkItem6() throws InterruptedException
	{
		String str1=driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Test.allTheThings() T-Shirt (Red)']")).getText();
		System.out.println("Item 6: "+str1);
		String actual6="Test.allTheThings() T-Shirt (Red)";
		try
		{
			if(str1.equals(actual6))
			{
			System.out.println("Item6 exists");

			driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::div[text()='Test.allTheThings() T-Shirt (Red)']")).click();
			Thread.sleep(2000);
			String str2=driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")).getText();
			if(str1.equals(str2))
			{
				System.out.println("Item name matches and it is clickable and displayed separately on a new page");
				System.out.println("Test Case Passed");
			}
			}
		}
		catch(Exception e)
		{
			System.out.println("Item Mismatch");
			System.out.println("Test Case Failed!");
		}
		//Clicking the 'Back to Products' link
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		Thread.sleep(3000);
	}


	public void chkBackToProductsLink()
	{
		driver.get("https://www.saucedemo.com/inventory-item.html");

		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		System.out.println("Back To Products link clicked and working");
		System.out.println("Test Case Passed");
	}

	public void chkItemName()
	{
		System.out.println("Checking if item name follows naming convention");
		String str1=driver.findElement(By.xpath("//div[@class='inventory_list']/div[6]/child::div/child::div/a")).getText();
		System.out.println("Item Name is: "+str1);
		String str2="Sauce Labs";
		if(str1.startsWith(str2))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Item name does not follow naming convention.\nTest Case Failed!");
		}

	}

	public void chkDescription()
	{
		//Checking description for Sauce Labs Backpack
		String str1=driver.findElement(By.xpath("//a[@id='item_4_title_link']/following-sibling::div")).getText();
		System.out.println("Item description is: "+str1);
		char ch=str1.charAt(0);

		System.out.println("First Character is: "+ch);
		if(ch>=65)
		{
			if(ch<=97)
			{
			System.out.println("Test Case Passed");
			}
		else
		{
			System.out.println("Item decsription must start with an uppercase letter.\nTest Case Failed!");
		}
		}

		//Checking description for Sauce Labs Fleece Jacket
		String str2=driver.findElement(By.xpath("//a[@id='item_5_title_link']/following-sibling::div")).getText();
		System.out.println("Item description is: "+str2);
		char ch2=str2.charAt(0);

		System.out.println("First Character is: "+ch2);
		if(ch2>=65)
		{
			if(ch2<=97)
			{
			System.out.println("Test Case Passed");
			}
		else
		{
			System.out.println("Item decsription must start with an uppercase letter.\nTest Case Failed!");
		}
		}
	}
	public void chkColorOnMouseOver() throws InterruptedException
	{
		//Checking for Sauce Labs Backpack
		String colrI1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getCssValue("color");
		String c1=Color.fromString(colrI1).asHex();
		System.out.println("Initially, color of 'Sauce Labs Backpack' was: "+c1);

		Actions action =new Actions(driver);
		WebElement title= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		action.moveToElement(title);
		action.perform();
		String colrL1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getCssValue("color");
		String c2=Color.fromString(colrL1).asHex();
		System.out.println("After mouse over, color of 'Sauce Labs Backpack' is: "+c2);

		if(c1.equals(c2))
		{
			System.out.println("Color of 'Sauce Labs Backpack' is not changing\nTest Case Failed!\n");
		}
		else
		{
			System.out.println("Color of 'Sauce Labs Backpack' is changing after mouse over\nTest Case Passed\n");
		}
	Thread.sleep(2000);

	//Checking for Sauce Labs Bike Light
	String colrI2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getCssValue("color");
	String c3=Color.fromString(colrI2).asHex();
	System.out.println("Initially, color of 'Sauce Labs Bike Light' was: "+c3);

	Actions action1 =new Actions(driver);
	WebElement title1= driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
	action1.moveToElement(title1);
	action1.perform();
	String colrL2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getCssValue("color");
	String c4=Color.fromString(colrL2).asHex();
	System.out.println("After mouse over, color of 'Sauce Labs Bike Light' is: "+c4);

	if(c3.equals(c4))
	{
		System.out.println("Color of 'Sauce Labs Bike Light' is not changing\nTest Case Failed!\n");
	}
	else
	{
		System.out.println("Color of 'Sauce Labs Bike Light' is changing after mouse over\nTest Case Passed\n");
	}
	Thread.sleep(2000);

	//Checking for Sauce Labs Fleece Jacket
		String colrI3 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getCssValue("color");
		String c5=Color.fromString(colrI3).asHex();
		System.out.println("Initially, color of 'Sauce Labs Fleece Jacket' was: "+c5);

		Actions action3 =new Actions(driver);
		WebElement title3= driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
		action3.moveToElement(title3);
		action3.perform();
		String colrL3 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getCssValue("color");
		String c6=Color.fromString(colrL3).asHex();
		System.out.println("After mouse over, color of 'Sauce Labs Fleece Jacket' is: "+c6);

		if(c3.equals(c4))
		{
			System.out.println("Color of 'Sauce Labs Fleece Jacket' is not changing\nTest Case Failed!\n");
		}
		else
		{
			System.out.println("Color of 'Sauce Labs Fleece Jacket' is changing after mouse over\nTest Case Passed\n");
		}
		Thread.sleep(2000);

		//Checking for Sauce Labs Bolt T-Shirt
				String colrI4 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getCssValue("color");
				String c7=Color.fromString(colrI4).asHex();
				System.out.println("Initially, color of 'Sauce Labs Bolt T-Shirt' was: "+c7);

				Actions action4 =new Actions(driver);
				WebElement title4= driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
				action4.moveToElement(title4);
				action4.perform();
				String colrL4 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getCssValue("color");
				String c8=Color.fromString(colrL4).asHex();
				System.out.println("After mouse over, color of 'Sauce Labs Bolt T-Shirt' is: "+c8);

				if(c7.equals(c8))
				{
					System.out.println("Color of 'Sauce Labs Bolt T-Shirt' is not changing\nTest Case Failed!\n");
				}
				else
				{
					System.out.println("Color of 'Sauce Labs Bolt T-Shirt' is changing after mouse over\nTest Case Passed\n");
				}
				Thread.sleep(2000);

				//Checking for Sauce Labs Onesie
				String colrI5 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getCssValue("color");
				String c9=Color.fromString(colrI5).asHex();
				System.out.println("Initially, color of 'Sauce Labs Onesie' was: "+c9);

				Actions action5 =new Actions(driver);
				WebElement title5= driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
				action5.moveToElement(title5);
				action5.perform();
				String colrL5 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getCssValue("color");
				String c10=Color.fromString(colrL5).asHex();
				System.out.println("After mouse over, color of 'Sauce Labs Onesie' is: "+c10);

				if(c9.equals(c10))
				{
					System.out.println("Color of 'Sauce Labs Onesie' is not changing\nTest Case Failed!\n");
				}
				else
				{
					System.out.println("Color of 'Sauce Labs Onesie' is changing after mouse over\nTest Case Passed\n");
				}
				Thread.sleep(2000);

				//Checking for Test.allTheThings() T-Shirt (Red)
				String colrI6 = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")).getCssValue("color");
				String c11=Color.fromString(colrI6).asHex();
				System.out.println("Initially, color of 'Test.allTheThings() T-Shirt (Red)' was: "+c11);

				Actions action6 =new Actions(driver);
				WebElement title6= driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
				action6.moveToElement(title6);
				action6.perform();
				String colrL6 = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")).getCssValue("color");
				String c12=Color.fromString(colrL6).asHex();
				System.out.println("After mouse over, color of 'Test.allTheThings() T-Shirt (Red)' is: "+c12);

				if(c11.equals(c12))
				{
					System.out.println("Color of 'Test.allTheThings() T-Shirt (Red)' is not changing\nTest Case Failed!\n");
				}
				else
				{
					System.out.println("Color of 'Test.allTheThings() T-Shirt (Red)' is changing after mouse over\nTest Case Passed\n");
				}
				Thread.sleep(2000);

	}
	
}


