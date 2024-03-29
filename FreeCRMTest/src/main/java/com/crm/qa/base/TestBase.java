package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase(){
		
		try {	
			
			// This is Property file
		 prop =new Properties();
		 FileInputStream fis=new FileInputStream("C:\\Users\\Sudhir\\git\\SeleniumProjects\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		 prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
	}
	public static void initialization() {
		String browserName=  prop.getProperty("browser");
		
    	if(browserName.equals("Chrome")){
			 System.setProperty("webdriver.chrome.driver","D:\\New Software\\jar file all\\Drivers\\chromedriver.exe");
	         driver= new ChromeDriver();
		}
		else if(browserName.equals("FF")) {		
         	System.setProperty("webdriver.gecko.driver","D:\\New Software\\jar file all\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	   }
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
	}
}
