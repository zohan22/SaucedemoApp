package control;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session.Session;

import java.time.Duration;

public class BaseControl {
    protected WebElement control;
    protected AppiumDriver driver = Session.getSession().getDevice();
    private final By locator;

    public BaseControl(By locator) {
        this.locator = locator;
    }

    public WebElement waitForElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibleElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void findControl() {
        control = Session.getSession().getDevice().findElement(locator);
    }

    public void click() {
        waitForElement().click();
    }

    public String getText() {
        return waitForVisibleElement().getText();
    }

    public boolean isControlDisplayed() {
        return waitForVisibleElement().isDisplayed();
    }
}
