package com.steps;

import com.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CartPageSteps {

    static final Logger logger = Logger.getLogger(CartPageSteps.class);

    private final CartPage cartPage = new CartPage();
    String total;
    String[] fields;

    @And("I navigate to Cart")
    public void iNavigateToCart() {
        cartPage.get();
    }

    @And("I delete Dell i7 8gb from cart")
    public void iDeleteDellIGbFromCart() {
        cartPage.getWebElementHelper().waitAndClickElement(cartPage.btn_delete_dell_i7_8gb);
        cartPage.getWebElementHelper().waitForInvisibilityOfElementLocated("//*[@src=\"imgs/dell.jpg\"]");
    }

    @And("I click on Place order")
    public void iClickOnPlaceOrder() {
        cartPage.getWebElementHelper().waitAndClickElement(cartPage.btn_place_order);
    }

    @And("I fill in all web form fields")
    public void iFillInAllWebFormFields() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        cartPage.getWebElementHelper().waitAndClickElement(cartPage.name);
        cartPage.getWebElementHelper().type(cartPage.name, RandomStringUtils.randomAlphabetic(5));

        cartPage.getWebElementHelper().waitAndClickElement(cartPage.country);
        cartPage.getWebElementHelper().type(cartPage.country, RandomStringUtils.randomAlphabetic(5));

        cartPage.getWebElementHelper().waitAndClickElement(cartPage.city);
        cartPage.getWebElementHelper().type(cartPage.city, RandomStringUtils.randomAlphabetic(5));

        cartPage.getWebElementHelper().waitAndClickElement(cartPage.card);
        cartPage.getWebElementHelper().type(cartPage.card, UUID.randomUUID().toString());

        cartPage.getWebElementHelper().waitAndClickElement(cartPage.month);
        cartPage.getWebElementHelper().type(cartPage.month, String.valueOf(cal.get(Calendar.MONTH)));

        cartPage.getWebElementHelper().waitAndClickElement(cartPage.year);
        cartPage.getWebElementHelper().type(cartPage.year, String.valueOf(cal.get(Calendar.YEAR)));
    }

    @And("I click on Purchase")
    public void iClickOnPurchase() {
        total = cartPage.getWebElementHelper().waitForElementToBeVisible(cartPage.totalp).getText();
        cartPage.getWebElementHelper().waitAndClickElement(cartPage.btn_purchaseOrder);
    }

    @And("I click on Ok")
    public void iClickOnOk() {

        fields = cartPage.getWebElementHelper().waitForElementToBeVisible(cartPage.field_id).getText().split("\n");
        logger.info("Purchase " + fields[0]);
        logger.info("Purchase " + fields[1]);

        cartPage.getWebElementHelper().waitAndClickElement(cartPage.btn_confirm);
    }

    @Then("I assert purchase amount equals expected")
    public void iAssertPurchaseAmountEqualsExpected() {

        assertThat(fields[1], containsString(total));
    }
}