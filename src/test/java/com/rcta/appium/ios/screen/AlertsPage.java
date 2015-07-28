package com.rcta.appium.ios.screen;

import static com.rcta.appium.ios.util.Helper.elementFound;
import io.appium.java_client.MobileElement;

public abstract class AlertsPage {
    public static MobileElement alertsPageLoaded() {
        return elementFound("Alert Controller");
    }

}
