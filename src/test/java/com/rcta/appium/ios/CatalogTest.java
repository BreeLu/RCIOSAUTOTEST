package com.rcta.appium.ios;

import static com.rcta.appium.ios.screen.AlertsPage.alertsPageLoaded;
import static com.rcta.appium.ios.screen.ButtonsPage.buttonsPageLoaded;
import static com.rcta.appium.ios.screen.HomePage.welcomePageLoaded;
import com.rcta.appium.ios.util.AppiumTestBase;
import static com.rcta.appium.ios.util.Helper.back;
import io.appium.java_client.MobileElement;
import org.junit.Test;

public class CatalogTest extends AppiumTestBase {
    @Test
    public void buttonPageTest() {
        welcomePageLoaded();
        back();

        MobileElement buttonsPage = buttonsPageLoaded();
        buttonsPage.click();
    }

    @Test
    public void AlertPageTest() {
        welcomePageLoaded();
        back();
        MobileElement alertPage = alertsPageLoaded();
        alertPage.click();
//        findByName("Simple").click();
//        System.out.println("[INFO]Simple alert pop up now");
//        findByName("OK").click();
    }
}
