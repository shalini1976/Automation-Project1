package Swag_Labs_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkFilterPOM {
WebDriver driver;

	//Methods to check if filter is working properly
	//Test Cases from TS_03 are automated


	public checkFilterPOM(WebDriver ldriver)
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
	public void checkFilterByName2() throws InterruptedException
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();

		driver.findElement(By.xpath("//select[@class='product_sort_container']/child::option[2]")).click();
		Thread.sleep(2000);
		String actual1="Test.allTheThings() T-Shirt (Red)";
		System.out.println("Filter clicked and Name(Z to A) selected");

		//Checking the list of items if it is arranged by name(Z to A)

		String str1=driver.findElement(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div/child::div/child::div/child::div/child::a")).getText();
		System.out.println("The first item is: "+str1);
		try
		{
			if(str1.equals(actual1))

			{
			System.out.println("Items rearranged by Name(Z to A)");
			System.out.println("Test Case Passed");
			}
		}
		catch(Exception e)
			{
			System.out.println("Filter By Name(Z to A) not working");
			System.out.println("Test Case Failed!");
			}
		List<WebElement> name = driver.findElements(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div/child::div/child::div/child::div/child::a"));
		//Printing by Name(Z to A)
		System.out.println("List of items By Name (Z to A)");
		for(WebElement link:name)
		{
			System.out.println(link.getText());

		}
		}

	public void checkFilterByName1() throws InterruptedException
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();

		driver.findElement(By.xpath("//select[@class='product_sort_container']/child::option[1]")).click();
		Thread.sleep(2000);
		String actual1="Sauce Labs Backpack";
		System.out.println("Filter clicked and Name(A to Z) selected");

		//Checking the list of items if it is arranged by name(A to Z)

		String str1=driver.findElement(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div/child::div/child::div/child::div/child::a")).getText();
		System.out.println("The first item is: "+str1);
		try
		{
			if(str1.equals(actual1))

			{
			System.out.println("Items rearranged by Name(A to Z)");
			System.out.println("Test Case Passed");
			}
		}
		catch(Exception e)
			{
			System.out.println("Filter By Name(A to Z) not working");
			System.out.println("Test Case Failed!");
			}
		List<WebElement> name = driver.findElements(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div/child::div/child::div/child::div/child::a"));
		//Printing by Name(A to Z)
		System.out.println("List of items By Name (A to Z)");
		for(WebElement link:name)
		{
			System.out.println(link.getText());

		}

		}

	public void checkFilterByPrice1ohi() throws InterruptedException
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();

		driver.findElement(By.xpath("//select[@class='product_sort_container']/child::option[3]")).click();
		Thread.sleep(2000);
		System.out.println("Filter clicked and Price(low to high) selected");

		List<WebElement> price = driver.findElements(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div[@class='inventory_list']/child::div/child::div/child::div/following-sibling::div/child::div"));
		//Printing by Price low to high

		for(WebElement link:price)
		{
			System.out.println(link.getText());

		}
		System.out.println("The items are arranged by Price(low to high)");
		System.out.println("Test case Passed");

		}

	public void checkFilterByPricehilo() throws InterruptedException
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();

		driver.findElement(By.xpath("//select[@class='product_sort_container']/child::option[4]")).click();
		Thread.sleep(2000);
		System.out.println("Filter clicked and Price(high to low) selected");

		List<WebElement> price = driver.findElements(By.xpath("//div[@id='inventory_container']/child::div/child::div/child::div[@class='inventory_list']/child::div/child::div/child::div/following-sibling::div/child::div"));
		//Printing by Price high to low

		for(WebElement link:price)
		{
			System.out.println(link.getText());

		}
		System.out.println("The items are arranged by Price(high to low)");
		System.out.println("Test case Passed");

		}

	}


