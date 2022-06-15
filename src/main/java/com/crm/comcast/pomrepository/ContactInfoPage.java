package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Webdriver_Utilities;


public class ContactInfoPage extends Webdriver_Utilities{
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Information')]")
	private WebElement cInfo;
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;
	
	
	

	
	
	public void deleteBtn() {
		deleteBtn.click();
	}
	

	public WebElement getcInfo() {
		return cInfo;
	}


	public WebDriver getDriver() {
		return driver;
	}

	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	
	
}
