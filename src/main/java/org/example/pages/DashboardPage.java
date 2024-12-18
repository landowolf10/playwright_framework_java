package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.locators.DashboardLocators;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    DashboardLocators dashboardLocators;
    static List<Float> selectedItemPrices = new ArrayList<>();

    public DashboardPage(Page page) {
        dashboardLocators = new DashboardLocators(page);
    }

    public void sortDropdown() {
        //dashboardLocators.sortDropDown().click();
        dashboardLocators.sortDropDown().selectOption("Price (high to low)");
    }

    public void addProduct() {
        List<Locator> addToCartButtons = dashboardLocators.addToCartButton().all();
        List<Float> prices = getPrices();

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < 20) {
                addToCartButtons.get(i).click();
                prices.remove(i);
                addToCartButtons.remove(i);
                selectedItemPrices.add(prices.get(i));

                break;
            }
        }
    }

    private List<Float> getPrices() {
        List<Locator> elements = dashboardLocators.productPrice().all();
        List<Float> prices = new ArrayList<>();
        String priceText;

        for (Locator element : elements) {
            priceText = element.textContent();

            prices.add(Float.valueOf(priceText.substring(1)));
        }

        System.out.println("Prices: " + prices);
        return prices;
    }

    public static List<Float> getSelectedItemAccess() {
        System.out.println("selectedItemPrices: " + selectedItemPrices);

        return selectedItemPrices;
    }
}