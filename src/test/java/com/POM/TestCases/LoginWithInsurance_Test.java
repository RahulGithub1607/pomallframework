package com.POM.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ExcelFunction.ReadFromExcel;
import com.insurance.pages.Insurance_HomePage;
import com.insurance.pages.Insurance_Login;

public class LoginWithInsurance_Test {
	
	WebDriver driver;
	Insurance_Login ObjLogin;
	
	Insurance_HomePage ObjHome;
	
	String title_loginpage;
	
	//initialize the driver and launch the URL
	
	@BeforeTest
	public void setup() throws IOException
	{
		//System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		
		//driver=new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//launch the URL
		//read the URL from the excel
		ReadFromExcel rx =new ReadFromExcel();
		String base_url=rx.readExcel(1, 1, ".\\Test Data\\Login Data.xlsx", "Sheet1");
		System.out.println("Read from excel for url:-"+base_url);
		driver.get(base_url);
		
		//driver.get("http://demo.guru99.com/V4/");  //launch the URL
		System.out.println("Website is launched");
				
	}

	//Verify the home dash board
	
	@Test(priority=0)
	public void verfiy_homepage_correct() throws Exception
	{
		
		System.out.println("In the home page correct calling insurance login");
		
		ObjLogin =new Insurance_Login(driver);
		
		System.out.println("calling logintitle check");
		//check the login title
		System.out.println("Check the driver value"+driver);
		
		title_loginpage = ObjLogin.getLogin_title(driver);
		System.out.println("back from class value"+title_loginpage);
		
		Assert.assertTrue(title_loginpage.toLowerCase().contains("guru99 bank home page"));//check the correct page or not
		
		//Login to Application with credentials
		System.out.println("calling login insurance by userdid and pwd");
		
		ObjLogin.LoginToInsurance("mngr194576","vajubyn",driver); //first is userID and second is password
						
		System.out.println("calling insurance home page");
		Thread.sleep(10000);
		
		//After login it will go to next page and check the correct home page
		
		ObjHome =new Insurance_HomePage(driver);
		System.out.println("Checking the handle after submit:-"+driver);
		String user_bytool = ObjHome.getHomepage_UserName(driver);
		System.out.println("Returning username from function:-"+user_bytool);
		
		//Verify the home page
		Assert.assertTrue(user_bytool.toLowerCase().contains("manger id : mngr194576"));
				
		
	}	
	

}
