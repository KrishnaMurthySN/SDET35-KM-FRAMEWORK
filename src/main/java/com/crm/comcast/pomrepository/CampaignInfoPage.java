package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	WebDriver driver;
	public CampaignInfoPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement verifyCampaign;
	
	@FindBy(className = "dvHeaderText")
	private WebElement verifyCampaignWithProd;
	
	
	
		
//	    public void verifyCampaignWithProd(String campaignWithProd) {
//		
//		String actualSuccessfulMsg = verifyCampaignWithProd.getText();
//		if(actualSuccessfulMsg.contains(campaignWithProd))
//		{
//			System.out.println("PASS:campaign with product name is successfully entered");
//		}
//		else
//		{
//			System.out.println("FAIL:campaign with product name is not entered");
//		}
//		
//		
//		
//		
//
//	}

		public WebElement getVerifyCampaign() {
			return verifyCampaign;
		}

		public WebElement getVerifyCampaignWithProd() {
			return verifyCampaignWithProd;
		}

}
