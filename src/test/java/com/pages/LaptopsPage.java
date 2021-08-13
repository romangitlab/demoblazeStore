package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LaptopsPage extends BasePage<LaptopsPage> {

    @FindBy(how = How.CSS, using = ".btn.btn-success")
    public WebElement add_to_cart;

    public LaptopsPage() {
        super("/");
    }
}
