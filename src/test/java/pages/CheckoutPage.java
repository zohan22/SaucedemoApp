package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class CheckoutPage {
    private final TextBox nameInput = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/fullNameET"));
    private final TextBox firstAddressInput = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/address1ET"));
    private final TextBox secondAddressInput = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/address2ET"));
    private final TextBox cityInput = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/cityET"));
    private final TextBox stateInput = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/stateET"));
    private final TextBox zipCodeInput = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/zipET"));
    private final TextBox countryInput = new TextBox(By.id("com.saucelabs.mydemoapp.android:id/countryET"));
    private final Button paymentButton = new Button(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn"));

    public void fillInAddressDetails(String name, String addressOne, String addressTwo, String city, String state, String zipCode, String country) {
        nameInput.setText(name);
        firstAddressInput.setText(addressOne);
        secondAddressInput.setText(addressTwo);
        cityInput.setText(city);
        stateInput.setText(state);
        zipCodeInput.setText(zipCode);
        countryInput.setText(country);
    }

    public void clickOnPaymentButton() {
        paymentButton.click();
    }
}
