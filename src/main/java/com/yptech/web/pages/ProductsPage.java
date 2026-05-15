package com.yptech.web.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.yptech.web.constants.AppConstants;

public class ProductsPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;
	
	//1. Locators
	private By addBackPack = By.id("add-to-cart-sauce-labs-backpack");
	private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
	private By goToCart = By.xpath("//a[@data-test='shopping-cart-link']");
	private By itemsCount = By.xpath("//span[@data-test='shopping-cart-badge']");
	
	//2. Constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new FluentWait<>(driver)
		          .withTimeout(Duration.ofSeconds(AppConstants.NUMBER_TEN))
		          .pollingEvery(Duration.ofSeconds(AppConstants.DIGIT_TWO_NUM));
	}
	
	
	
	//3. Page Actions
	public String getProductsPageURL() {
		return driver.getCurrentUrl();
	}
	
	public String addItemsToCart() {
		WebElement backPack = wait.until(ExpectedConditions.elementToBeClickable(addBackPack));
		backPack.click();
		driver.findElement(addBikeLight).click();
		return driver.findElement(itemsCount).getText();
	}
	
	public void goToCartPage() {
		driver.findElement(goToCart).click();
	}
}
