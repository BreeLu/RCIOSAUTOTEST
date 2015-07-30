package com.rcta.appium.ios.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Alert;
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

    /**
     * Press the back button *
     */
    public static void back() {
        driver.navigate().back();
    }

    /**
     * set wait time to get Expected element appear
     *
     * **/
    public static void waitForElementAppear(long millionSec) {
        try {
            new Thread().sleep(millionSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * below methods all about locating element
     * include byName/byAccessibilityId/byXPath
     * will supply it later
     * **/

    public static MobileElement findByAccessibilityId(String accessbilityId) {
        MobileElement mobileElement = (MobileElement) driver.findElementByAccessibilityId(accessbilityId);
        return mobileElement;
    }

    public static MobileElement findByName(String name) {
        MobileElement element = (MobileElement) driver.findElementByName(name);
        return element;
    }

    public static MobileElement findByXPath(String xpath) {
        return (MobileElement) driver.findElementByXPath(xpath);
    }

    /**
     *
     * Alert Dialogue
     *
     *
     * **/
    public static Alert findAlerDialogue() {
        return driver.switchTo().alert();
    }

    /**
     * tap on keyboard
     * **/
    public static void sendKeysInKeyboard(String inputString) {
        driver.getKeyboard().sendKeys(inputString);
    }



}
