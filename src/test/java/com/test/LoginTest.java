package com.test;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.GenericUtil;
import com.util.PageUtil;
import com.util.PropertyUtil;
import com.util.WaitUtil;
import com.util.WebUtil;



public class LoginTest extends AutomationBase {
	PropertyUtil properties = new PropertyUtil();
	WaitUtil waitutil=new WaitUtil();
	PageUtil pageutil=new PageUtil();
	WebUtil webutil=new WebUtil();
	HomeTest hometest;
	LoginPage loginpage;
	WebDriver driver;
		
	@Parameters("browserName")
	@BeforeTest	
	public void launchApplication(String browserName) throws InterruptedException
	{		
		
		driver=launchBrowser(browserName);
		//waitutil.implicitWait(driver, 20);
		webutil.launchURL(driver, properties.getProperty("url"));
		Thread.sleep(3000);
	driver.manage().window().maximize();
	waitutil.pageLoadTimeOut(driver, 30);
	loginpage=new LoginPage(driver);
	}	

	@Test(priority=1)
public void login() throws Exception 	
	{   
		String userName= properties.getProperty("username");
		String password= properties.getProperty("password");		
		loginpage.typeUserName(userName);
		loginpage.typePassword(password);
		loginpage.clickLogin();	
		waitutil.pageLoadTimeOut(driver, 30);
		Assert.assertEquals(driver.getTitle(), "Home", "Home Test: Home Page not loaded");		 	 
		}
	
	@AfterTest
	public void closeCurrentWindow() throws Exception
	{
		loginpage.closeTest(driver);		
	}

}
