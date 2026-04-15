package org.tester.automation_method;

/**
 * @created : 20/03/2026,14:48,ven.
 **/
public class AddRun {
    public static void main(String[] args) throws InterruptedException {
        TestMethod testMethod = new TestMethod();
        testMethod.setBrowser("https://demo.cubecart.com/admin_5xArPd.php");
        testMethod.implicitWait();
//        testMethod.javaScripte();
        testMethod.login("cubecart", "cubecart");
        testMethod.tryForBrowser();
        testMethod.addCustomerTest("MM", "linlin", "Charlotte", "Charlotte"+System.currentTimeMillis()+"@ggmail.com");
        testMethod.verifyCustomerAdded();
        testMethod.logOut();
        testMethod.closeBrowser();
    }
}
