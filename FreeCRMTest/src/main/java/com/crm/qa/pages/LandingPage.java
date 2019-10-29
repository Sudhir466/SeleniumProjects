package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase {
//	PageFactory --OR:
	@FindBy(xpath="//a//span[contains(text(),'Log In')]")
	WebElement LogInBtn;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	//Initializing Page Objects---
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
     
	public LoginPage loginBtn() {
		LogInBtn.click();
		return new LoginPage();
	}
	
	public SignupPage signUpBtn() {
		SignUpBtn.click();
		return new SignupPage();
		
		
	}
}
