package pages;

import control.Button;
import org.openqa.selenium.By;

public class ProductsPage {
    public void selectProduct(String productName) {
        Button product = new Button(By.xpath("//android.widget.TextView[@text='Sauce Labs " +  productName + "']/preceding-sibling::android.widget.ImageView"));
        product.click();
    }
}
