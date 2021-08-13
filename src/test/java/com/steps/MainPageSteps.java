package com.steps;

import com.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();

    @Given("I open home page")
    public void iOpenHomePage() {
        final String expectedUrl = "https://www.demoblaze.com/index.html";
        mainPage.get();

        assertThat(mainPage.getWebElementHelper().getCurrentUrl(), equalTo(expectedUrl));
    }

    @When("I navigate to Laptop")
    public void iNavigateToLaptop() {
        mainPage.get();
        mainPage.getWebElementHelper().waitAndClickElement(mainPage.notebook);
    }

    @And("I open Sony vaio i5")
    public void iOpenSonyVaioI() {
        final String expectedUrl = "prod.html?idp_=8";

        mainPage.getWebElementHelper().waitAndClickElement(mainPage.notebook_sony_vaio_i5);
    }

    @And("I open Dell i7 8gb")
    public void iOpenDellIGb() {
        final String expectedUrl = "prod.html?idp_=12";

        mainPage.getWebElementHelper().waitAndClickElement(mainPage.notebook_dell_i7_8gb);

        assertThat(mainPage.getWebElementHelper().getCurrentUrl(), containsString(expectedUrl));
    }
}
