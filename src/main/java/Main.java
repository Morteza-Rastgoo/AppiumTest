import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static final String APP_PACKAGE = "org.nativescript.examples";

    public static void main(String[] args) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setAppActivity("com.tns.NativeScriptActivity")
                .setAppPackage(APP_PACKAGE);
        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
            AndroidTest test = new AndroidTest();
            test.clickOnGetStartedButton(driver);
            test.goHome(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
