package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrganizePage {
	WebDriver driver;
	public AddOrganizePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addOrganize;

	


	public WebElement getAddOrganize() {
		return addOrganize;
	}




	public void addOrganize()
	{
		addOrganize.click();
	}
}
