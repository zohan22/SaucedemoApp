package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @Test
    public void testSuccessLogin() {
        header.openMenu();
        nav.selectOptionMenu("Log In");
        loginPage.loginAs("bod@example.com", "10203040");
        header.openMenu();
        boolean element = nav.optionDisplayed("Log Out");
        Assertions.assertTrue(element);
    }
}
