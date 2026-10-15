package tests;

import control.Button;
import control.Label;
import control.TextBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import pages.LoginPage;
import pages.ProductsPage;
import session.Session;

import java.util.Map;

public class CardTest extends BaseTest {

    @Test
    public void testPaymentDetails() {
        // 1. Iniciar sesión 
        header.openMenu();
        nav.selectOptionMenu("Log In");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("bod@example.com", "10203040");

        // 2. Seleccionar producto 
        ProductsPage productsPage = new ProductsPage();
        productsPage.selectProduct("Backpack");

        Dimension size = Session.getSession().getDevice().manage().window().getSize();
        ((JavascriptExecutor) Session.getSession().getDevice()).executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", (int) (size.width * 0.1),
                        "top", (int) (size.height * 0.2),
                        "width", (int) (size.width * 0.8),
                        "height", (int) (size.height * 0.7),
                        "direction", "down",
                        "percent", 0.75
                )
        );

        new Button(By.id("com.saucelabs.mydemoapp.android:id/cartBt")).click();
        new Button(By.id("com.saucelabs.mydemoapp.android:id/cartIV")).click();
        new Button(By.id("com.saucelabs.mydemoapp.android:id/cartBt")).click(); // Proceed to checkout

        // 3. Llenar los datos de envío 
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/fullNameET")).setText("Juan Perez");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/address1ET")).setText("Calle Uno");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/address2ET")).setText("Calle Dos");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/cityET")).setText("Santiago");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/stateET")).setText("Regiones");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/zipET")).setText("12345");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/countryET")).setText("Santiago");

        // Scroll para ver el botón de pago
        ((JavascriptExecutor) Session.getSession().getDevice()).executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", (int) (size.width * 0.1),
                        "top", (int) (size.height * 0.2),
                        "width", (int) (size.width * 0.8),
                        "height", (int) (size.height * 0.7),
                        "direction", "down",
                        "percent", 0.75
                )
        );
        new Button(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();

        // 4. Llenar los datos de la tarjeta 
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/nameET")).setText("Juan Perez");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/cardNumberET")).setText("3258125675687891");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/expirationDateET")).setText("0325");
        new TextBox(By.id("com.saucelabs.mydemoapp.android:id/securityCodeET")).setText("123");

        // Click en el botón "Review Order"
        new Button(By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")).click();

        // 5. Verificación (Aserción) utilizando el control Label del framework
        Label reviewLabel = new Label(By.xpath("//android.widget.TextView[@text='Review your order']"));
        Assertions.assertEquals("Review your order", reviewLabel.getText());
    }
}