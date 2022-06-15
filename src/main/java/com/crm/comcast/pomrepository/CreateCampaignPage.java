package com.crm.comcast.pomrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Webdriver_Utilities;

public class CreateCampaignPage extends Webdriver_Utilities{
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text' and @name='campaignname']")
	private WebElement campName;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement addProd;
	
	@FindBy(xpath = "//input[@type='text' and @name='search_text']")
	private WebElement searchTb;
	
	@FindBy(xpath = "//select[@name='search_field' and @class='txtBox']")
	private WebElement dropDown;
	
	@FindBy(xpath = "//input[@class='crmbutton small create' and @type='button']")
	private WebElement searchNowBtn;
	
	@FindBy(xpath = "//a[text()='laptop19']")
	private WebElement selectProd;
	
	


	public void   campName(String CampName)
	{
		campName.sendKeys(CampName);
	}
	
	
	public void clicksave()
	{
		saveBtn.click();
	}

	public void addProd()
	{
		
		addProd.click();
		switchToWindow(driver, "Products&action");
	}
	
	public void searchTb(String Prodname)
	{
		searchTb.sendKeys(Prodname);
	}
	
	public void selectDropDown() {
		select(dropDown, "Product Name");
	}
	public void serachNowBtn() {
		searchNowBtn.click();
	}
	public void selProd() {
		selectProd.click();
		switchToWindow(driver, "Campaigns&action");
	}

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCampName() {
		return campName;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getAddProd() {
		return addProd;
	}


	public WebElement getSearchTb() {
		return searchTb;
	}


	public WebElement getDropDown() {
		return dropDown;
	}


	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}


	public WebElement getSelectProd() {
		return selectProd;
	}
	
	
}
