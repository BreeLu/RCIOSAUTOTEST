package com.rcta.appium.ios.util;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


public class AppiumTestBase implements SauceOnDemandSessionIdProvider {

    public static String UDID_XME0453 = "7211b9754480c6ad07744002a1f832f78d57933e";
    public static String PLATFORM_VERSION = "8.4";
    public static String DEVICE_NAME = "iPhone 6";
    public static String APPIUM_VERSION = "1.4.8";

    static {
//        option1();
        option2();
    }

    private static void option1() {
        PLATFORM_VERSION = "8.4";
        DEVICE_NAME = "iPhone 6";
        APPIUM_VERSION = "1.4.8";
    }

    private static void option2() {
        PLATFORM_VERSION = "7.0.4";
        DEVICE_NAME = "iPhone 5s";
        APPIUM_VERSION = "1.4.8";
    }

    private IOSDriver iosDriver;

    private String sessionId;

    public static final String DEFAULT_WD_HUB_URL = "http://127.0.0.1:4723/wd/hub";


    final private String USERNAME = System.getenv("SAUCE_USERNAME");

    final private String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

    private SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME, ACCESS_KEY);

    private boolean runOnSauce = System.getProperty("sauce") != null;

    public String getSessionId() {
        return sessionId;
    }

    public
    @Rule
    TestName name = new TestName();

    @Before
    public void setup() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        desiredCapabilities.setCapability("appiumVersion", APPIUM_VERSION);
        desiredCapabilities.setCapability("name", name.getMethodName());
        URL sauceUrl = null;

        String userDir = System.getProperty("user.dir");
//        String localApp = "UICatalog.app";
        String localApp = "RCMobile_7.4_release_7.4.0.1.17_XIA_UP_Development.ipa";

        if (runOnSauce) {
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "http://appium.s3.amazonaws.com/TestApp6.0.app.zip");
            try {
                sauceUrl = new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() +
                        "@ondemand.saucelabs.com:80/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            iosDriver = new IOSDriver(sauceUrl, desiredCapabilities);
            iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            sessionId = iosDriver.getSessionId().toString();
        } else {
            String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
            desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
            try {
                iosDriver = new IOSDriver(new URL(DEFAULT_WD_HUB_URL), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        Helper.init(iosDriver);

    }

    @After
    public void tearDown() {
        System.out.println("sessionId = " + this.getSessionId());
        iosDriver.quit();
    }
}
