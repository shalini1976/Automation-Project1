package AnnotationTestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApacheMod4Assignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V4/");
		Thread.sleep(2000);
		
		String filepath="C:\\Users\\hp\\Desktop\\Shalini_ExcelR\\Selenium\\Assignments\\Complete Assignments\\Data_Apache_Mod4_Assignment.xlsx";
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
			System.out.println("User ID is :"+userid+"\t Password is: "+password);
		try {
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(userid.toString());
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password.toString());
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Thread.sleep(2000);
		Alert a=driver.switchTo().alert();
		a.accept();
		System.out.println("Valid Credentials");
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Credentials");
		}
		}
		fis.close();
		Thread.sleep(2000);
		driver.quit();
		
	}

}
