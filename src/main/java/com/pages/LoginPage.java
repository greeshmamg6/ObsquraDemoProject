package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import com.base.AutomationBase;
import com.util.GenericUtil;
import com.util.PageUtil;
import com.util.WebUtil;

public class LoginPage extends AutomationBase {
WebDriver driver;
PageUtil pageutil= new PageUtil();
public LoginPage(WebDriver driver)
{this .driver=driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(name="identity")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="submit")
	WebElement loginButton;
	@FindBy(xpath="//div[@id='infoMessage']")
	public static WebElement errorMessage;
	@FindBy(xpath="//div[@class='alert alert-success']")
	public static WebElement successMessage;
	
	public void typeUserName(String uname)
		{
	if(driver.findElement(By.name("identity")).isDisplayed())
		{
		username.sendKeys(uname);
		}
		else
		{
			System.out.println("Username: Element not found");
		}
	}
	public void typePassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickLogin()
	{
		loginButton.click();
	}
	public boolean verifyLoginSuccess()
	{ 
		return pageutil.verifyElementPresent(errorMessage);		
	}		 
	 public HomePage validlogin(String uname, String pwd) {
	username.sendKeys(uname);
		password.sendKeys(pwd);
	loginButton.click();
		return new HomePage(driver);
	}
	public void closeTest(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		WebUtil webutil= new WebUtil();
		webutil.closeBrowser(driver);
		
	}
	
}
