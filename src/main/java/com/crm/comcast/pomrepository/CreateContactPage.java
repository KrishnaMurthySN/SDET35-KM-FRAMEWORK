package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
	
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnTb;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	public WebElement getLastnTb() {
		return lastnTb;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void lastname(String lname)
	{
		lastnTb.sendKeys(lname);
	}
	
	public void clicksave()
	{
		saveBtn.click();
	}

}
