package AnnotationTestNG;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentThree {
	WebDriver driver;
	WebElement female,focus,focusNext,focusNew, focusOnCityNext,Element;
	WebElement checkbox2,checkbox3,dob,subject,state,city;
	String str,value;
	@BeforeSuite (groups = {"Smoke","Regression"})
	public void launchBrowser() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com");
		Thread.sleep(5000);
	}

	@Test(groups = {"Smoke"})
	public void clickForm() throws InterruptedException
	{
	   //Scrolling down to click on Form else it's not working
		
		Element=driver.findElement(By.tagName("h5"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);

		//Clicking on Form (Demoqa.com)
		driver.findElement(By.xpath("//div[@class='category-cards']/child::div[2]/child::div[1]")).click();

		System.out.println("Form Clicked");
		Thread.sleep(2000);
		System.out.println("Smoke1 is running - Form");
	}


	 @Test (groups = {"Smoke"})

	public void clickPracticeForm() throws InterruptedException
	{

		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
		Thread.sleep(3000);
		System.out.println("Smoke2 is running - Practice Form");
	}

	@Test (groups = {"Regression"})
	public void enterData() throws InterruptedException, AWTException
	{
	driver.findElement(By.id("firstName")).sendKeys("Shalini");
	driver.findElement(By.id("lastName")).sendKeys("Shrivastava");
	driver.findElement(By.id("userEmail")).sendKeys("shalini@yahoo.com");

	female =driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/child::div[@class='practice-form-wrapper']/child::form[@id='userForm']/child::div[3]/child::div[2]/child::div[2]/child::label"));
	System.out.println("female: "+female);
	female.click();

	driver.findElement(By.id("userNumber")).sendKeys("9187654321");

	driver.findElement(By.id("dateOfBirthInput")).sendKeys(" sept 1990");
	driver.findElement(By.xpath("//div[@class='react-datepicker-popper']")).click();
	Thread.sleep(2000);

	//Scrolling down as other elements are not reachable
	Element=driver.findElement(By.xpath("//form[@id='userForm']/child::div[6]"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	Thread.sleep(2000);

	driver.findElement(By.id("subjectsInput")).sendKeys("Computer Science");
	Thread.sleep(1000);

	driver.findElement(By.xpath("//div[@class='subjects-auto-complete__option subjects-auto-complete__option--is-focused css-1n7v3ny-option']")).click();


	driver.findElement(By.xpath("//div[@id='hobbiesWrapper']")).click();

	driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/child::div[2]/child::div[3]/child::label[1]")).click();
	Thread.sleep(1000);
	
	focusNext=driver.findElement(By.xpath("//div[@id='currentAddress-wrapper']/child::div[2]/child::textarea[@id='currentAddress']"));
	focusNext.sendKeys("Akshayanagar");
	focusNext.click();
	Thread.sleep(1000);

	//Taking the focus through keyboard on State and City Elements as they are hidden behind advertisement, so not clickable
	new Actions(driver)
	.sendKeys(Keys.TAB)
	.sendKeys(Keys.SPACE)
	.perform();

	Thread.sleep(1000);

	focusNew=driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/child::div[2]/child::div[@id='state']"));
	focusNew.isEnabled();
	String strt=focusNew.getText();
	System.out.println("value in state"+strt);

	//The list box of State element is hidden
	By hiddenObj = By.xpath("//div[@id='stateCity-wrapper']/child::div[2]/child::div[@id='state']/child::div/child::div[2]/child::div/child::div[@class=' css-2613qy-menu']");
	System.out.println("Element is : "+hiddenObj);

		focusNext=driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/child::div[2]/child::div[@id='state']/child::div/child::div/child::div[1]"));
		focusNext.click();
		String start=focusNext.getText();
		System.out.println("Text Displayed in State is :"+start);
		
	System.out.println("State Selected");
	Thread.sleep(3000);

	//Taking the focus back to the previous element as pressing TAB key from STATE is going directly to SUBMIT button
	new Actions(driver)
	.keyDown(Keys.SHIFT)
	.sendKeys(Keys.TAB)
	.keyUp(Keys.SHIFT)
	.perform();
	
	Thread.sleep(1000);
		
	WebElement focusOnCity=driver.findElement(By.xpath("//div[@id='stateCity-wrapper']/child::div[@class='col-md-4 col-sm-12']/child::div[@id='city']"));
	focusOnCity.isEnabled(); 
	focusOnCity.isSelected();
	System.out.println("Focus is on City");
	String city=focusOnCity.getText();
	System.out.println("value in City :"+city);
		
	By hiddenObj1 = By.xpath("//div[@id='city']/child::div[1]/child::div[2]/child::div[@class='viewBox=\"0 0 20 20']/child::svg[@class='css-19bqh2r']/child::div[@class=' css-2613qy-menu']");
	System.out.println("Element is : "+hiddenObj1);
	hiddenObj1.name("Delhi");
	System.out.println("Delhi Selected");
	Thread.sleep(3000);
	System.out.println("Regression is running");
	}

	@Test
	public void submitForm() throws InterruptedException
	{

		driver.findElement(By.xpath("//button[text()='Submit']")).sendKeys(Keys.SPACE);
		System.out.println("Submit clicked");
		Thread.sleep(3000);
		}


	@AfterSuite
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}


