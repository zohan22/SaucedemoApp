package device;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Android implements IDevice{

    @Override
    public AndroidDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "Galaxy A05s");
        capabilities.setCapability("appium:udid", "R7AX60FHJHE");
        capabilities.setCapability("appium:platformVersion", "15");
        capabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
        capabilities.setCapability("appium:appActivity", ".view.activities.SplashActivity");
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        return driver;
    }
}
