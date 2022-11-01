package com.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.constants.AutomationConstants;
import com.util.ExcelUtil;
import com.util.PageUtil;
import com.util.PropertyUtil;
import com.util.WaitUtil;
import com.util.WebUtil;

public class ReparationPage {
	PageUtil pageutil=new PageUtil();
	WaitUtil waitutil=new WaitUtil();
	WebUtil webutil=new WebUtil();
	PropertyUtil properties= new PropertyUtil();
	WebDriver driver;
	
	public ReparationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(.,' Add Reparation')]")
	WebElement addReparationButton;
	@FindBy(id="imei")
	public static WebElement imeiTextBox;
	@FindBy(xpath="(//span[@class='select2-selection__placeholder'])[2]")
	public static WebElement clientSelectList;
	@FindBy(id="category")
	WebElement categoryTextBox ;
	@FindBy(id="reparation_manufacturer")
	WebElement manufacturerTextBox ;
	@FindBy(id="reparation_model")
	public static WebElement reparationModel ;
	@FindBy(id="defect")
	public static WebElement defectTextBox ;
	@FindBy(id="service_charges")
	WebElement serviceChargeTextBox;
	@FindBy(id="expected_close_date")
	WebElement closeDate;
	@FindBy(id="date_of_purchase")
	WebElement dateOfPurchase;
	@FindBy(id="select2-has_warranty-container")
	public static WebElement warranty ;
	@FindBy(id="warranty_card_number")
	public static WebElement warrantyCardNumber ;
	@FindBy(id="repair_type")
	public static WebElement repairType;
	@FindBy(id="repair_submit")
	WebElement repairSubmit;
	//window handle=${win6368}
	//cancel xpath=//div[@id='copy']/div
	@FindBy(id="titoloOE")
	WebElement titleReparationAfterSave;
	@FindBy(id="rv_rep_code")
	WebElement reperationCode;
	@FindBy(xpath="//button[contains(.,'×')]")
	WebElement closeReparationButton;
	@FindBy(xpath="//input[@type='search']")
	WebElement searchReparation;
	
public void clickAddReparation()
{
	addReparationButton.click();
}
public void enterReparationData() throws IOException
{
	//code to enter reparation data using excel
	ExcelUtil excelutil= new ExcelUtil(properties.getProperty("fileName"), properties.getProperty("sheetName"));
	String filePath=properties.getProperty("filePath");
	try {
		String data=excelutil.readStringData("ReparationWorkbook.xlsx", "AddReparationSheet", 1, 3);
	System.out.println("Excel Value: " +data);
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
		System.out.println(AutomationConstants.CAUSE + e.getCause());
	}
}
 public void submitReparation()
 {
	 //click submit
 }
 public void verifyReparationAdded()
 {
	 //to add Code
 }
 public void searchReparation(String value)
 {
	 try {
		searchReparation.click();
		 pageutil.typeValue(searchReparation, value);
		 searchReparation.sendKeys(Keys.ENTER);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
		System.out.println(AutomationConstants.CAUSE + e.getCause());
	}
 }
public void viewReparation()
{
 }
public void editReparation()
{
	
} 

}