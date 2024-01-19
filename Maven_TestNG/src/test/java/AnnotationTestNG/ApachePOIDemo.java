package AnnotationTestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApachePOIDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com");
		Thread.sleep(2000);
		
		String filepath="C:\\Users\\hp\\Desktop\\Shalini_ExcelR\\Selenium\\Assignments\\Complete Assignments\\Apache_POI_Demo.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Data");

		int rows=sheet.getLastRowNum();
		System.out.println("Total number of rows: "+rows);

		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			XSSFCell userid=row.getCell(0);
			XSSFCell password=row.getCell(1);
			XSSFCell result=row.createCell(2);
			System.out.println("Email ID is :"+userid+"\t Password is: "+password);
		try {
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(userid.toString());
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password.toString());
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		Alert a=driver.switchTo().alert();
		a.accept();
		System.out.println("Valid Credentials");
		result.setCellValue("Valid");
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			String String;
			//WebElement errorContainer=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
			//String headerError = errorContainer.getText();
			
			//WebElement errorContainerList=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']/child::ul/child::li"));
			//String headerErrorList= errorContainerList.getText();
			
			
			System.out.println("Invalid Credentials");
			result.setCellValue("Invalid");
			//result.setCellValue(headerError);
			
			
		}
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(filepath);
		workbook.write(fos);
		
		Thread.sleep(2000);
		//driver.quit();
		


	}

}
