package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class CartTest {
    private AppiumDriver driver;

    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "Practica");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
        capabilities.setCapability("appium:appActivity", ".view.activities.SplashActivity");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Test
    public void testSuccessLogin() {
        //click menu button
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/menuIV")).click();

        //click logIn link
        driver.findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        //type username ---> com.saucelabs.mydemoapp.android:id/nameET (id)
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/nameET")).sendKeys("bod@example.com");

        //type password ---> com.saucelabs.mydemoapp.android:id/passwordET (id)
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/passwordET")).sendKeys("10203040");

        //click login button ---> android.widget.Button (class name)
        driver.findElement(By.className("android.widget.Button")).click();

        //click first product
        driver.findElement(By.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']/preceding-sibling::android.widget.ImageView")).click();

        //Scroll vertical down
        Dimension size = driver.manage().window().getSize();

        ((JavascriptExecutor) driver).executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", (int) (size.width * 0.1),
                        "top", (int) (size.height * 0.2),
                        "width", (int) (size.width * 0.8),
                        "height", (int) (size.height * 0.7),
                        "direction", "down",
                        "percent", 0.75
                )
        );
        //click add to cart button
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cartBt")).click();

        // click cart icon ---> com.saucelabs.mydemoapp.android:id/cartIV (id)
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cartIV")).click();

        // verify 1 item added ---> com.saucelabs.mydemoapp.android:id/itemsTV (id)
        String expectedResult = 1+" Items";
        String actualResult = driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/itemsTV")).getText();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
