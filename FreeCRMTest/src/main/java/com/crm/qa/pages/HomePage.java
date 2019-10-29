package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsPage;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	
	public HomePage(){
	       PageFactory.initElements(driver,this);	
	}
		
		public Boolean verifyCorrectUserName() {
			    return userNameLabel.isDisplayed();
			
		} 
		
		public ContactsPage clickOnContactsLink() {
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink() {
			dealsPage.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}
}
