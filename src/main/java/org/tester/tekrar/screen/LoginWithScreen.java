package org.tester.tekrar.screen;

import org.openqa.selenium.chrome.ChromeDriver;
import org.tester.aa_base.BaseClass;

/**
 * @created : 01/04/2026,18:02,mer.
 **/
public class LoginWithScreen extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        setBrowser("https://demo.cubecart.com/admin_5xArPd.php");
        login("cubecart","cubecart");
        takeSCreenShort("loginTest.jpg");
        tryForBrowser();
        ccAlert();
        closeBrowser();
//        driver.close();
    }
}
