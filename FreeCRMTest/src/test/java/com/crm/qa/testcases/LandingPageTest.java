package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignupPage;

public class LandingPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	SignupPage signupPage;
	
	public LandingPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage =new LandingPage();
	}
	
	@Test(priority=1)
	public void  titleHomeTest() {
		String title=landingPage.validateLandingPageTitle();
		Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=2)
	public void loginBtnTest() {
		loginPage =landingPage.loginBtn();
	}
	
	@Test(priority=3)
	public void signUpBtnTest() {
		signupPage = landingPage.signUpBtn();
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
