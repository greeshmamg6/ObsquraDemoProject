package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.InventoryPage;
import com.pages.LoginPage;
import com.util.PageUtil;
import com.util.PropertyUtil;
import com.util.WaitUtil;
import com.util.WebUtil;

public class InventoryTest extends AutomationBase {
	InventoryPage inventorypage;
	LoginPage loginpage;
	HomePage homepage;
	PageUtil pageutil = new PageUtil();
	WaitUtil waitutil = new WaitUtil();
	WebUtil webutil = new WebUtil();
	SoftAssert soft = new SoftAssert();
	PropertyUtil properties = new PropertyUtil();

	@DataProvider(name = "InventoryData")
	public Object[][] getData() {
		Object[][] data = new Object[1][6];
		data[0][0] = "Service";
		data[0][1] = "LankyBox";
		data[0][2] = "C";
		data[0][3] = "Abc";
		data[0][4] = "5000";
		data[0][5] = "test details";
		return data;
	}

	@BeforeTest
	@Parameters("browserName")
	public void launchApplication(String browserName) {
		driver = launchBrowser(browserName);
		waitutil.implicitWait(driver, 20);
		webutil.launchURL(driver, properties.getProperty("url"));
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		homepage = loginpage.validlogin(properties.getProperty("username"), properties.getProperty("password"));
		waitutil.pageLoadTimeOut(driver, 40);
		inventorypage = homepage.returnToInventoryPage();
		Assert.assertEquals(driver.getTitle(), "Inventory", AutomationConstants.ASSERT_FAILED_MESSAGE);
	}

	@Test(priority = 1)
	public void addDuplicateInventoryProduct() {
		inventorypage.clickActionsDropDown();
		inventorypage.selectOptionDuplicateProduct();
		Assert.assertEquals(driver.getTitle(), "Add Product", AutomationConstants.ASSERT_FAILED_MESSAGE);
	}

	@Test(dataProvider = "InventoryData", priority = 2)
	public void fillProductDetails(String pdtType, String pdtName, String pdtCode, String supplier, String pdtPrice,
			String pdtDetails) {
		inventorypage.enterProductType(pdtType);
		inventorypage.enterProductName(pdtName);
		inventorypage.enterProductCode(pdtCode);
		inventorypage.enterSupplier(supplier);
		inventorypage.enterProductPrice(pdtPrice);
		inventorypage.enterProductDetails(pdtDetails);
		inventorypage.clickAddProductButton();
		waitutil.explicitWait(driver, InventoryPage.successAlertMsg, 30);
		System.out.println(InventoryPage.successAlertMsg.getText());
		Assert.assertTrue(driver.getPageSource().contains("product_added"), AutomationConstants.ASSERT_FAILED_MESSAGE);
	}

	@Test(priority = 3)
	public void searchAddedProduct() {
		inventorypage.searchInventory(inventorypage.productCode);
		inventorypage.verifySearchResult();
		Assert.assertEquals(InventoryPage.searchReturnInventory.getText(), inventorypage.productCode,
				AutomationConstants.ASSERT_FAILED_MESSAGE);
	}

	@Test(priority = 4)
	public void editInventoryProduct() {
		inventorypage.selectOptionEditProduct();
		Assert.assertEquals(driver.getTitle(), "Edit Product", AutomationConstants.ASSERT_FAILED_MESSAGE);
		inventorypage.updateProductDetails("update");
		inventorypage.clickEditProductButton();
		Assert.assertTrue(driver.getPageSource().contains("Product successfully updated"),
				AutomationConstants.ASSERT_FAILED_MESSAGE);
	}

	@Test(priority = 5)
	public void printBarcode() {
		inventorypage.searchInventory(inventorypage.productCode);
		inventorypage.selectOptionprintBarcode();
		Assert.assertTrue(driver.getPageSource().contains("Product is added to barcode printing list"),
				AutomationConstants.ASSERT_FAILED_MESSAGE);
		Assert.assertEquals(InventoryPage.productNameinPrintBarcode.getText(), InventoryPage.productCode,
				AutomationConstants.ASSERT_FAILED_MESSAGE);
	}

	@Test(priority = 6)
	public void updateProductInPrintBarcode() {
		inventorypage.enterAddProductinPrintBarcode();
		inventorypage.clickUpdateButton();
		Assert.assertTrue(InventoryPage.pageBarcodeDetails.isDisplayed(), AutomationConstants.ASSERT_FAILED_MESSAGE);
	}

	@Test(priority = 7)
	public void resetProductInPrintBarcode() {
		inventorypage.clickResetButton();
		Assert.assertTrue(pageutil.isAlertPresent(driver), AutomationConstants.ASSERT_FAILED_MESSAGE);
		pageutil.confirmAlert(driver);
		Assert.assertFalse(pageutil.isAlertPresent(driver), AutomationConstants.ASSERT_FAILED_MESSAGE);
		Assert.assertFalse(InventoryPage.pageBarcodeDetails.isDisplayed(), AutomationConstants.ASSERT_FAILED_MESSAGE);
	}
	@Test(priority = 8)
	public void verifyPurchases() {
		inventorypage.clickPurchases();
		Assert.assertEquals(driver.getTitle(),"Purchases", AutomationConstants.ASSERT_FAILED_MESSAGE);
}
	}
