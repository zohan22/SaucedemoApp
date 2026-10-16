package pages;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class ProductDetailsPage {
    private final Label titleProduct = new Label(By.id("com.saucelabs.mydemoapp.android:id/productTV"));
    private final Button addToCartButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/cartBt"));

    public String getProduct() {
        return titleProduct.getText();
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }
}
