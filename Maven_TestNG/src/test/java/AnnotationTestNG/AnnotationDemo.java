package AnnotationTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.testng.annotations.*;

public class AnnotationDemo {
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("This is Before Suite Method");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("This is Before Test Method");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This is Before Class Method");
	}
		
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This is Before Method");
	}
	@Test
	public void test()
	{
		System.out.println("This is my Test0");
	}
	@Test
	public void test1()
	{
		System.out.println("This is my Test1");
	}
	@Test
	public void test2()
	{
		System.out.println("This is my Test2");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This is After Method");
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("This is After Class Method");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("This is After Test Method");
	}
	@AfterSuite 
	public void afterSuite()
	{
		System.out.println("This is After Suite Method");
	}

}
