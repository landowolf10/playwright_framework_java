package org.example.utils;

import org.example.pages.CheckoutPage;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.testng.annotations.*;

public class Fixture {
    protected SetUp setUp;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected CheckoutPage checkoutPage;

    @BeforeClass
    @Parameters("selectedBrowser")
    public void setUp(String selectedBrowser) {
        setUp = new SetUp();
        setUp.setUp(selectedBrowser);
        loginPage = new LoginPage(setUp.getPageContext());
        dashboardPage = new DashboardPage(setUp.getPageContext());
        checkoutPage = new CheckoutPage(setUp.getPageContext());
        setUp.getPageContext().navigate("https://www.saucedemo.com");
    }

    @AfterClass
    public void tearDown() {
        setUp.tearDown();
    }
}
