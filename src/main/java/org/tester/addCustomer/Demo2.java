package org.tester.addCustomer;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

/**
 * @created : 26/03/2026,02:06,jeu.
 **/
public class Demo2 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demoqa.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Elements")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Web Tables")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
            page.getByLabel("Close").click();
        }
    }
}
