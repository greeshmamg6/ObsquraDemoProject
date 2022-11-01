package com.pages;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.GenericUtil;
import com.util.PageUtil;
import com.util.WaitUtil;

public class InventoryPage {
	WebDriver driver;
	PageUtil pageutil= new PageUtil();
	GenericUtil genericutil=new GenericUtil();
	WaitUtil waitutil=new WaitUtil();
	
	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public static String productCode;
@FindBy(xpath="(//button[@type='button'])[1]")
WebElement actionsDropDown;
@FindBy(xpath="(//i[@class='fa fa-plus-square'])[1]")
WebElement listDuplicateProduct;
@FindBy(xpath="(//i[@class='fa fa-edit'])[1]")
WebElement listEditProduct;
@FindBy(xpath="(//a[@class='tip po'])[1]")
WebElement listDeleteProduct;
@FindBy(xpath="(//i[@class='fa fa-print'])[1]")
WebElement listPrintBarcodeLabel;

@FindBy(xpath="(//span[@class='selection'])[1]")
WebElement txtProductType;
@FindBy(xpath="(//span[@class='select2-selection__arrow'])[1]")
WebElement listProductType;
@FindBy(xpath="(//input[@type='search'])[3]")
WebElement searchProductType;
@FindBy(xpath="//input[@name='name']")
WebElement txtProductName;
@FindBy(xpath="//input[@name='code']")
WebElement txtProductCode;
@FindBy(xpath="//input[@type='search']")
WebElement txtSupplier;
@FindBy(xpath="(//span[@dir='ltr'])[5]")
WebElement txtSearchSupplier;
@FindBy(xpath="//input[@name='price']")
WebElement txtProductPrice;
@FindBy(xpath="//textarea[@name='details']")
WebElement txtProductDetails;
@FindBy(xpath="//input[@name='add_product']")
WebElement submitAddProduct;

@FindBy(xpath="//div[@class='alert alert-success']")
public static WebElement successAlertMsg;
@FindBy(xpath="//input[@type='search']")
public static WebElement searchInventory;
@FindBy(xpath="//table[@id='PRData']//tr//td[3]")
public static WebElement searchReturnInventory;

@FindBy(xpath="//input[@name='edit_product']")
WebElement submitEditProduct;
@FindBy(xpath="//table[@id='bcTable']//tr//td[1]")
public static WebElement productNameinPrintBarcode;
@FindBy(xpath="//input[@name='add_barcode_item']")
WebElement addBarcodeItem;
@FindBy(xpath="//input[@value='Update']")
WebElement updateBarcodeButton;
@FindBy(xpath="//div[@id='page']")
public static WebElement pageBarcodeDetails;
@FindBy(xpath="//button[@id='reset']")
WebElement resetBarcodeButton;
@FindBy(linkText ="Purchases")
WebElement linkPurchases;


public void clickActionsDropDown()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", actionsDropDown);
	}
public void selectOptionDuplicateProduct()
{ 
	pageutil.clickElement(driver, listDuplicateProduct);
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].click();", listDuplicateProduct);		
	}
public void enterProductType(String productType)
{ waitutil.explicitWait(driver, listProductType, 30);
waitutil.implicitWait(driver, 30);
/*pageutil.clickElement(driver, listProductType);
System.out.println("Element Visible: Product Type: " + txtProductType.isDisplayed());
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", txtProductType);*/
txtProductType.click();
	searchProductType.sendKeys(productType);	
	searchProductType.sendKeys(Keys.ENTER);
}
public void enterProductName(String productName)
{
	txtProductName.clear();
	txtProductName.sendKeys(productName);
	txtProductName.sendKeys(Keys.ENTER);
}
public void enterProductCode(String prodCode)
{
	productCode=prodCode+new Date().getTime();
	txtProductCode.clear();
	txtProductCode.sendKeys(productCode);
	txtProductCode.sendKeys(Keys.ENTER);
}
public void enterSupplier(String supplier)
{
	txtSupplier.clear();
	txtSupplier.sendKeys(supplier);
	txtSupplier.sendKeys(Keys.ENTER);
	//pageutil.clickElement(driver, txtSearchSupplier);
}
public void enterProductPrice(String productPrice)
{
	txtProductPrice.clear();
	txtProductPrice.sendKeys(productPrice);
	txtProductPrice.sendKeys(Keys.ENTER);
}
public void enterProductDetails(String productDetails)
{
	txtProductDetails.clear();
	txtProductDetails.sendKeys(productDetails);
	txtProductDetails.sendKeys(Keys.ENTER);
}
public void clickAddProductButton()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//Scroll down till the bottom of the page
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//js.executeScript("arguments[0].click();", submitAddProduct);
	submitAddProduct.click();	
}
public void searchInventory(String product)
{
	pageutil.clickElement(driver, searchInventory);
	searchInventory.sendKeys(product);
	searchInventory.sendKeys(Keys.ENTER);
}
public void verifySearchResult()
{
	if(searchReturnInventory.isDisplayed())
	{
		System.out.println("Inventory: Search Result displayed");
	}
	else
	{
		System.out.println("Inventory: Search Result not displayed");
	}
	
}
public void selectOptionEditProduct()
{ 
	pageutil.clickElement(driver, listEditProduct);		
	}
public void updateProductDetails(String updatedetails)
{
	txtProductDetails.sendKeys(updatedetails);
}
public void clickEditProductButton()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//Scroll down till the bottom of the page
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//js.executeScript("arguments[0].click();", submitAddProduct);
	submitEditProduct.click();
}
public void selectOptionprintBarcode()
{ 
	pageutil.clickElement(driver, listPrintBarcodeLabel);		
	}
public void enterAddProductinPrintBarcode()
{
	addBarcodeItem.click();
	addBarcodeItem.sendKeys("Test");
	addBarcodeItem.sendKeys(Keys.ENTER);
}
public void clickUpdateButton()
{
	updateBarcodeButton.click();
}
public void clickResetButton()
{
	resetBarcodeButton.click();
}
public void clickPurchases()
{
	linkPurchases.click();
}
}