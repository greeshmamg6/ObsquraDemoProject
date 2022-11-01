package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.AutomationBase;
import com.constants.AutomationConstants;

public class PageUtil{
	/**
	 * This method is used to verify if an element is present on a page.
	 * @param element
	 * @return
	 */
	public boolean verifyElementPresent(WebElement element)
	{ 
		boolean flag= false;
		try {
			if (element.isDisplayed()== true)
				flag= true;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
		return flag;
	}
	/**
	 * This method is used to enter value for any field.
	 * @param element
	 * @param value
	 */
	public void typeValue(WebElement element,String value)
	{
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
		
	}
	/**
	 * This method is used to check if any alert is present on the page.
	 * @param element
	 * @param value
	 */
	public boolean isAlertPresent(WebDriver driver) 
	{  WebDriverWait w=new WebDriverWait(driver, null);
	boolean flag=false;
		try {
			
			if(w.until(ExpectedConditions.alertIsPresent())==null)
			   {
				   flag=true;
			   }
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
		return flag;
	} 
	/**
	 * This method is used to check confirm any alert present on the page.
	 * @param element
	 * @param value
	 */
	public void confirmAlert(WebDriver driver)
	{
		 driver.switchTo().alert().accept();; 
	}
	public void clickElement(WebDriver driver, WebElement element) {
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
		System.out.println(AutomationConstants.CAUSE + e.getCause());
	}
	}
	/**
	 * This method is used to scroll down till the element on the page.
	 * @param element
	 * @param value
	 */
	public void scrollDowntillElement(WebDriver driver, WebElement element)
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,1000)");
			js.executeScript("arguments[0].scrollIntoView(true);",element );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	/**
	 * This method is used to scroll down till the given coordinates on the page.
	 * @param element
	 * @param value
	 */
	public void scrollDownAxis(WebDriver driver, int x, int y)
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
		
	}
	/**
	 * This method is used to upload a file.
	 * @param element
	 * @param value
	 */
public void uploadFile(WebElement element)
{
	try {
		element.click();
		element.sendKeys("Desktop\\Test.doc");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
		System.out.println(AutomationConstants.CAUSE + e.getCause());
	}
}
}
