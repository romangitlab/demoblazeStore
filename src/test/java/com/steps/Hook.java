package com.steps;

import com.setup.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Hook {

    static final Logger logger = Logger.getLogger(Hook.class);

    private WebDriver driver;

    @Before
    public void setUp() {
        logger.info("Starting the browser");

        DriverFactory.get().startBrowser();
        this.driver = DriverFactory.get().getDriver();
    }

    @After
    public void tearDown() {
        logger.info("Closing the browser");
    }
}
