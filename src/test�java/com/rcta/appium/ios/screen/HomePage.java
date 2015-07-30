package com.rcta.appium.ios.screen;

import static com.rcta.appium.ios.util.Helper.findByAccessibilityId;
import io.appium.java_client.MobileElement;

public abstract class HomePage {
    public static MobileElement welcomePageLoaded() {
        return findByAccessibilityId("UICatalog");
    }
}
