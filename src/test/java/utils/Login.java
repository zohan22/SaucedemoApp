package utils;

import components.Header;
import components.NavigationMenu;
import pages.LoginPage;

public class Login {
    public static void login(String user, String pass) {
        Header header = new Header();
        NavigationMenu nav = new NavigationMenu();
        LoginPage loginPage = new LoginPage();

        header.openMenu();
        nav.selectOptionMenu("Log In");
        loginPage.loginAs(user, pass);
    }
}
