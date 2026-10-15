package components;

import control.Button;
import org.openqa.selenium.By;

public class Header {
    private final Button menuButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/menuIV"));

    public void openMenu() {
        menuButton.click();
    }
}
