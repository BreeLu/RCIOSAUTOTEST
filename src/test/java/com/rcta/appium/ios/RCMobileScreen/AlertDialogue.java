package com.rcta.appium.ios.RCMobileScreen;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Alert;

import static com.rcta.appium.ios.util.Helper.findByAccessibilityId;
import static com.rcta.appium.ios.util.Helper.findAlerDialogue;

/**
 * Created by bree.lu on 7/30/15.
 */
public abstract class AlertDialogue {
    public static Alert alertDialogue() {
       return findAlerDialogue();
    }

    public static MobileElement cancelButton() {
        return findByAccessibilityId("");
    }

    public static MobileElement confirmButton() {
        return findByAccessibilityId("");
    }

    public static MobileElement title() {
        return findByAccessibilityId("");
    }

    public static MobileElement alertInfo() {
        return findByAccessibilityId("");
    }
}
