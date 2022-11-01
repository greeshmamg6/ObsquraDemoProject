package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.constants.AutomationConstants;
import com.util.PropertyUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationBase {
	public WebDriver driver;
	PropertyUtil propertyutil = new PropertyUtil();

	/**
	 * This method is used to launch Browser based on the input provided.
	 * 
	 * @param browserName
	 * @return driver
	 */
	public WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			launchChromeBrowser();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			launchFirefoxBrowser();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			launchEdgeBrowser();
		} else if(browserName.equalsIgnoreCase("safari")) {
			launchSafariBrowser();
			} else{
			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
		}
		return driver;
	}

	/**
	 * This method is used to launch Chrome browser.
	 */
	private void launchChromeBrowser() {
		System.out.println("Launching Chrome Browser");
		System.out.println("========================");
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
/**
 *  This method is used to launch Mozilla Firefox browser.
 */
	private void launchFirefoxBrowser() {
		try {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
/**
 *  This method is used to launch Edge browser.
 */
	private void launchEdgeBrowser() {
		try {
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
		} catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	/**
	 *  This method is used to launch Safari browser.
	 */
	private void launchSafariBrowser() {
		try {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} catch (Exception e) {
			System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
			System.out.println(AutomationConstants.CAUSE + e.getCause());
		}
	}
	/**
	 * This method is used to return the current driver
	 * @return
	 */
	public WebDriver getDriver() {
		return this.driver;
	}
}
