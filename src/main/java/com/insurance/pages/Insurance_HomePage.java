package com.insurance.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_HomePage {
	WebDriver driver;

	@FindBy(xpath="//table//tr[@class=\"heading3\"]") WebElement heading_homepage;
	
	public Insurance_HomePage(WebDriver driver) {
		System.out.println("In the insurnace home page constructor");
		//driver =this.driver;
		PageFactory.initElements(driver, this);
	}

	public String getHomepage_UserName(WebDriver driver) {
		System.out.println("In the homepage username check method");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return heading_homepage.getText();
		
		
	}
		

}
