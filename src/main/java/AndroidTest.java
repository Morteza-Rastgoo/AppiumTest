import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AndroidTest {

    public void clickOnGetStartedButton(AndroidDriver driver) {
        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='GET STARTED']")));
        element.click();

    }

    //Put application in the Background ,Open Last Message in the Mobile / Simulator and open application again
    public void goHome(AndroidDriver driver) {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.startActivity(new Activity("com.google.android.apps.messaging", "home.HomeActivity"));
        swipeToBottom(driver);
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        List<WebElement> messages = element.findElements(AppiumBy.className("android.view.ViewGroup"));
        messages.get(messages.size() - 1).click();

    }

    public void swipeToBottom(AndroidDriver driver) {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        System.out.println("coordinates :" + x + "  " + top_y + " " + bottom_y);
        TouchAction ts = new TouchAction(driver);
        ts.press(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();
    }
}


