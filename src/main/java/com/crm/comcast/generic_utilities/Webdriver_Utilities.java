package com.crm.comcast.generic_utilities;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utilities 
{
	/**
	 *   contains all reusable Actions of Webdriver 
	 * @author Krishna
	 *
	 */
		public void implicitWait(WebDriver driver) 
		{
			
			/**
			 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
			 * 
			 */

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		
		/**
		 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
		 */
			public void explicitWait(WebDriver driver , String partialPageURL) 
			{
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.urlContains(partialPageURL));
			}	
		
		/**
		 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
		 */
			public void waitForElement(WebDriver driver , WebElement element) 
			{
				WebDriverWait wait = new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
		
		
		/**
		 *  used to Switch to Any Window based on Window Title
		
		 */
		public void switchToWindow(WebDriver driver , String partialWindowTitle) 
		{
		       Set<String> set = driver.getWindowHandles();
		         Iterator<String> it = set.iterator();

		          while (it.hasNext()) 
		          {
				          String wID = it.next();
				          driver.switchTo().window(wID);
				          String currentWindowTitle = driver.getTitle();
				          if(currentWindowTitle.contains(partialWindowTitle)) 
				          {
				        	  break;
				          }
			    	}
		}
		
		/**
		 * used to Switch to Alert Window & click on OK button
		 */
		public void switchToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg)
		{
			Alert alt = driver.switchTo().alert();
			 if(alt.getText().equalsIgnoreCase(expectedMsg.trim())) 
			 {
				 System.out.println("Alert Message is verified");
			 }
			 else 
			 {
				 System.out.println("Alert Message is not verified");
			 }
			 	alt.accept();
		}
		
		
		/**
		 * used to Switch to Alert Window & click on Cancel button
		 */
		//public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) 
		public void swithToAlertWindowAndCancel(WebDriver driver) 
		{
			Alert alt = driver.switchTo().alert();
//			 if(alt.getText().equals(expectedMsg)) 
//			 {
//				 System.out.println("Alert Message is verified");
//			 }
//			 else 
//			 {
//				 System.out.println("Alert Message is not verified");
//			 }
			 	alt.dismiss();
		}
		
		/**
		 * used to Switch to Frame Window based on index
		 */
		public void swithToFrame(WebDriver driver , int index) 
		{
			driver.switchTo().frame(index);
		}
		
		/**
		 * used to Switch to Frame Window based on id or name attribute
		 */
		public void swithToFrame(WebDriver driver , String id_name_attribute) 
		{
			driver.switchTo().frame(id_name_attribute);
		}
		
		/**
		 * used to select the value from the dropDwon  based on index
		 */
		public void select(WebElement element , int index) 
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		/**
		 * used to select the value from the dropDwon  based on value / option avlaible in GUI
		 */
		public void select(WebElement element , String text) 
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		
		/**
		 * used to place mouse cursor on specified element
		 */
		public void mouseHover(WebDriver driver , WebElement elemnet)
		{
			Actions act = new Actions(driver);
			act.moveToElement(elemnet).perform();
		}
		
		/**
		 * 	 used to right click  on specified element
		 */
		public void rightClickOnElement(WebDriver driver , WebElement elemnet)
		{
			Actions act = new Actions(driver);
			act.contextClick(elemnet).perform();
		}
		
		
		/*
		 * To scroll the page
		 * 
		 */
		public void scrollBy(WebDriver driver)
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
		}
}
		
		
		
		