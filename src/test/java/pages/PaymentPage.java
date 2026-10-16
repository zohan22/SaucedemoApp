package pages;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class PaymentPage {
    private final Label titlePaymentMethod = new Label(By.id("com.saucelabs.mydemoapp.android:id/enterPaymentMethodTV"));
    private final Button reviewButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn"));

    public String getTitle() {
        return titlePaymentMethod.getText();
    }

    public void clickOnReviewButton() {
        reviewButton.click();
    }
}
