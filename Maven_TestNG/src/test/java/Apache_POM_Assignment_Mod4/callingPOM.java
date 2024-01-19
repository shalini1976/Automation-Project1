package Apache_POM_Assignment_Mod4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class callingPOM {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		headerPOM head=new headerPOM(driver);
		productsPOM prd=new productsPOM(driver);
		technologyPOM tech=new technologyPOM(driver);
		getQuotePOM gQuote= new getQuotePOM(driver);

		head.url();
		head.listHeader();
		prd.clickProducts();
		prd.url();
		prd.selectVDoctor();
		prd.retrieveFeatures();
		tech.url();
		tech.clickTechnologies();
		tech.retrieveTechnologies();
		gQuote.url();
		gQuote.clickQuote();
		try
		{
			gQuote.fillForm();
		}
		catch(Exception e)
		{
			
		}
		gQuote.selectOption();
		
		gQuote.clickSubmit();
		Thread.sleep(5000);

     driver.quit();
	}

}
