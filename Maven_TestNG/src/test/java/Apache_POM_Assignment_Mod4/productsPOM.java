package Apache_POM_Assignment_Mod4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class productsPOM {
	WebDriver driver;
	
	public productsPOM(WebDriver ldriver)
	{
		driver=ldriver;	
	}
		
	public void url() throws InterruptedException
	{
		driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		Thread.sleep(2000);
	}
	public void clickProducts() throws InterruptedException
	{
		WebElement work=driver.findElement(By.xpath("//div[@class='container']/child::div[@id='navigation']/child::ul/child::li[5]/child::a"));
		Actions action=new Actions(driver);
		action.moveToElement(work);
		WebElement prod=driver.findElement(By.xpath("//a[@href='/products']"));
		action.moveToElement(prod);
		Thread.sleep(10000);
		action.click().build().perform();
		System.out.println("\n**************Products Clicked*************\n");
	}
	
	public void selectVDoctor() throws InterruptedException
	{
		WebElement sol=driver.findElement(By.xpath("//a[@href='/solutions']"));
				
		Actions action=new Actions(driver);
		action.moveToElement(sol);
		
		WebElement vdoc=driver.findElement(By.xpath("//div[@id='navigation']/child::ul/child::li[4]/child::ul/child::li[6]/child::a"));
		
		action.moveToElement(vdoc);
		Thread.sleep(5000);
		action.click().build().perform();
		
		System.out.println("\nClicked on vDoctor\n");
	}
	
	public void retrieveFeatures() throws InterruptedException
	{
		Thread.sleep(2000);
		
		System.out.println("Retrieving Features of vDoctor");
				
		List<WebElement> features = driver.findElements(By.xpath("//div[@id='__next']/child::section[6]/descendant::div[@class='all_heading']/child::div[@class='common_list mb-4']/ul/li/span"));
		//Traversing through the list and printing its text 
		for(WebElement link:features){
			System.out.println(link.getText());
			
		}
		System.out.println("\n");
	}
}
