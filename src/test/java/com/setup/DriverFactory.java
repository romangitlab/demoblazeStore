package com.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;

public class DriverFactory {

    protected WebDriver driver = null;

    public static DriverFactory get() {
        return DriverBaseHolder.INSTANCE;
    }

    private static class DriverBaseHolder {
        static final DriverFactory INSTANCE = new DriverFactory();
    }


    public void startBrowser() {
        if (getBrowser().toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        } else if (getBrowser().toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            throw new IllegalStateException("This browser isn't supported !");
        }

        if(!getDriver().equals(null)) getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private String getBrowser() {
        return System.getProperty("browser", BrowserType.CHROME);
    }
}
