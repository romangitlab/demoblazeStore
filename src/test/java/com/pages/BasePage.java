package com.pages;

import com.helpers.WebElementHelper;
import com.setup.DriverFactory;
import com.setup.EnvProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T>  {

    private final String url;
    protected WebDriver driver;
    protected WebElementHelper elementHelper;

    protected BasePage(String pageURL) {
        this.url = pageURL;
        this.driver = DriverFactory.get().getDriver();
        this.elementHelper = new WebElementHelper(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void load() {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            driver.get(url);
        } else {
            driver.get(EnvProperties.BASE_URL + url);
        }
    }

    @Override
    protected void isLoaded() throws Error {
        if (!this.driver.getCurrentUrl().contains(url) && elementHelper.isPageReady()) {
            throw new Error(elementHelper.getCurrentUrl() + " is not loaded");
        }
    }

    public WebElementHelper getWebElementHelper(){
        return elementHelper;
    }

}
