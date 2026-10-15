package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import utils.Login;


public class ProductDetailsTest extends BaseTest{
    ProductsPage productsPage = new ProductsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Test
    public void testSelectOneProduct() {
        Login.login("bod@example.com", "10203040");
        productsPage.selectProduct("Backpack");

        String expectedResult = "Sauce Labs Backpack";
        String actualResult = productDetailsPage.getProduct();

        Assertions.assertEquals(expectedResult, actualResult);
    }

}
