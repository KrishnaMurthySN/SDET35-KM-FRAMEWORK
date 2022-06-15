package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic_utilities.Webdriver_Utilities;
/**
 *  Home Page WebElements
 * @author Krishna
 */

public class HomePage extends Webdriver_Utilities{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement mOver;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logOut;
	
	
	
	public void orgLink() {
		orgLink.click();
	}
	
	public void contactLink() {
		contactLink.click();
	}

	public void productLink() {
		productLink.click();
	}
	
	
	
	public void campaignLink() {
		mouseHover(driver, moreLink);
		waitForElement(driver, campaignLink);
		campaignLink.click();
	}
	
	
	public void vendorLink() {
		mouseHover(driver, moreLink);
		waitForElement(driver, vendorLink);
		vendorLink.click();
	}
	
	public void purchaseOrderLink() {
		mouseHover(driver, moreLink);
		waitForElement(driver, purchaseOrderLink);
		purchaseOrderLink.click();
	}
	public void mouseOvering() {
		mouseHover(driver, mOver);
	}
	public void clickLogout() {
		logOut.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getVendorLink() {
		return vendorLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getmOver() {
		return mOver;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	
	
	
}


