package com.yptech.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.yptech.web.constants.AppConstants;
import com.yptech.web.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	// private Wait<WebDriver> wait;
	private ElementUtil elementUtil;

	// 1. Private locators
	private By userNameLocator = By.xpath("//input[@id='user-name']");
	private By passwordLocator = By.xpath("//input[@id='password']");
	private By pwdPara = By.xpath("//div[@class='login_password']");
	private By unPara = By.xpath("//div[@id='login_credentials']");
	private By loginBtn = By.xpath("//input[@id='login-button']");

	// 2. Public constructor with driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. Page actions
	public String getLoginPageTitle() {
		String title = elementUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.PAGE_TITLE);
		System.out.println("Page title is : " + title);
		return title;
	}

	public boolean isLoginBtnExist() {
		return elementUtil.doElementIsDisplayed(loginBtn);
	}

	public String getUsernamesList() {
		return elementUtil.waitForElementVisible(unPara, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
	}

	public String getLoginPassword() {
		return elementUtil.waitForElementVisible(pwdPara, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
	}

	public ProductsPage doLogin(String userName, String password) {
		elementUtil.doSendKeys(userNameLocator, userName);
		elementUtil.doSendKeys(passwordLocator, password);
		elementUtil.doClick(loginBtn);

		return new ProductsPage(driver);
	}
}
