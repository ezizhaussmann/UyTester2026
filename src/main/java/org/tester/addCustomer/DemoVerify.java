package org.tester.addCustomer;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @created : 26/03/2026,02:13,jeu.
 **/
public class DemoVerify {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.google.com");

            // 1. Accepter les cookies
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tout accepter")).click();

            // 2. VÉRIFICATION : Est-ce qu'on est bien sur Google ?
            assertThat(page).hasTitle("Google");

            // 3. VÉRIFICATION : Est-ce que la barre de recherche est là ?
            Locator searchBar = page.locator("[name='q']");
            assertThat(searchBar).isVisible();

            System.out.println("Toutes les vérifications ont réussi !");
            browser.close();
        }
    }
}
