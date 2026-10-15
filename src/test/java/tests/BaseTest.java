package tests;

import components.Header;
import components.NavigationMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import session.Session;

public class BaseTest {

    protected Header header;
    protected NavigationMenu nav;

    @BeforeEach
    public void setUp() {
        Session.getSession();
        header = new Header();
        nav = new NavigationMenu();
    }

    @AfterEach
    public void tearDown() {
        Session.getSession().closeSession();
    }
}
