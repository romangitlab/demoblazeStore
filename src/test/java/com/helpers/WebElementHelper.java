package com.helpers;

import com.setup.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.setup.EnvProperties.DEFAULT_TIMEOUT;

public class WebElementHelper {

    static final Logger logger = Logger.getLogger(WebElementHelper.class);

    private WebDriver driver;
    protected WebDriverWait wait;

    public WebElementHelper(WebDriver driver) {
        this.driver = DriverFactory.get().getDriver();
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public WebDriverWait getWebDriverWait() {
        return wait;
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isPageReady() {
        try {
            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    public void switchAndAcceptAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println(e);
        }
    }

    public void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void waitAndClickElement(WebElement element) {
        try {
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            if (elementPresent == true && element.isDisplayed()) {
                element.click();
            }
        } catch (StaleElementReferenceException elementUpdated) {
            try {
                wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
            } catch (ElementNotVisibleException e) {
                System.out.println(String.format("Couldn't display element \"%S\"!", element));
            }
            element.click();
        }
    }

    public Boolean waitForElementToBeClickable(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (ElementNotInteractableException e) {
            System.out.println(String.format("Couldn't click on element \"%S\"!", webElement));
        }

        return true;
    }

    public Boolean waitForInvisibilityOfElementLocated(String path) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
        } catch (ElementNotInteractableException e) {
            System.out.println(String.format("Couldn't click on element \"%S\"!", path));
        }

        return true;
    }

    public WebElement waitForElementToBeVisible(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (ElementNotInteractableException e) {
            System.out.println(String.format("Couldn't click on element \"%S\"!", webElement));
        }

        return webElement;
    }
}
