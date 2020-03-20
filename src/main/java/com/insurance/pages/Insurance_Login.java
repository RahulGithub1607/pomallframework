package com.insurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Login {
	WebDriver driver;	

	@FindBy(name="uid") WebElement username_insurance; //find username
   
	
    @FindBy(name="password") WebElement user_password; //find the password
    
    @FindBy(xpath="//div//h2[@class=\"barone\"]") WebElement guru_logo;
    
    @FindBy(name="btnLogin") WebElement submit_button; //click the submit
    
    
	public Insurance_Login(WebDriver driver) throws Exception{
		System.out.println("In the Insurance login constructor");
		//driver=this.driver;
		PageFactory.initElements(driver, this);
		System.out.println("Driver vlaue in the construotr"+driver);
	}
	

	public String getLogin_title(WebDriver driver) throws Exception{
		
	//System.out.println("Userid"+username_insurance);	
		
		// get title of the page--> return the title
	System.out.println("In the login title check ");
	Thread.sleep(3000);
	
	//WebDriverWait wait =new WebDriverWait(driver,10);
	//wait.until(ExpectedConditions.titleIs(" Guru99 Bank Home Page "));
	
	System.out.println("Title of Page :-"+ driver.getTitle().toString());
	
	String title_tool =driver.getTitle().toString();
	
	
	return title_tool;
			
	}


	public void LoginToInsurance(String username_login, String password_login, WebDriver driver2) throws Exception {
		//login code
		System.out.println("Login to Insurance page");
		
		username_insurance.sendKeys(username_login); //username entered
		
		user_password.sendKeys(password_login);      //password enetered
		
		
		guru_logo.click();
		
		System.out.println("Text on logo:"+guru_logo.getText());
		
		System.out.println("Current control:"+driver2);
			
		//submit_button.submit();    //click on submit button
	   
		//System.out.println("Submit function worked");	
		
	     // submit_button.sendKeys(Keys.ENTER);
	    //System.out.println("Enter key is pressed");
		
		System.out.println("Find the button"+submit_button);
	    
		submit_button.click();
		System.out.println("Clicked on submit button");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}

	
}
