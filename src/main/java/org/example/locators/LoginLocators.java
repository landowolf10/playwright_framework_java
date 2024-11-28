package org.example.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utils.SetUp;

public class LoginLocators {
    private Page page;

    public LoginLocators(Page page) {
        this.page = page;
    }

    public Locator userTextbox() {
        return page.getByTestId("user-name");
    }

    public Locator passwordTextbox() {
        return page.getByTestId("password");
    }

    public Locator loginButton() {
        return page.getByTestId("login-button");
    }

    public Locator errorMessage() {
        return page.locator("[data-test='error']");
    }
}
