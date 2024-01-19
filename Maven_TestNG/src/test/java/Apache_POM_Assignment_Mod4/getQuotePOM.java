package Apache_POM_Assignment_Mod4;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class getQuotePOM {
WebDriver driver;
	
	public getQuotePOM(WebDriver ldriver)
	{
		driver=ldriver;	
	}
			
	public void url() throws InterruptedException
	{
		driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		Thread.sleep(2000);
	}
	
	public void clickQuote()
	{
		driver.findElement(By.xpath("//div[@class='btn btn-primary btn_custom']")).click();
	}
	
	public void fillForm() throws IOException 
	{
		String filepath="C:\\Users\\hp\\Desktop\\Shalini_ExcelR\\Selenium\\Assignments\\Complete Assignments\\Data_POM_Mod4_Assignment.xlsx";
	
	FileInputStream fis=new FileInputStream(filepath);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("Data");

	int rows=sheet.getLastRowNum();
	System.out.println("Total number of rows: "+rows);

	for(int r=1;r<=rows;r++)
	{
		XSSFRow row=sheet.getRow(r);
		XSSFCell name=row.getCell(0);
		XSSFCell email=row.getCell(1);
		XSSFCell contact=row.getCell(2);
		XSSFCell project=row.getCell(3);
		System.out.println("Name is :"+name+"\t Email is: "+email+"\t Contact Number is: "+contact+"\n Brief about Project is: "+project+"\n");
	try {
	driver.findElement(By.id("FIRSTNAME")).sendKeys(name.toString());
	driver.findElement(By.id("EMAIL")).sendKeys(email.toString());
	driver.findElement(By.id("PHONE")).sendKeys(contact.toString());
	driver.findElement(By.id("MESSAGE")).sendKeys(project.toString());
	}
	catch(Exception e)
		{
		System.out.println("Inside Catch");
		}
	}
	fis.close();
	}
	
	public void selectOption() throws InterruptedException
	{
		System.out.println("Going to select Options\n");
		
		//Scrolling down as it is not able to find the element
		
		WebElement Element=driver.findElement(By.id("IT_INTEREST"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		WebElement interest=driver.findElement(By.id("IT_INTEREST"));
		Select interestDropdown=new Select(interest);
		interestDropdown.selectByVisibleText("Mobile App Development");
		
		WebElement budget=driver.findElement(By.id("IT_BUDGET"));
		Select budgetDropdown=new Select(budget);
		budgetDropdown.selectByVisibleText("$25K+");
		
		WebElement requirement=driver.findElement(By.id("IT_REQUIREMENT"));
		Select reqDropdown=new Select(requirement);
		reqDropdown.selectByVisibleText("New Project");
		Thread.sleep(2000);
	}
	
	
	public void clickSubmit() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Submit']")).click();	
		System.out.println("Clicked on Submit");
		Thread.sleep(2000);
	}
}
