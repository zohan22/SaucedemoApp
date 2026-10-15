package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public final TextBox username = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/nameET"));
    public final TextBox password = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/passwordET"));
    public final Button loginButton = new Button(By.className("android.widget.Button"));

    public void typeUsername(String user) {
        username.setText(user);
    }

    public void typePassword(String pass) {
        password.setText(pass);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void loginAs(String user, String pass) {
        typeUsername(user);
        typePassword(pass);
        clickOnLoginButton();
    }
}
