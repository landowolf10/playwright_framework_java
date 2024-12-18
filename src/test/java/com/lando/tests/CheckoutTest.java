package com.lando.tests;

import org.example.utils.Fixture;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckoutTest extends Fixture {
    @Test
    void successfulLoginTest() {
        loginPage.writeCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.getValidLoginElements().get("cart_icon").isVisible());
        Assert.assertTrue(loginPage.getValidLoginElements().get("drop_down").isVisible());
    }

    @Test(dependsOnMethods = "successfulLoginTest")
    public void checkoutTest() {
        dashboardPage.sortDropdown();
        dashboardPage.addProduct();
        dashboardPage.addProduct();
        checkoutPage.proceedWithCheckout();
        Assert.assertEquals(checkoutPage.getItemsSum(), checkoutPage.getSubtotal());
        checkoutPage.clickFinishButton();
    }

    @Test(dependsOnMethods = "checkoutTest")
    public void finishCheckoutTest() {
        Assert.assertTrue(checkoutPage.getCheckoutElements().get("order_title"));
        Assert.assertTrue(checkoutPage.getCheckoutElements().get("order_message"));
        Assert.assertTrue(checkoutPage.getCheckoutElements().get("home_button"));
    }
}
