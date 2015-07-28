package com.rcta.appium.ios.screen;

import static com.rcta.appium.ios.util.Helper.elementFound;
import io.appium.java_client.MobileElement;

public abstract class ButtonsPage {
    public static MobileElement buttonsPageLoaded() {
        return elementFound("Buttons");
    }
}
