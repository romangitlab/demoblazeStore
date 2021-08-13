package com.steps;

import com.pages.LaptopsPage;
import com.pages.MainPage;
import io.cucumber.java.en.And;

public class LaptopsPageSteps {

    private final MainPage mainPage = new MainPage();
    private final LaptopsPage laptopPage = new LaptopsPage();

    @And("I click on Add to cart")
    public void iClickOnAddToCart() throws InterruptedException {
        laptopPage.getWebElementHelper().waitAndClickElement(laptopPage.add_to_cart);
    }

    @And("I accept pop up confirmation")
    public void iAcceptPopUpConfirmation() {
        laptopPage.getWebElementHelper().switchAndAcceptAlert();
    }
}
