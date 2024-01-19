package Swag_Labs_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkAddToCartPOM {
	WebDriver driver;

	//Methods to check if Add to Cart button, Remove button, Checkout button is working properly
	//Test Cases from TS_04 and TS_05 are automated


	public checkAddToCartPOM(WebDriver ldriver)
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
	public void checkAddToCartButton() throws InterruptedException
	{
		//Adding Sauce Labs Backpack and Sauce Labs Bike Light to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		String num="2";

		String num1=driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
		System.out.println("After adding the items to cart, the cart shows "+num1+" items\n");
		if(num1.equals(num))
		{
			System.out.println("Add to Cart button is working\nTest Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed!");
		}

	}

	public void checkRemoveButton() throws InterruptedException
	{
		Thread.sleep(2000);
		//Removing Sauce Labs Backpack from cart
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();

		String num="1";

		String num1=driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
		System.out.println("After removing an item from the cart, the cart shows "+num1+" items");
		if(num1.equals(num))
		{
			System.out.println("Remove button is working\nTest Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed!");
		}

	}

	public void checkEmptyShoppingProcess() throws InterruptedException
	{
		Thread.sleep(2000);
		//Checking Out without adding any item to the cart
		//Removing the previously selected item
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']")).click();

		String num="";

		String num1=driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
		System.out.println("Checking Out empty cart");
		System.out.println("Current items in the cart: "+num1+"\n");
		if(num1.equals(num))
		{
			System.out.println("Cart is empty,Try clicking the cart");

		}
		else
		{
			System.out.println("Cart is not Empty");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/child::a[1]")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		String chkoutURL=driver.getCurrentUrl();
		String chkURL="https://www.saucedemo.com/checkout-step-one.html";
		if(chkoutURL.equals(chkURL))
		{
			System.out.println("You're on the'Checkout: Your Information' page\n"
					+ "Cannot checkout with 0 items in the cart\nTest Case Failed!");
		}
		else
		{
			System.out.println("Test Case Passed");
		}
	}
	public void checkShoppingProcess() throws InterruptedException
	{
		Thread.sleep(2000);
		//Going back to the Products page from Checkout: Your Information page
				driver.navigate().back();
				driver.navigate().back();
		//Adding Sauce Labs Backpack, Sauce Labs Bike Light and Sauce Labs Fleece Jacket to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		Thread.sleep(1000);
		String num1=driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();

		//Clicking on cart
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/child::a[1]")).click();

		//Retrieving the items in the 'Your Cart' page
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='cart_list']/child::div[@class='cart_item']"));
		int ctr=0;
		for(WebElement link:items)
		{
			System.out.println(link.getText());
			ctr=ctr+1;
		}
		System.out.println("Current items in the cart: "+num1+"\n");
		System.out.println("Number of items listed on Your Cart page are: "+ctr);
		if(Integer.parseInt(num1)==ctr)
		{
			System.out.println("All items added to the cart\nTest Case Passed");
		}
		else
		{
			System.out.println("Items Mismatch\nTest Case Failed!");
		}
		//Retrieving the total price
		float stotal=0;
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='item_pricebar']/child::div"));
		for(WebElement link:price)
		{
			System.out.println(link.getText());
			String prc=link.getText();
			String item_price=prc.substring(1,prc.length());
			//System.out.println("Formatted prc "+item_price);
			stotal=stotal + Float.parseFloat(item_price);
		}
		System.out.println("Total Price is: "+stotal);

		//Clicking on Checkout
		driver.findElement(By.xpath("//button[@id='checkout']")).click();

		//Clicking on Continue button without entering the details to check if fields can be left blank
			driver.findElement(By.xpath("//input[@id='continue']")).click();
			String err=driver.findElement(By.xpath("//h3")).getText();
			System.out.println("Error Message: "+err);

			driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Shalini");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='continue']")).click();
			String err1=driver.findElement(By.xpath("//h3")).getText();
			System.out.println("Error Message: "+err1);

			driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Shrivastava");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='continue']")).click();
			String err2=driver.findElement(By.xpath("//h3")).getText();
			System.out.println("Error Message: "+err2);

			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("560070");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='continue']")).click();
			System.out.println("All error messages are displayed - Blank Field Test Passed");
			Thread.sleep(3000);


		//Checking the sub-total price given on the page
			String subtot=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
			System.out.println("Subtot: "+subtot);
			String subtotal=subtot.substring(13,subtot.length());
			//System.out.println(" subtotal: "+subtotal);
			System.out.println("sum done: "+stotal+" given subtotal: "+subtotal);
			if(stotal==Float.parseFloat(subtotal))
			{
				System.out.println("Subtotal is correct - Passed");

			}
			else
			{
				System.out.println("Mismatch in subtotal - Failed");
			}

			//Checking the total price including tax
			String tx=driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
			System.out.println(tx);
			String tax=tx.substring(6,tx.length());
			Float gtotal=Float.parseFloat(subtotal)+Float.parseFloat(tax);

			String gtot=driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();
			String grandTotal=gtot.substring(8,gtot.length());
			System.out.println("Grand Total done: "+gtotal+" given grand total: "+grandTotal);

			if(gtotal==Float.parseFloat(grandTotal))
			{
				System.out.println("Bill is correct\n Test Case Passed\n");
			}
			else
			{
				System.out.println("Mismatch in grand total - Failed");
			}
			Thread.sleep(2000);
			//Clicking on Finish button
			driver.findElement(By.xpath("//button[@id='finish']")).click();
			String f=driver.findElement(By.xpath("//h2")).getText();
			System.out.println(f);
	}

	public void checkBackHomeButton()
	{
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();

		String bk=driver.findElement(By.xpath("//span[text()='Products']")).getText();
		String pg="Products";
		if(bk.equals(pg))
		{
			System.out.println("Back Home button is working\nTest Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed!");
		}
	}

	public void checkContinueShoppingButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/child::a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();

		String bk=driver.findElement(By.xpath("//span[text()='Products']")).getText();
		String pg="Products";
		if(bk.equals(pg))
		{
			System.out.println("Continue Shopping button is working\nTest Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed!");
		}
	}
}

