package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.locators.DashboardLocators;
import org.example.locators.LoginLocators;
import java.util.HashMap;

public class LoginPage {
    LoginLocators loginLocators;
    DashboardLocators dashboardLocators;

    public LoginPage(Page page) {
        loginLocators = new LoginLocators(page);
        dashboardLocators = new DashboardLocators(page);
    }

    public void writeCredentials(String email, String password) {
        loginLocators.userTextbox().fill(email);
        loginLocators.passwordTextbox().fill(password);
    }

    public void clickLoginButton() {
        loginLocators.loginButton().click();
    }

    public HashMap<String, Locator> getValidLoginElements() {
        HashMap<String, Locator> presentElements = new HashMap<>();

        presentElements.put("cart_icon", dashboardLocators.cartIcon());
        presentElements.put("drop_down", dashboardLocators.sortDropDown());

        return presentElements;
    }

    public HashMap<String, Boolean> getInvalidLoginElements()
    {
        HashMap<String, Boolean> presentElements = new HashMap<>();

        presentElements.put("login_button", loginLocators.loginButton().isVisible());
        presentElements.put("error_message", loginLocators.errorMessage().isVisible());

        return presentElements;
    }

    public String getErrorMessageText() {
        return loginLocators.errorMessage().textContent();
    }
}
