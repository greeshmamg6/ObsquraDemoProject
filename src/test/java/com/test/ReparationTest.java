package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ReparationPage;
import com.util.ExcelUtil;
import com.util.PropertyUtil;
import com.util.WaitUtil;
import com.util.WebUtil;

public class ReparationTest extends AutomationBase{
	WaitUtil waitutil=new WaitUtil();
	WebUtil webutil=new WebUtil();
	PropertyUtil properties= new PropertyUtil();
	LoginPage loginpage;
	HomePage homepage= new HomePage(driver);
	ReparationPage reparationpage;
	CustomerPage customerpage;
	SoftAssert soft= new SoftAssert();
	
	@BeforeTest
	@Parameters("browserName")
	public void launchApplication(String browserName) {
		driver = launchBrowser(browserName);
		waitutil.implicitWait(driver, 20);
		webutil.launchURL(driver, properties.getProperty("url"));
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		homepage = loginpage.validlogin(properties.getProperty("username"), properties.getProperty("password"));
		reparationpage = homepage.returnToReparationPage();
		Assert.assertEquals(driver.getTitle(), "Order & Reparations", "Problem occurred in loading Customer Page");
	}
	/**
	 * This method is used to validate Add Reparation Button 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void validateDisplayFieldsonClickofAddReparationButton() throws Exception {
		reparationpage.clickAddReparation();		
		/*soft.assertTrue(ReparationPage.imeiTextBox.isDisplayed(), "Problem occurred in loading Add Reparation");
		soft.assertTrue(ReparationPage.repairType.isDisplayed(), "Problem occurred in loading Add Reparation");
		//soft.assertTrue(ReparationPage.clientSelectList.isDisplayed(), "Problem occurred in loading Add Reparation");
		soft.assertTrue(ReparationPage.reparationModel.isDisplayed(), "Problem occurred in loading Add Reparation");
		soft.assertTrue(ReparationPage.defectTextBox.isDisplayed(), "Problem occurred in loading Add Reparation");
		soft.assertTrue(ReparationPage.warranty.isDisplayed(), "Problem occurred in loading Add Reparation");
		soft.assertTrue(ReparationPage.warrantyCardNumber.isDisplayed(), "Problem occurred in loading Add Reparation");
		soft.assertAll();*/
	}
/**
 * This method is used to enter the reparation details and submit the reparation form
 * @throws Exception
 */
	@Test(priority = 2)
	public void EnterAndSubmitClientDetails() throws Exception {
		reparationpage.enterReparationData();
		reparationpage.submitReparation();		
		//waitutil.explicitWait(driver, CustomerPage.clientNameAfterSave, 20);
		//Assert.assertEquals(null,CustomerPage.clientNameAfterSave.getText(),"Add Client failed");
}
	/*@Test(priority = 3)
	public void searchReparationDetails() throws Exception {
		}

/*	@Test(priority = 4)
	public void selectViewReparationMenu() throws Exception {
	}
 @Test(priority = 5)
	public void selectEditReparationMenu() throws Exception {
	 }
 @Test(priority = 6)
	public void selectReparationClient() throws Exception {
		}
 
 @Test(priority = 7)
	public void selectViewImage() throws Exception {
		}
 @Test(priority = 8)
 public void selectViewReparationRepairs() throws Exception {
		}
 
	@AfterTest
		public void closeCurrentWindow() throws Exception
		{
			loginpage.closeTest(driver);		
		}*/
}

