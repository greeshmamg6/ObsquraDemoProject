package com.util;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtil {
	
	/**
	 * method to return table row count
	 * @return
	 * @throws Exception 
	 */
	public int getTableRowCount(WebDriver driver, List <WebElement> element) throws Exception {
		try {
			return element.size();
		}catch(Exception e) {
			throw new Exception("getTableRowCount (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to return table column count
	 * @throws Exception 
	 */
	public int getTableColumnCount(WebDriver driver, List <WebElement> element) throws Exception {
		try {
			return element.size();
		}catch(Exception e) {
			throw new Exception("getTableColumnCount (UtilityActionHelper) : "+e.getMessage());
		}
	}
	
	public String getTableContentOnRowAndColumn(WebDriver driver, String xpath) throws Exception {
		try {
			return driver.findElement(By.xpath(xpath)).getText();
		}catch (Exception e) {
			throw new Exception("getTableContentOnRowAndColumn (UtilityActionHelper) : "+e.getMessage());
		}
	}


public static void captureScreenShot(WebDriver driver, String ScreenShotName)
{
              try {
                                   File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                                   FileUtils.copyFile(screenshot,new File(""));
                       } catch (Exception e)
                         {
                             System.out.println(e.getMessage());
                              e.printStackTrace();
                          }
    }
public void selectDropDownByVisibleText(WebDriver driver, WebElement element, String visibleText) throws Exception 
{
	try { 
		if(element.isDisplayed()==true)
				{
			Select dropDown=new Select(element);
			dropDown.selectByValue(visibleText);
	}
		else 
		{
			System.out.println("View Action dropdown not found");
	}	
	}
	catch(Exception e) {
		throw new Exception("selectDropDownByVisibleText (UtilityActionHelper) : "+e.getMessage());
	}
}

}


