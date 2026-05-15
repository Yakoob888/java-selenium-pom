package com.yptech.web.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties props;
	public BrowserOptionsManager optionsManager;
	
	public WebDriver initDriver(Properties prop) {
		System.out.println("********* ENTERED INTO DRIVER FACTORY CLASS *********");
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		System.out.println("The browser name you passed is : " +browserName);
		
		optionsManager = new BrowserOptionsManager(prop);
        AbstractDriverOptions<?> options = optionsManager.getBrowserOptions(browserName);
        
		switch(browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver((ChromeOptions) options);
			break;
			
		case "firefox":
			driver = new FirefoxDriver((FirefoxOptions) options);
			break;
			
		case "edge":
			driver = new EdgeDriver((EdgeOptions) options);
			break;
			
		default:
			System.out.println("Invalid browsername entered : "+browserName +" hence opening in a default browser CHROME..");
			driver = new ChromeDriver((ChromeOptions) options);
			break;
		}
		
		
		//driver.manage().window().maximize();
		 if (!Boolean.parseBoolean(prop.getProperty("headless").trim())) {
	            driver.manage().window().maximize();
	        }
		driver.manage().deleteAllCookies();
		//driver.get("https://www.saucedemo.com/");
		driver.get(url);
		return driver;
	}
	
	public Properties initProperties() {
		props = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("./src/test/resources/configurations/config.properties");
			props.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}

}
