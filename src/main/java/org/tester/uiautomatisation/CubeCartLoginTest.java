package org.tester.uiautomatisation;

import org.tester.automation_method.TestMethod;
import org.tester.propertiesFile.RedFromeConfig;

import java.util.Properties;

/**
 * @created : 30/03/2026,13:08,lun.
 **/
public class CubeCartLoginTest extends TestMethod {
    public static void main(String[] args) {
        RedFromeConfig redFromeConfig = new RedFromeConfig();
        String fileN="config.properties";
        String url=RedFromeConfig.readFromConfig(fileN,"url");
        String usern=redFromeConfig.readFromConfig(fileN,"username");
        String pass=RedFromeConfig.readFromConfig(fileN,"password");
        TestMethod testMethod = new TestMethod();
        testMethod.setBrowser(url);
        testMethod.implicitWait();
        testMethod.login(usern,pass);
        try {
            testMethod.tryForBrowser();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testMethod.logOut();
        testMethod.closeBrowser();


    }
}
