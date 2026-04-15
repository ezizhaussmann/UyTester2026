package org.tester.xxx_Play;

import java.io.IOException;

/**
 * @created : 26/03/2026,01:41,jeu.
 **/
public class LanceurCodegen {
    public static void main(String[] args) throws IOException, InterruptedException {
        com.microsoft.playwright.CLI.main(new String[] {"codegen", "https://demo.cubecart.com/admin_5xArPd.php"});
    }
}
