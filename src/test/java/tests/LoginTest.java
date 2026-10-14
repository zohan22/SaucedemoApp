package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
    private AppiumDriver driver;

    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "SM_A155M");
        capabilities.setCapability("appium:udid", "R58X90JGQRA");
        capabilities.setCapability("appium:platformVersion", "14.0");
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

        //click menu button ---> com.saucelabs.mydemoapp.android:id/menuIV (id)
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/menuIV")).click();

        //verify log out link ---> Logout Menu Item (acc)
        boolean logOutLink = driver.findElement(AppiumBy.accessibilityId("Logout Menu Item")).isDisplayed();
        Assertions.assertTrue(logOutLink);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
