package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Map;

public class Gestures {
    private final AppiumDriver driver;

    public Gestures(AppiumDriver driver) {
        this.driver = driver;
    }

    private boolean scroll(String direction) {
        Dimension size = driver.manage().window().getSize();
        Object result = ((JavascriptExecutor) driver).executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", (int) (size.width * 0.1),
                        "top", (int) (size.height * 0.2),
                        "width", (int) (size.width * 0.8),
                        "height", (int) (size.height * 0.7),
                        "direction", direction,
                        "percent", 0.75
                )
        );

        return Boolean.TRUE.equals(result);
    }

    public boolean scrollDown() {
        return scroll("down");
    }

    public boolean scrollUp() {
        return scroll("up");
    }

    public boolean scrollLeft() {
        return scroll("left");
    }

    public boolean scrollRight() {
        return scroll("right");
    }
}



