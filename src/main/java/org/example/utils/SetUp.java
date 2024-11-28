package org.example.utils;

import com.microsoft.playwright.*;

public class SetUp {
    private Page page;
    private Browser browser;

    public void setUp(String selectedBrowser) {
        System.out.println("Selected browser: " + selectedBrowser);

        Playwright playwright = Playwright.create();
        playwright.selectors().setTestIdAttribute("id");
        if (selectedBrowser.equalsIgnoreCase("chrome"))
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        else
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();
        page = context.newPage();
    }

    public Page getPageContext() {
        return page;
    }

    public void tearDown() {
        page.close();
        browser.close();
    }
}
