package org.example.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class DashboardLocators {
    private Page page;

    public DashboardLocators(Page page) {
        this.page = page;
    }

    public Locator productPrice() {
        return page.locator("[class='inventory_item_price']");
    }

    public Locator addToCartButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
    }

    public Locator sortDropDown() {
        return page.locator("[data-test='product-sort-container']");
    }

    public Locator cartIcon() {
        return page.locator("[class='shopping_cart_link']");
    }
}
