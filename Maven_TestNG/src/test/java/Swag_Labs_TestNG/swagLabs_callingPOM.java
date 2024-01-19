package Swag_Labs_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class swagLabs_callingPOM {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		//Creating object of classes
		checkLoginPOM logfunc=new checkLoginPOM(driver);
		checkItemPOM chkitm=new checkItemPOM(driver);
		checkImagePOM chkimg=new checkImagePOM(driver);
		checkFilterPOM chkfltr =new checkFilterPOM(driver);
		checkAddToCartPOM adtocrt=new checkAddToCartPOM(driver);
		checkMenuItemPOM mnuitm=new checkMenuItemPOM(driver);
		closeBrowserPOM clsB=new closeBrowserPOM(driver);

		//Test Scenario - TS_01
		
		logfunc.url();
		logfunc.checkLogin();

		//Test Scenario - TS_02
		chkitm.url();
		chkitm.checkItem1();
		chkitm.checkItem2();
		chkitm.checkItem3();
		chkitm.checkItem4();
		chkitm.checkItem5();
		chkitm.checkItem6();
		chkitm.chkItemName();
		chkitm.chkBackToProductsLink();
		chkitm.chkDescription();
		chkitm.chkColorOnMouseOver();
		
		chkimg.url();
		chkimg.checkProdImage();

		//Test Scenario - TS_03
		chkfltr.url();
		chkfltr.checkFilterByName2();
		chkfltr.checkFilterByName1();
		chkfltr.checkFilterByPrice1ohi();
		chkfltr.checkFilterByPricehilo();

		//Test Scenario - TS_04 & TS_05
	 	adtocrt.url();
		adtocrt.checkAddToCartButton();
		adtocrt.checkRemoveButton();
		adtocrt.checkEmptyShoppingProcess();
		adtocrt.checkShoppingProcess();
		adtocrt.checkBackHomeButton();
		adtocrt.checkContinueShoppingButton();

		//Test Scenario - TS_06
		mnuitm.url();
		mnuitm.menuItemAllItems();
		mnuitm.menuItemAbout();
		mnuitm.menuItemResetAppState();
		mnuitm.menuItemLogout();

		clsB.closeBrowser();
	
	}

}
