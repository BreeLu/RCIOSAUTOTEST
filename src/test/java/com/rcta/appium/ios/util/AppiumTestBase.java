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
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        desiredCapabilities.setCapability("appiumVersion", "1.4.8");
        desiredCapabilities.setCapability("name", name.getMethodName());
        URL sauceUrl = null;

        String userDir = System.getProperty("user.dir");
        String localApp = "UICatalog.app";

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
        }else {
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
        System.out.println("Link to your job: https://saucelabs.com/jobs/" + this.getSessionId());
        iosDriver.quit();
    }
}
