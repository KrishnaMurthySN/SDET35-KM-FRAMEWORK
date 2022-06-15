package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizeInfoPage {
	WebDriver driver;
	public OrganizeInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className ="dvHeaderText")
	private WebElement orgInfo;

	
	

	public WebElement getOrgInfo() {
		return orgInfo;
	}




	public WebDriver getDriver() {
		return driver;
	}


	
	
	
}
