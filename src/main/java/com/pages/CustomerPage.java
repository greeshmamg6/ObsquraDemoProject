package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.util.GenericUtil;
import com.util.PageUtil;
import com.util.PropertyUtil;
import com.util.WaitUtil;
import com.util.WebUtil;

public class CustomerPage {
	WebDriver driver;
	PageUtil pageutil=new PageUtil();
	PropertyUtil properties = new PropertyUtil();
	WaitUtil waitutil= new WaitUtil();
	GenericUtil genericutil=new GenericUtil();
	JavascriptExecutor js= (JavascriptExecutor) driver;
	public CustomerPage(WebDriver driver)
	{
		this .driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[contains(h1,'Customers')]")
	WebElement textCustomer;
	@FindBy(xpath="//button[@class='add_c btn btn-primary']")
	WebElement addClientButton;
	
	// Add Client identifiers
	@FindBy(xpath="//div[@class='modal-dialog modal-lg']")
	WebElement addClientModalDialog;
	 @FindBy(xpath="//input[@id='name1']")
	 public static WebElement clientName;
	 @FindBy(id="company1")
	 public static WebElement company;
	 @FindBy(id="route")
	 public static  WebElement address;
	 @FindBy(id="locality")
	 public static  WebElement city;
	 @FindBy(id="postal_code")
	 public static WebElement postalCode;
	 @FindBy(id="telephone")
	 public static  WebElement telephone;
	 @FindBy(id="email1")
	 public static  WebElement email;
	 @FindBy(xpath="//button[@class='btn btn-success']")
	 WebElement addClientSubmit;
	 
	//After Save 
	 @FindBy (xpath="//span[@id='v_name']")
	 public static WebElement clientNameAfterSave;
	 @FindBy (xpath="//span[@id='v_company']")
	 public static WebElement clientCompanyAfterSave;
	 @FindBy (xpath="//span[@id='v_address']")
	 public static WebElement clientAddressAfterSave;
	 @FindBy (xpath="//span[@id='v_city']")
	 public static WebElement clientCityAfterSave;
	 @FindBy (xpath="//span[@id='v_postal_code']")
	 public static WebElement clientPostalCodeAfterSave;
	 @FindBy (xpath="//span[@id='v_telephone']")
	 public static WebElement clientTelephoneAfterSave;
	 @FindBy (xpath="//span[@id='v_email']")
	 public static WebElement clientEmailAfterSave;
	 
	 @FindBy(xpath="(//button[@data-dismiss='modal'])[7]")
	 WebElement closeModalDialog;
	 
	 //Search 
	 @FindBy(xpath="(//input[@type='search'])[1]")
	 WebElement searchBox;
	 
	 @FindBy(xpath="//*[@id=\"dynamic-table\"]/thead/tr/th[1]")
	 WebElement tableRow;
	 
	 @FindBy(xpath="//table[@id='dynamic-table']//tr[2]//td[2]")
	public static  WebElement tableCol;
	 
	 @FindBy(xpath="(//table[@id='dynamic-table']//tr[2]//td[2])[1]")
		public static  WebElement searchResultTableCol;
	 
	 @FindBy(xpath="(//button[@type='button'])[1]")
	 WebElement actionDropdown;
	 
	 @FindBy(xpath="(//button[@data-toggle='dropdown'])[1]")
	 WebElement actionDropdownViewClient;
	 @FindBy(xpath="(//a[@class='view_client'])[1]")
		WebElement optionViewClient;
	 @FindBy(xpath="(//a[@id='modify_client'])[1]")
		WebElement optionEditClient;
	 @FindBy(xpath="//input[@id='name1']")
		WebElement ClientName_EditClient;
	
	 
	 @FindBy(xpath="//button[@id='submit']")
	 WebElement saveChangesClientButton;	 
	 
	 @FindBy(xpath="//input[@id='image']")
	 WebElement uploadButton;
	 
	 @FindBy(xpath="//a[@id='delete_client']")
	 WebElement OptionDeleteClient;
	 
	 @FindBy(xpath="//a[@id='view_image']")
	 WebElement OptionViewImage;
	 @FindBy(xpath="(//div[@class='modal-body'])[11]")
	 public static WebElement dialogWindowViewImage;	 
	 @FindBy(xpath="(//button[@class='btn btn-primary'])[4]")
	 WebElement okButton;

	 @FindBy(xpath="//a[@data-target='#myModalLG']")
	 WebElement OptionViewClientRepairs;	  
	 @FindBy(xpath="//div[@id='view-repars-table_wrapper']")
	 public static WebElement blankReparationWindow;
	 
	public void customerPageInit(WebDriver driver)
	{ 
		this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	public void verifyCustomerPageDisplayed()
	{
		waitutil.explicitWait(driver, addClientButton, 20);
		if(addClientButton.isDisplayed()==false)
		{
			waitutil.fluentWait(driver, addClientButton, 20);
		}
	}
	public void clickAddClient()
	{
		//waitutil.explicitWait(driver,addClientButton,30);
		addClientButton.click();
		waitutil.explicitWait(driver, clientName, 30);	
		}
	public void fillAddClientForm()
	{
	pageutil.typeValue(clientName,properties.getProperty("clientname"));	
	pageutil.typeValue(company,properties.getProperty("company") );
	pageutil.typeValue(address,properties.getProperty("address") );
	pageutil.typeValue(postalCode,properties.getProperty("postalcode") );
	pageutil.typeValue(telephone,properties.getProperty("telephone") );
	pageutil.typeValue(email,properties.getProperty("email") );
	}
	
	public void clickSubmitAddClientButton()
	{ 
		waitutil.implicitWait(driver, 20);
		if(addClientSubmit.isDisplayed())
	{
		addClientSubmit.click();
		waitutil.implicitWait(driver, 30);
			//js.executeScript("arguments[0].click();", addClientSubmit);
		waitutil.explicitWait(driver,clientNameAfterSave,30);
	}
	else
	{
	js.executeScript("arguments[0].scrollIntoView(true);", addClientSubmit);
	addClientSubmit.click();
	waitutil.explicitWait(driver,clientNameAfterSave,30);
	}
	}
	public String verifyClientAdded()
	{
	String clientNameSaved= clientNameAfterSave.getText();
	if(clientNameSaved.isBlank())
	{
		waitutil.implicitWait(driver, 30);
	}
	System.out.println(clientNameSaved);
	return clientNameSaved;
	}
	public void closeCustomerWindow()
	{	closeModalDialog.click();
		waitutil.implicitWait(driver, 20);
	}
	public void searchClient()
	{
		//searchBox.click();
		searchBox.sendKeys(properties.getProperty("clientname"));
		searchBox.sendKeys(Keys.ENTER);		
		waitutil.implicitWait(driver, 40);
		waitutil.explicitWait(driver, tableCol, 30);
		System.out.println(searchResultTableCol.getText());
		}
	public void selectActionViewClient() throws Exception
	{if(actionDropdownViewClient.isEnabled())
		{
		actionDropdownViewClient.click();
		optionViewClient.click();
		waitutil.implicitWait(driver, 30);
		waitutil.explicitWait(driver, clientNameAfterSave, 10);
//	js.executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", actionDropdownViewClient, "View Client");
	}
		else
		{
			js.executeScript("arguments[0].scrollIntoView();",actionDropdownViewClient );
		}
	}
	public void selectActionEditClient() throws Exception
	{
		actionDropdownViewClient.click();
		optionEditClient.click();
		waitutil.explicitWait(driver, ClientName_EditClient, 20);
	}
public void editClientDetails()throws Exception
{
	city.sendKeys("Bangalore");
	uploadClientDetails();
	pageutil.scrollDowntillElement(driver,saveChangesClientButton);
	saveChangesClientButton.click();
	waitutil.implicitWait(driver, 30);
	waitutil.explicitWait(driver, clientCityAfterSave, 20);
}
public void uploadClientDetails()
{
	pageutil.uploadFile(uploadButton);
}
public void selectActionDeleteClient() throws Exception
{
	actionDropdownViewClient.click();
	OptionDeleteClient.click();
}
public void confirmAlert()
{
	String alertMsg= driver.switchTo().alert().getText();
	System.out.println(alertMsg);
	driver.switchTo().alert().accept();	
}
public boolean isAlertPresent()
{ boolean flag= false;
	WebDriverWait wait = new WebDriverWait(driver, null);
    if(wait.until(ExpectedConditions.alertIsPresent())==null)
    {
    	flag= false;
          System.out.println("alert was not present");
    }
    else
    {flag=true;
    System.out.println("alert was present and accepted");
    }
    return flag;
}
public void selectActionViewImage()
{
	actionDropdownViewClient.click();
	OptionViewImage.click();
}

public void closeViewImageModalDialog()
{
	okButton.click();
}
public void selectActionViewClientRepairs() throws Exception
{
	actionDropdownViewClient.click();
	OptionViewClientRepairs.click();
}

}

