package com.yptech.web.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class BrowserOptionsManager {

    private Properties props;

    public BrowserOptionsManager(Properties props) {
        this.props = props;
    }

    public AbstractDriverOptions<?> getBrowserOptions(String browserName) {

        boolean isHeadless = Boolean.parseBoolean(props.getProperty("headless").trim());
        boolean isIncognito = Boolean.parseBoolean(props.getProperty("incognito").trim());

        switch (browserName.trim().toLowerCase()) {

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (isHeadless) firefoxOptions.addArguments("--headless");
                if (isIncognito) firefoxOptions.addArguments("--incognito");

                return firefoxOptions;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();

                if (isHeadless) edgeOptions.addArguments("--headless");
                if (isIncognito) edgeOptions.addArguments("--incognito");

                return edgeOptions;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();

                if (isHeadless) chromeOptions.addArguments("--headless");
                if (isIncognito) chromeOptions.addArguments("--incognito");

                return chromeOptions;
        }
    }
}