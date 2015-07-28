package com.rcta.appium.ios.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Helper {
    private static IOSDriver driver;

    private static WebDriverWait driverWait;

    /**
     * Initialize the webdriver. Must be called before using any helper methods. *
     */
    public static void init(IOSDriver iosDriver) {
        driver = iosDriver;
        int timeoutInSeconds = 60;
        driverWait = new WebDriverWait(iosDriver, timeoutInSeconds);
    }

    public static MobileElement elementFound(String accessbilityId) {
        MobileElement uiCatalog = (MobileElement) driver.findElementByAccessibilityId(accessbilityId);
//        assertEquals("UICatalog",uiCatalog.getText());
        return uiCatalog;
    }

    /**
     * Press the back button *
     */
    public static void back() {
        driver.navigate().back();
    }

    public static MobileElement findByName(String name) {
        MobileElement element = (MobileElement) driver.findElementByName(name);
        return element;
    }

}
