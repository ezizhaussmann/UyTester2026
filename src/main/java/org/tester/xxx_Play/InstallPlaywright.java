package org.tester.xxx_Play;

import com.microsoft.playwright.Playwright;

/**
 * @created : 26/03/2026,01:22,jeu.
 **/
public class InstallPlaywright {
    public static void main(String[] args) {
        Playwright.create(new Playwright.CreateOptions().setEnv(java.util.Map.of("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "0")));
        System.out.println("Installation terminée !");
    }
}