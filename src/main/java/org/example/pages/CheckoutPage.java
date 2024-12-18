package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.locators.CheckoutLocators;
import org.example.locators.DashboardLocators;
import java.util.HashMap;

public class CheckoutPage {
    CheckoutLocators checkoutLocators;
    DashboardLocators dashboardLocators;

    public CheckoutPage(Page page) {
        checkoutLocators = new CheckoutLocators(page);
        dashboardLocators = new DashboardLocators(page);
    }

    public void proceedWithCheckout() {
        dashboardLocators.cartIcon().click();
        checkoutLocators.checkoutButton().click();
        checkoutLocators.txtFirstName().fill("Orlando");
        checkoutLocators.txtLastName().fill("Avila");
        checkoutLocators.txtZipCode().fill("40880");
        checkoutLocators.continueButton().click();
    }

    public String getItemsSum() {
        float subTotal = 0;

        for (Float selectedItemPrice : DashboardPage.getSelectedItemAccess()) subTotal += selectedItemPrice;

        return "Item total: $" + subTotal;
    }

    public String getSubtotal() {
        return checkoutLocators.subtotal().textContent();
    }

    public HashMap<String, Boolean> getCheckoutElements() {
        HashMap<String, Boolean> presentElements = new HashMap<>();

        presentElements.put("order_title", checkoutLocators.orderTitle().isVisible());
        presentElements.put("order_message", checkoutLocators.orderMessage().isVisible());
        presentElements.put("home_button", checkoutLocators.backToHomeButton().isVisible());

        return presentElements;
    }

    public void clickFinishButton() {
        DashboardPage.getSelectedItemAccess().clear();
        checkoutLocators.finishButton().click();
    }
}