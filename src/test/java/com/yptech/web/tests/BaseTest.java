package com.yptech.web.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.yptech.web.factory.DriverFactory;
import com.yptech.web.pages.LoginPage;
import com.yptech.web.pages.ProductsPage;

public class BaseTest {
	
	DriverFactory factory;
	WebDriver driver;
	protected Properties props;
	protected LoginPage loginPage;
	protected ProductsPage productsPage;
	
	@BeforeTest
	//@Parameters({"browserName"})
	public void setup(/* String browserName */) {
		factory = new DriverFactory();
		props = factory.initProperties();
		driver = factory.initDriver(props);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
