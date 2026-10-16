package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import utils.Login;

public class CartTest  extends BaseTest{
    ProductsPage productsPage = new ProductsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    CartPage cartPage = new CartPage();

    @Test
    public void testAddToCart() {
        Login.login("bod@example.com", "10203040");
        productsPage.selectProduct("Backpack");
        gestures.scrollDown();
        productDetailsPage.clickOnAddToCartButton();
        header.openCart();
        String expectedResult = 1+" Items";
        String actualResult = cartPage.getProductQuantity();
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
