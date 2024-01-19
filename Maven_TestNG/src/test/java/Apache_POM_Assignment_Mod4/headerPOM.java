package Apache_POM_Assignment_Mod4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class headerPOM {
	WebDriver driver;
		
	public headerPOM(WebDriver ldriver)
	{
		driver=ldriver;	
	}
			
	public void url() throws InterruptedException
	{
		driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		Thread.sleep(2000);
	}
	public void listHeader()
	{
		System.out.println("List of Headers");
		List<WebElement> header = driver.findElements(By.xpath("//div[@id='navigation']/child::ul/child::li/a"));
		//Traversing through the list and printing its text 
		for(WebElement link:header)
		{
			System.out.println(link.getText());
		}
	}
}

