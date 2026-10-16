package components;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class Header {
    private final Button menuButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/menuIV"));
    private final Button cartButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/cartIV"));
    private final Label counterText = new Label(By.id("com.saucelabs.mydemoapp.android:id/itemsTV"));

    public void openMenu() {
        menuButton.click();
    }

    public void openCart() {
        cartButton.click();
    }

    public String getCounter() {
        return counterText.getText();
    }

}
