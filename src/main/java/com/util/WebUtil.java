package com.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.base.AutomationBase;
import com.constants.AutomationConstants;

public class WebUtil extends AutomationBase{
	
	public void launchURL(WebDriver driver, String url) {
		System.out.println(AutomationConstants.APPLICATION_URL + url);
		driver.get(url);
		}

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public String getCurrentUrl(WebDriver driver) throws Exception 
	{
		String currentURL = "";
		try {
			currentURL = driver.getCurrentUrl();
		} 
		catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
		return currentURL;
	}
	public String getWebPageTitle(WebDriver driver) throws Exception
	{
		String title = "";
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
		return title;
	}
	public void refreshBrowser(WebDriver driver) throws Exception {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	public void quitBrowser(WebDriver driver) throws Exception {
		try {
		driver.quit();
		} catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	public void navigateBack(WebDriver driver) throws Exception {
		try {
		driver.navigate().back();
		}
		catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	public void closeBrowser(WebDriver driver) throws Exception {
		try {
		driver.close();
	} catch (Exception e) {
		System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
		System.out.println(AutomationConstants.CAUSE + e.getCause());
	}
	}
}

