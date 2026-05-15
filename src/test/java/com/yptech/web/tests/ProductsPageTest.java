package com.yptech.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.yptech.web.constants.AppConstants;

public class ProductsPageTest extends BaseTest{

	@BeforeClass
	public void productsPageSetup() {
		props = factory.initProperties();
		productsPage = loginPage.doLogin(props.getProperty(AppConstants.USER_NAME), props.getProperty(AppConstants.PASSWORD));
	}
	
	@Test
	public void productsPageURLTest() {
		Assert.assertTrue(productsPage.getProductsPageURL().contains(AppConstants.PRODUCTS_PAGE_URL_PATH));
	}
	
	@Test
	public void productsPageCartItemsCountTest() {
		String actualCount = productsPage.addItemsToCart();
		Assert.assertEquals(actualCount, AppConstants.DIGIT_TWO_STR);
	}
}
