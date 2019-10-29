package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//a//button[@class='ui linkedin button']")
    WebElement createContacts;
	
	@FindBy(xpath="//input[@name='first_name']")
    WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
    WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
    WebElement companyName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
    WebElement saveButton;
	
	@FindBy(xpath="//span[contains(text(),'Sudhir Sharma')]")
	WebElement userNameLabel;
	
		
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	public void createNewContact(String fn,String ln,String cn) {
		createContacts.click();
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		companyName.sendKeys(cn);
		saveButton.click();
		
	}
	
	public Boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//parent::tr//div")).click();
	}
	
}
