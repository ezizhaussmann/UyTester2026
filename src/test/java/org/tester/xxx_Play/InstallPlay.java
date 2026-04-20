package org.tester.xxx_Play;

import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @created : 20/04/2026,18:58,lun.
 **/
public class InstallPlay {
    @Test
    public void installPlaywright() {
        // TODO
        Playwright.create(new Playwright.CreateOptions().setEnv(java.util.Map.of("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "0")));
        System.out.println("Installation terminée !");
        Assertions.assertTrue(10>2);
    }
    @Test
    public void testPlaywright() {
            try {
                com.microsoft.playwright.CLI.main(new String[] {"codegen", "https://demo.cubecart.com/admin_5xArPd.php"});
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // TODO
    }
}
