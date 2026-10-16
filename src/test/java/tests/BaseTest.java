package tests;

import components.Header;
import components.NavigationMenu;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import session.Session;
import utils.Gestures;

public class BaseTest {
    protected AppiumDriver driver;
    protected Header header;
    protected NavigationMenu nav;
    protected Gestures gestures;

    @BeforeEach
    public void setUp() {
        driver = Session.getSession().getDevice();

        Session.getSession();
        header = new Header();
        nav = new NavigationMenu();
        gestures = new Gestures(driver);
    }

    @AfterEach
    public void tearDown() {
        Session.getSession().closeSession();
    }
}
