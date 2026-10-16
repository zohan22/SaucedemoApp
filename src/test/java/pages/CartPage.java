package pages;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class CartPage {
    private final Label counterItem = new Label(By.id("com.saucelabs.mydemoapp.android:id/itemsTV"));
    private final Button checkoutButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/cartBt"));
    private final Button increaseQuantityButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/plusIV"));
    private final Button decreaseQuantityButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/minusIV"));

    public String getProductQuantity() {
        return counterItem.getText();
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    public void increaseQuantity() {
        increaseQuantityButton.click();
    }

    public void decreaseQuantity() {
        decreaseQuantityButton.click();
    }
}
