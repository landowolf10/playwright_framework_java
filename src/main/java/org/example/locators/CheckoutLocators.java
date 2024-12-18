package org.example.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutLocators {
    private final Page page;

    public CheckoutLocators(Page page) {
        this.page = page;
    }

    public Locator checkoutButton() {
        return page.getByTestId("checkout");
    }

    public Locator txtFirstName() {
        return page.getByTestId("first-name");
    }

    public Locator txtLastName() {
        return page.getByTestId("last-name");
    }

    public Locator txtZipCode() {
        return page.getByTestId("postal-code");
    }

    public Locator continueButton() {
        return page.getByTestId("continue");
    }

    public Locator subtotal() {
        return page.locator("[class='summary_subtotal_label']");
    }

    public Locator finishButton() {
        return page.getByTestId("finish");
    }

    public Locator orderTitle() {
        return page.locator("[class='complete-header']");
    }

    public Locator orderMessage() {
        return page.locator("[class='complete-text']");
    }

    public Locator backToHomeButton() {
        return page.getByTestId("back-to-products");
    }
}
