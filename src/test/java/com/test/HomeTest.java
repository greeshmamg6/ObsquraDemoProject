package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.PropertyUtil;
import com.util.WaitUtil;
import com.util.WebUtil;

public class HomeTest extends AutomationBase {
	LoginPage loginpage;
	PropertyUtil properties = new PropertyUtil();
	WaitUtil waitutil = new WaitUtil();
	WebUtil webutil = new WebUtil();
	HomePage homepage;
	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void launchApplication(String browserName) throws Exception {
		driver = launchBrowser(browserName);
		waitutil.implicitWait(driver, 20);
		webutil.launchURL(driver, properties.getProperty("url"));
		driver.manage().window().maximize();
		waitutil.pageLoadTimeOut(driver, 30);
		loginpage = new LoginPage(driver);
		homepage = loginpage.validlogin(properties.getProperty("username"), properties.getProperty("password"));
		waitutil.pageLoadTimeOut(driver, 40);
	}
	@Test(priority = 1)
	public void verifyMenuListOnHomepage() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homepage.isReparationsVisible(), "Reparation Menu is not visible in the HomePage");

		soft.assertTrue(homepage.isClientVisible(), "Customer Menu is not visible in the HomePage");

		soft.assertTrue(homepage.isInventoryProductsVisible(),
				"Inventory Products Menu is not visible in the HomePage");
		soft.assertTrue(homepage.isQuickEmailVisible(),"Quick Email is not visible in the HomePage");
		soft.assertTrue(homepage.isQuickSMSVisible(),"Quick SMS is not visible in the HomePage");
		soft.assertTrue(homepage.isHomeAddNavigationVisible(), "Add icon not viisble");
		soft.assertTrue(homepage.isHomeQuantityAlertsVisible(), "Triangle icon for Quantity Alerts not viisble");
		soft.assertAll();
	}
	@Test(priority = 2)
	public void sendEmail_QuickEmail()
	{
	homepage.enterEmailTo("mggreeshma6@gmail.com");
	homepage.enterEmailBody("Test Email");
	homepage.enterEmailBody("Test");
	homepage.clickEmailSend();
	}
	@Test(priority = 3)
	public void sendSMS_QuickSMS()
	{
	homepage.enterSMSNumber("9008089513");
	homepage.enterSMSText("Test SMS");
	homepage.clickSMSSend();
	}
	@Test(priority = 4)
	public void verifyHomeAddFunctionality()
	{
	homepage.clickHomeAddNavigation();
	SoftAssert soft= new SoftAssert();
	soft.assertTrue(homepage.isHomeAddClientVisible(),"Homepage Add Client in navigation menu noy visible");
	soft.assertTrue(homepage.isHomeAddReparationVisible(),"Homepage Add Reparation in navigation menu noy visible");
	soft.assertTrue(homepage.isHomeAddEmailVisible(),"Homepage Add Email in navigation menu noy visible");
	soft.assertTrue(homepage.isHomeAddSMSVisible(),"Homepage Add SMS in navigation menu noy visible");
	soft.assertAll();
	}
	@Test(priority = 5)
	public void verifyQuantityAlerts()
	{
	homepage.clickHomeQuantityAlert();
	homepage.clickHomeQuantityAlertDL();
	Assert.assertEquals(driver.getTitle(),"Quantity Alerts","Quantity Alerts page is not displayed");
	}
	
	@AfterTest
	public void closeWindow() throws Exception
	{
		webutil.closeBrowser(driver);
	}
	
}
