package com.yptech.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.yptech.web.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void loginBtnExistTest() {
		Assert.assertTrue(loginPage.isLoginBtnExist());
	}
	
	@Test(priority = 3)
	public void loginUsersListTest() {
		SoftAssert softAssert = new SoftAssert();
		String credentialsText = loginPage.getUsernamesList();

		softAssert.assertTrue(
		    credentialsText.contains("standard_user"),
		    "standard_user is not present in the login credentials section"
		);

		softAssert.assertTrue(
		    credentialsText.contains("visual_user"),
		    "visual_user is not present in the login credentials section"
		);

		// This is mandatory to report all soft assertion results
		softAssert.assertAll();
	}
	
	@Test(priority = 4)
	public void presenceOfLoginPasswordTest() {
		String passwordFromLoginPage = loginPage.getLoginPassword();
		//Assert.assertTrue(passwordFromLoginPage.contains("secret_sauce"));
		Assert.assertTrue(passwordFromLoginPage.contains(props.getProperty(AppConstants.PASSWORD)));
	}
	
	@Test(priority = 5)
	public void loginTest() {
		//loginPage.doLogin("standard_user", "secret_sauce");
		loginPage.doLogin(props.getProperty(AppConstants.USER_NAME), props.getProperty(AppConstants.PASSWORD));
	}
}
