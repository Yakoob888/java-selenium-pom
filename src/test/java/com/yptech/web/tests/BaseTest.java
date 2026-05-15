package com.yptech.web.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.yptech.web.factory.DriverFactory;
import com.yptech.web.pages.LoginPage;
import com.yptech.web.pages.ProductsPage;

public class BaseTest {
	
	DriverFactory factory;
	WebDriver driver;
	protected Properties props;
	protected LoginPage loginPage;
	protected ProductsPage productsPage;
	
	@BeforeClass
	//@Parameters({"browserName"})
	public void setup(/* String browserName */) {
		factory = new DriverFactory();
		props = factory.initProperties();
		driver = factory.initDriver(props);
		loginPage = new LoginPage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
