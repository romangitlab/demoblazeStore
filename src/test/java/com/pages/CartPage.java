package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage<CartPage> {

    @FindBy(how = How.CSS, using = "#tbodyid>tr:nth-child(2)>td:nth-child(4)>a")
    public WebElement btn_delete_dell_i7_8gb;

    @FindBy(how = How.CSS, using = ".btn.btn-success")
    public WebElement btn_place_order;

    @FindBy(how = How.ID, using = "name")
    public WebElement name;

    @FindBy(how = How.ID, using = "country")
    public WebElement country;

    @FindBy(how = How.ID, using = "city")
    public WebElement city;

    @FindBy(how = How.ID, using = "card")
    public WebElement card;

    @FindBy(how = How.ID, using = "month")
    public WebElement month;

    @FindBy(how = How.ID, using = "year")
    public WebElement year;

    @FindBy(how = How.ID, using = "totalp")
    public WebElement totalp;

    @FindBy(how = How.XPATH, using = "//*[@onclick=\"purchaseOrder()\"]")
    public WebElement btn_purchaseOrder;

    @FindBy(how = How.CSS, using = "p.lead")
    public WebElement field_id;

    @FindBy(how = How.CSS, using = ".confirm")
    public WebElement btn_confirm ;

    public CartPage() {
        super("/cart.html");
    }
}
