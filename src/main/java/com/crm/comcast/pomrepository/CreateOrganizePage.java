package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizePage {
	WebDriver driver;
	public CreateOrganizePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void   orgName(String Name)
	{
		orgName.sendKeys(Name);
	}
	
	public void clicksave()
	{
		saveBtn.click();
	}

}
