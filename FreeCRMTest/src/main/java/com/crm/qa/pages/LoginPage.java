package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
//	PageFactory --OR:
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement SigninBtn;
	@FindBy(xpath="//a[contains(text(),'Sign Up']")
	WebElement SignUp;
	
	
	public LoginPage(){
       PageFactory.initElements(driver,this);	
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	} 
	
	public HomePage login(String un,String pass) {
		email.sendKeys(un);
		password.sendKeys(pass);
		SigninBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
}
