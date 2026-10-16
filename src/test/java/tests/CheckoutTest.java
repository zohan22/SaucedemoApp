package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;
import utils.Login;

import java.util.stream.Stream;


public class CheckoutTest extends BaseTest{
    ProductsPage productsPage = new ProductsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    PaymentPage paymentPage = new PaymentPage();

    static Stream<Arguments> addressDataProvider() {
        return Stream.of(
                Arguments.of("Juan Gonzales", "Calle1", "Calle2", "Santiago", "Los Condes", "12345", "Chile")
        );
    }

    @ParameterizedTest
    @MethodSource("addressDataProvider")
    public void testGetData(String name, String addressOne, String addressTwo, String city, String state, String zipCode, String country) {
        Login.login("bod@example.com", "10203040");
        productsPage.selectProduct("Backpack");
        gestures.scrollDown();
        productDetailsPage.clickOnAddToCartButton();
        header.openCart();
        cartPage.increaseQuantity();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInAddressDetails(name, addressOne, addressTwo, city, state, zipCode, country);
        gestures.scrollDown();
        checkoutPage.clickOnPaymentButton();

        String expectedResult = "Enter a payment method";
        String actualResult = paymentPage.getTitle();
        Assertions.assertEquals(expectedResult, actualResult);
    }



}
