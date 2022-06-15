package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	WebDriver driver;
	public CreateProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@type='text' and @name='productname']")
	private WebElement prodName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void   prodName(String ProdName)
	{
		prodName.sendKeys(ProdName);
	}
	
	public void clicksave()
	{
		saveBtn.click();
	}

}
