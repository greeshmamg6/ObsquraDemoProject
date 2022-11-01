package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.base.AutomationBase;
import com.util.GenericUtil;
import com.util.PageUtil;
import com.util.PropertyUtil;
import com.util.WaitUtil;

public class HomePage extends AutomationBase {
	WebDriver driver;
	GenericUtil generic= new GenericUtil();
	PageUtil pageutil=new PageUtil();
	PropertyUtil properties= new PropertyUtil();
	WaitUtil waitutil=new WaitUtil();
	LoginPage loginpage;
	
	public HomePage(WebDriver driver)
	{
		this .driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//i[@class='fa fa-arrow-circle-right'])[2]")
	WebElement moreInfoClient;
	
	@FindBy(xpath="(//i[@class='fa fa-arrow-circle-right'])[1]")
	WebElement moreInfoReparations;
	
	@FindBy(xpath="(//i[@class='fa fa-arrow-circle-right'])[3]")
	WebElement moreInfoInventory;
	
		@FindBy(xpath="//div[@class='alert alert-success']")
		WebElement successMessage;
		@FindBy(xpath="//*[contains(text(),'Home')]")
		WebElement homeHeaderText;
		@FindBy(xpath="//div[@class='small-box bg-aqua']")
		WebElement reparationTile;
		@FindBy(xpath="//div[@class='small-box bg-green']")
		WebElement clientTile;
		@FindBy(xpath="//div[@class='small-box bg-yellow']")
		WebElement inventoryTile;
		
		@FindBy(xpath="(//h3[@class='box-title'])[3]")
		WebElement home_QuickEmail;
		@FindBy(xpath="(//h3[@class='box-title'])[4]")
		WebElement home_QuickSMS;
		@FindBy(xpath="//input[@type='email']")
		WebElement home_emailTo;
		@FindBy(xpath="//input[@placeholder='Subject']")
		WebElement home_Subject;
		@FindBy(xpath="//textarea[@name='body']")
		WebElement home_Message;
		@FindBy(xpath="//button[@form='send_email_form']")
		WebElement home_SendEmail;
		
		@FindBy(xpath="(//input[@type='text'])[3]")
		WebElement home_SMSNumber;
		@FindBy(xpath="(//textarea[@id='fastsms'])[1]")
		WebElement home_SMSText;		
		@FindBy(xpath="(//button[@type='submit'])[3]")
		WebElement home_SendSMS;
		
		@FindBy(xpath="//i[@class='fa fa-plus-circle']")
		WebElement home_AddNavigation;
		@FindBy(xpath="//span[@class='fa fa-user-plus icon']")
		WebElement home_AddClientNavigation;
		@FindBy(xpath="//span[@class='fa fa-list-alt icon']")
		WebElement home_AddReparationNavigation;
		@FindBy(xpath="//span[@class='fa fa-comment icon']")
		WebElement home_AddSendSMSNavigation;
		@FindBy(xpath="//span[@class='fa fa-paper-plane icon']")
		WebElement home_AddSendEmailNavigation;
		
		@FindBy(xpath="//i[@class='fa fa-exclamation-triangle']")
		WebElement home_QuantityAlert;
		@FindBy(xpath="//span[@class='label label-danger pull-right']")
		WebElement home_QuantityAlertDL;
		
		@FindBy(xpath="//input[@class='form-control input-xs']")
		WebElement home_SearchReparationSearchBox;
		@FindBy(id="sidebar_toggle")
		WebElement home_ToggleSidebarIcon;		
		
			
public boolean isReparationsVisible()
{
	return pageutil.verifyElementPresent(reparationTile);
}
public boolean isClientVisible()
{
	return pageutil.verifyElementPresent(clientTile);
}
public boolean isInventoryProductsVisible()
{
	return pageutil.verifyElementPresent(inventoryTile);
}
public boolean isQuickEmailVisible()
{
	return pageutil.verifyElementPresent(home_QuickEmail);
}
public boolean isQuickSMSVisible()
{
	return home_QuickSMS.isDisplayed();
}
public boolean isHomeAddNavigationVisible()
{
	return home_AddNavigation.isDisplayed();
}
public boolean isHomeQuantityAlertsVisible()
{
	return home_QuantityAlert.isDisplayed();
}
public String QuickEmail()
{
	return home_QuickEmail.getText();	
}
public void enterEmailTo(String emailid_To)
{
	pageutil.typeValue(home_emailTo, emailid_To);
}
public void enterSubject(String email_subject)
{
	pageutil.typeValue(home_Subject, email_subject);
}
public void enterEmailBody(String email_body)
{
	pageutil.typeValue(home_Message, email_body);
}

public void clickEmailSend()
{
	home_SendEmail.click();
}

public String QuickSMS()
{
	return home_QuickSMS.getText();	
}
public void enterSMSNumber(String sms_Number)
{
	home_SMSNumber.sendKeys(sms_Number);
}
public void enterSMSText(String sms_text)
{
	home_SMSText.sendKeys(sms_text);
}
public void clickSMSSend()
{
	home_SendSMS.click();
}
public void clickHomeAddNavigation()
{
	home_AddNavigation.click();
}
public boolean isHomeAddClientVisible()
{
	return home_AddClientNavigation.isDisplayed();
}
public boolean isHomeAddEmailVisible()
{
	return home_AddSendEmailNavigation.isDisplayed();
}

public boolean isHomeAddReparationVisible()
{
	return home_AddReparationNavigation.isDisplayed();
}
public boolean isHomeAddSMSVisible()
{
	return home_AddSendSMSNavigation.isDisplayed();
}
public void clickHomeQuantityAlert()
{
	home_QuantityAlert.click();
}
public void clickHomeQuantityAlertDL()
{
	home_QuantityAlertDL.click();
}
public void verifyQuantityAlertPageisDisplayed()
{
	driver.getTitle();
}
public CustomerPage returnToCustomerPage() {
	moreInfoClient.click();
waitutil.implicitWait(driver,20);
		return new CustomerPage(driver);
	}
public ReparationPage returnToReparationPage() {
	moreInfoReparations.click();
waitutil.implicitWait(driver,20);
		return new ReparationPage(driver);
}
public InventoryPage returnToInventoryPage() {
	moreInfoInventory.click();
waitutil.implicitWait(driver,20);
		return new InventoryPage(driver);
	}
}
