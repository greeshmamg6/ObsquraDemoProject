package com.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.AutomationConstants;

public class WaitUtil {
	public void implicitWait(WebDriver driver, int timeOut) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	
	public void scriptTimeOut(WebDriver driver, int timeOut) {
		try {
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeOut));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }
	    catch(Exception e) 
	    {
	    	System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
	    	System.out.println(AutomationConstants.CAUSE + e.getCause());
	    }
	}
	    
	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
}
