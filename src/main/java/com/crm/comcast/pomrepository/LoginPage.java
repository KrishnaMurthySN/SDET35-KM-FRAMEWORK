package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *  Login Page WebElements
 * @author Krishna
 */

public class LoginPage {
WebDriver driver;
	@FindBy(name="user_name")
	private WebElement  usernameTb;
	
	@FindBy(name="user_password")
	private WebElement passwordTb;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameTb() {
		return usernameTb;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	public void login(String username,String password) {
		usernameTb.sendKeys(username);
		passwordTb.sendKeys(password);
		submitBtn.click();
	}
	}
