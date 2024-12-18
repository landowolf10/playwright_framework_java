package com.lando.tests;

import org.example.utils.Fixture;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends Fixture {
    @Test
    void successfulLoginTest() {
        loginPage.writeCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.getValidLoginElements().get("cart_icon").isVisible());
        Assert.assertTrue(loginPage.getValidLoginElements().get("drop_down").isVisible());
    }

    @Test(dependsOnMethods = "successfulLoginTest")
    public void invalidLoginTest() {
        setUp.getPageContext().navigate("https://www.saucedemo.com");
        loginPage.writeCredentials("standard_use", "secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getInvalidLoginElements().get("login_button"));
        Assert.assertTrue(loginPage.getInvalidLoginElements().get("error_message"));
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match " +
                "any user in this service");
    }
}
