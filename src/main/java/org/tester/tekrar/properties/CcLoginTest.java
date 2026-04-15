package org.tester.tekrar.properties;

import org.tester.aa_base.BaseClass;
import org.tester.propertiesFile.RedFromeConfig;

/**
 * @created : 30/03/2026,13:33,lun.
 **/
public class CcLoginTest extends BaseClass {
    public static void main(String[] args)  {
        RedFromeConfig redFromeConfig = new RedFromeConfig();
        String fileN = "config.properties";
        String url = RedFromeConfig.readFromConfig(fileN, "url");

        String usern = redFromeConfig.readFromConfig(fileN, "username");
        String pass = RedFromeConfig.readFromConfig(fileN, "password");

        setBrowser(url);
        implicitWait();
//
//        fluentWait();
        login(usern,pass);
        try {
            tryForBrowser();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logOut();
        closeBrowser();

    }
}
