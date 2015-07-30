package com.rcta.appium.ios.testSuits;

import com.rcta.appium.ios.util.AppiumTestBase;
import org.junit.Test;
import org.openqa.selenium.Alert;

import static com.rcta.appium.ios.RCMobileScreen.AlertDialogue.alertDialogue;
import static com.rcta.appium.ios.RCMobileScreen.LoginPage.*;
import static com.rcta.appium.ios.util.Helper.waitForElementAppear;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bree.lu on 7/30/15.
 */
public class LoginPageTest extends AppiumTestBase {
    public static  String USERNAME ;
    public static  String PASSWORD ;

    static {
//        RCXIAUPAccount();
        ATTXIAUPAccount();
//        PoductionAccountInfo();
    }

    private static void PoductionAccountInfo() {
        USERNAME = "12054097406";
        PASSWORD = "Test!123";
    }
    private static void RCXIAUPAccount() {
        USERNAME = "18443750002";
        PASSWORD = "Test!123";
    }
    private static void ATTXIAUPAccount() {
        USERNAME = "18772010001";
        PASSWORD = "Test!123";
    }


    @Test
    public void login_without_input() {
        LoginButton().click();
        System.out.println("[INFO] blank input notification ");
        Alert alert = alertDialogue();
        assertTrue("wrong password Alert should popup", alert != null);
        System.out.println("alert title is "+ alert.getText());
        assertEquals("title is Missing Information", "Missing Information Please enter all of the required information before continuing.", alert.getText());

    }

    @Test
    public void input_wrong_password() {
        System.out.println("[STEP]step 1: input correct phone number, wrong password");
        getPhoneNumberFieldAndInput(USERNAME);
        getPasswordFieldAndInput("123");

        System.out.println("[STEP]step 2: click the login button");
        LoginButton().click();

        System.out.println("[INFO]Alert dialogue should appear.");
        Alert alert = alertDialogue();
        System.out.println("[INFO]Alert info is : Unable to Login Invalid phone number or password.Please try again.");
        assertEquals("title is Unable to Login", "Unable to Login Invalid phone number or password. Please try again.", alert.getText());
        System.out.println("[STEP]step 3 : click OK button to dismiss the alert");
    }

    @Test
    public void input_correct_info() {
        System.out.println("[STEP]step 1: input correct phone number and password");
        getPhoneNumberFieldAndInput(USERNAME);
        getPasswordFieldAndInput(PASSWORD);

        System.out.println("[STEP]step 2: click the login button");
        LoginButton().click();

        //todo: need to find the appropriate wait time
        waitForElementAppear(5000);

        System.out.println("[INFO]Acknowledge popup should appear");
        System.out.println("[INFO] Acknowledge page title is : Summary of Legal Terms");
        assertEquals("check Acknowledge page's title is correct", "Summary of Legal Terms", acknowledgePageLoaded().getText());
    }


}
