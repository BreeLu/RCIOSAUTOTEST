package com.rcta.appium.ios.RCMobileScreen;

import io.appium.java_client.MobileElement;

import static com.rcta.appium.ios.util.Helper.*;

public abstract class LoginPage {
    //
    /**
     * check Logo  is exist
     * can the picture confirm that the loginPage has been loaded? todo
     *
     */
    public static MobileElement Logo() {
        return findByAccessibilityId("RCSPLoginLogo.png");
    }
    /**
     * check the page is loaded correctly
     */
    public static MobileElement loginPageLoaded() {
        return findByAccessibilityId("");
    }

    /**
     * check Login Button is exist
     */
    public static MobileElement LoginButton() {
        return findByAccessibilityId("Log In");
    }

    /**
     * find phone number input field
     */
    public static void getPhoneNumberFieldAndInput(String input) {
        findByAccessibilityId("Phone Number").click();
        sendKeysInKeyboard(input);
    }

    /**
     * find extension field
     */
    public static MobileElement extensionField() {
        return findByAccessibilityId("Extension");
    }

    /**
     * find password field
     */
    public static void getPasswordFieldAndInput(String input) {
        findByAccessibilityId("Password").click();
        sendKeysInKeyboard(input);
    }

    /**
     * below methods are belong to  acknowledge page
     * include check page title,decline button and accept button
     *
     */
    public static MobileElement acknowledgePageLoaded() {
        return findByName("Summary of Legal Terms");
    }

    public static MobileElement acknowledgeAcceptBtn() {
        return findByAccessibilityId("Accept");
    }

    public static MobileElement acknowledgeDeclineBtn() {
        return findByAccessibilityId("Decline");
    }

}
