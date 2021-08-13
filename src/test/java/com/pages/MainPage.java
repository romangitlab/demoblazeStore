package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage<MainPage> {

    @FindBy(how = How.XPATH, using = "//*[@href=\"prod.html?idp_=8\"]")
    public WebElement notebook_sony_vaio_i5;

    @FindBy(how = How.XPATH, using = "//*[@href=\"prod.html?idp_=12\"]")
    public WebElement notebook_dell_i7_8gb;

    @FindBy(how = How.XPATH, using = "//*[@onclick=\"byCat('notebook')\"]")
    public WebElement notebook;

    public MainPage() {
        super("/index.html");
    }
}
