package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
    LandingPage landingPage;
    HomePage homePage;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TasksPage tasksPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage(); 
		landingPage =new LandingPage();
		homePage= new HomePage();				
		loginPage=landingPage.loginBtn();
		homePage=loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyCorrectUserLabelTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Test(priority=2)
	public void clickOnContactsLinkTest() {
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=3)
	public void clickOnDealsLinkTest() {
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=4)
	public void clickOnTasksLinkTest() {
		tasksPage= homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
