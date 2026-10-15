package pages;

import control.Label;
import org.openqa.selenium.By;

public class ProductDetailsPage {
    private final Label titleProduct = new Label(By.id("com.saucelabs.mydemoapp.android:id/productTV"));

    public String getProduct() {
        return titleProduct.getText();
    }
}
