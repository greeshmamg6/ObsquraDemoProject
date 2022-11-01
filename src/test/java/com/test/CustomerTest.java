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
import com.util.PageUtil;
import com.util.PropertyUtil;
import com.util.WaitUtil;
import com.util.WebUtil;

public class CustomerTest extends AutomationBase {
	CustomerPage customerpage;
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage;
	PageUtil pageutil = new PageUtil();
	WaitUtil waitutil = new WaitUtil();
	WebUtil webutil = new WebUtil();
	SoftAssert soft = new SoftAssert();
	PropertyUtil properties = new PropertyUtil();
	String clientName=properties.getProperty("clientname");

	@BeforeTest
	@Parameters("browserName")
	public void launchApplication(String browserName) {
		driver = launchBrowser(browserName);
		waitutil.implicitWait(driver, 20);
		webutil.launchURL(driver, properties.getProperty("url"));
		driver.manage().window().maximize();
		waitutil.pageLoadTimeOut(driver, 30);
		loginpage = new LoginPage(driver);
		homepage = loginpage.validlogin(properties.getProperty("username"), properties.getProperty("password"));
		waitutil.pageLoadTimeOut(driver, 40);
		customerpage = homepage.returnToCustomerPage();
		Assert.assertEquals(driver.getTitle(), "Customers", "Problem occurred in loading Customer Page");
	}
// To add view action list
	
@Test(priority = 1)
	public void clickAddClientButton() throws Exception {
		customerpage.clickAddClient();
		soft.assertTrue(CustomerPage.clientName.isDisplayed(), "Problem occurred in loading Add Client Modal Dialog");
		soft.assertTrue(CustomerPage.company.isDisplayed(), "Problem occurred in loading Add Client Modal Dialog");
		soft.assertTrue(CustomerPage.address.isDisplayed(), "Problem occurred in loading Add Client Modal Dialog");
		soft.assertTrue(CustomerPage.city.isDisplayed(), "Problem occurred in loading Add Client Modal Dialog");
		soft.assertTrue(CustomerPage.postalCode.isDisplayed(), "Problem occurred in loading Add Client Modal Dialog");
		soft.assertTrue(CustomerPage.telephone.isDisplayed(), "Problem occurred in loading Add Client Modal Dialog");
		soft.assertTrue(CustomerPage.email.isDisplayed(), "Problem occurred in loading Add Client Modal Dialog");
		soft.assertAll();
	}

	@Test(priority = 2)
	public void EnterAndSubmitClientDetails() throws Exception {
		customerpage.fillAddClientForm();
		customerpage.clickSubmitAddClientButton();		
		waitutil.explicitWait(driver, CustomerPage.clientNameAfterSave, 20);
		Assert.assertEquals(clientName,CustomerPage.clientNameAfterSave.getText(),"Add Client failed");
}
	@Test(priority = 3)
	public void searchClientDetails() throws Exception {
		customerpage.closeCustomerWindow();
		customerpage.searchClient();
		String searchResult=CustomerPage.searchResultTableCol.getText();
		Assert.assertTrue(CustomerPage.searchResultTableCol.isDisplayed(), "Problem occurred Search table with customer details");
		Assert.assertEquals(clientName, searchResult,"Search result is not matching with the Customer Name");
	}

/*	@Test(priority = 4)
	public void selectViewClientMenu() throws Exception {
		customerpage.selectActionViewClient();
		soft.assertEquals(CustomerPage.clientNameAfterSave.getText(), properties.getProperty("clientname"),
				"Client Name not matching");
		soft.assertEquals(CustomerPage.clientCompanyAfterSave.getText(), properties.getProperty("company"),
				"Company Name not matching");
		soft.assertEquals(CustomerPage.clientAddressAfterSave.getText(), properties.getProperty("address"),
				"Address not matching");
		soft.assertEquals(CustomerPage.clientPostalCodeAfterSave.getText(), properties.getProperty("postalcode"),
				"Postal Code Name not matching");
		soft.assertEquals(CustomerPage.clientTelephoneAfterSave.getText(), properties.getProperty("telephone"),
				"Telephone Number not matching");
		soft.assertEquals(CustomerPage.clientEmailAfterSave.getText(), properties.getProperty("email"),
				"Email id not matching");
		soft.assertAll();
	}
 @Test(priority = 5)
	public void selectEditClientMenu() throws Exception {
	 customerpage.closeCustomerWindow();
		customerpage.selectActionEditClient();
		customerpage.editClientDetails();
		waitutil.explicitWait(driver, CustomerPage.clientCityAfterSave,30);
		Assert.assertEquals(CustomerPage.clientAddressAfterSave.getText(), "Bangalore", "Edit Client City unsuccessfull");
		}
 @Test(priority = 6)
	public void selectDeleteClient() throws Exception {
		customerpage.selectActionDeleteClient();
		customerpage.confirmAlert();
		Assert.assertEquals(driver.getTitle(), "Customers", "Problem occurred in Navigating back to HomePage");
	}
 
 @Test(priority = 7)
	public void selectViewImage() throws Exception {
		customerpage.selectActionViewImage();
		Assert.assertEquals(CustomerPage.dialogWindowViewImage.getText(), "No Image Uploaded", "Incorrect Viw Image Page");
		customerpage.closeViewImageModalDialog();
		Assert.assertTrue(CustomerPage.dialogWindowViewImage.isDisplayed(),"View Image Modal Dialog is not closed");
	}
 @Test(priority = 8)
 public void selectViewClientRepairs() throws Exception {
		customerpage.selectActionViewClientRepairs();
		Assert.assertFalse(CustomerPage.blankReparationWindow.isDisplayed()," Client Repairs Modal Dialog not visible");
 }	
 */
	@AfterTest
		public void closeCurrentWindow() throws Exception
		{
			loginpage.closeTest(driver);		
		}
}
