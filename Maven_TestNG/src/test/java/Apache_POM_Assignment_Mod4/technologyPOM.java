package Apache_POM_Assignment_Mod4;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class technologyPOM {
WebDriver driver;
	
	public technologyPOM(WebDriver ldriver)
	{
		driver=ldriver;	
	}
		
	public void url() throws InterruptedException
	{
		driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		Thread.sleep(2000);
	}
	public void clickTechnologies() throws InterruptedException
	{
		WebElement work=driver.findElement(By.xpath("//div[@class='container']/child::div[@id='navigation']/child::ul/child::li[5]/child::a"));
		Actions action=new Actions(driver);
		action.moveToElement(work);
		WebElement techno=driver.findElement(By.xpath("//a[@href='/technologies']/following::a[@href='/technologies']"));
		action.moveToElement(techno);
		Thread.sleep(10000);
		action.click().build().perform();
		
		System.out.println("\nClicked on Technologies\n");
	}
	
	public void retrieveTechnologies() throws InterruptedException
	{
		Thread.sleep(2000);
	
		System.out.println("Retrieving Technologies\n");
				
		List<WebElement> technology = driver.findElements(By.xpath("//h2[@class='section_heading']/span"));
		List<WebElement> inTech1 = driver.findElements(By.xpath("//div[@class='container']/child::div[@class='row justify-content-center']/descendant::a"));
		List<WebElement> inTech2 = driver.findElements(By.xpath("//div[@class='container']/child::div[@class='row justify-content-center']/descendant::span"));
		//Traversing through the list and printing its text 
		System.out.println("\nListing the categories of Technology\n");	
		for(WebElement link:technology)
		{
			if(link.getText().equalsIgnoreCase("Kick-Off"))
			{
				break;
			}
				System.out.println(link.getText()+" Technologies");
				
		}
		System.out.println("\n Listing the Technologies\n");
		
		for(WebElement link1:inTech1)
		{
		System.out.println(link1.getText());
		}
		
		// Doing this because span tag contains following text also. So to remove them from list of technologies
		List<String> arr = new ArrayList<>();
		arr.add("Front-End");
		arr.add("Back-End");
		arr.add("App");
		arr.add("Database");
		arr.add("CMS");
		arr.add("Devops");
		arr.add("WebRTC");
		arr.add("IOT");
		arr.add("Live");

		for(WebElement link2:inTech2)
			{
			String a = link2.getText();
			
			if(arr.contains(a))
			{
				continue;
			}
			System.out.println(a);
		}
		
	}
	
}
