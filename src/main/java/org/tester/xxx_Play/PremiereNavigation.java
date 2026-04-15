package org.tester.xxx_Play;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;

/**
 * @created : 26/03/2026,01:25,jeu.
 **/
public class PremiereNavigation {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(1000));

            Page page = browser.newPage();
            page.navigate("https://www.google.com");

            System.out.println("Le titre de la page est : " + page.title());
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tout accepter")).click();

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
            browser.close();
        }
    }
}