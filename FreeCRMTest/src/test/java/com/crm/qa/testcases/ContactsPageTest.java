package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	ContactsPage contactsPage;
		
	String sheetName="contacts";
	
	public ContactsPageTest() {
		super();		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage(); 
		landingPage =new LandingPage();
		homePage= new HomePage();	
		contactsPage =new ContactsPage();
		loginPage=landingPage.loginBtn();
		homePage=loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyTitleTest() {
		String title=contactsPage.verifyTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		}

	@Test(priority=2)
	public void verifyCorrectUserTest() {
		Boolean flag=contactsPage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
    public void selectContactByNameTest() {
    	contactsPage.selectContactByName("Tanu  Lekha");
    	
    }
	@Test(priority=4)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactByName("Tanu  Lekha");
    	contactsPage.selectContactByName("Sudhir Sharma");
    	
    	
	}
	@DataProvider
	public Object[][] getCrmTestData() { 
	    Object[][] data=TestUtil.getTestData(sheetName);
	    return data;
		
	}
	@Test(priority=4, dataProvider="getCrmTestData")
	public void createNewContactTest(String firstName,String lastName,String companyName) {
		contactsPage.createNewContact(firstName,lastName,companyName);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
