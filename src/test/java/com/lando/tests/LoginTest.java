package com.lando.tests;

import org.example.locators.LoginLocators;
import org.example.pages.LoginPage;
import org.example.utils.SetUp;
import org.testng.annotations.*;


public class LoginTest {
    SetUp setUp;
    LoginPage loginPage;

    @BeforeMethod
    @Parameters("selectedBrowser")
    void setUp(String selectedBrowser) {
        setUp = new SetUp();
        setUp.setUp(selectedBrowser);
        loginPage = new LoginPage(setUp.getPageContext());
    }

    @Test
    void successfulLoginTest() {
        loginPage.navigateToSauceLab();
        loginPage.writeValidCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
    }

    @AfterClass
    public void tearDown() {
        setUp.tearDown();
    }
}
