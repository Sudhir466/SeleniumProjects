package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
    
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =new LoginPage();
		landingPage = new LandingPage();
		loginPage=landingPage.loginBtn();
		
	}
	
	@Test(priority=1)
	public void titleLoginTest() {
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title,"Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
