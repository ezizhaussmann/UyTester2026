package org.tester.automation_method;

/**
 * @created : 20/03/2026,15:23,ven.
 **/
public class DeleteRun {
    public static void main(String[] args) throws InterruptedException {
        TestMethod testMethod = new TestMethod();
        testMethod.setBrowser("https://demo.cubecart.com/admin_5xArPd.php");
        testMethod.login("cubecart","cubecart");
        testMethod.tryForBrowser();
        String customerEmail="Katachan"+System.currentTimeMillis()+"@gm.com";
        testMethod.addCustomerTest("Mr","Kata","Charlotte",customerEmail);
        testMethod.verifyCustomerAdded();
        testMethod.deleteCustomer(customerEmail);
        testMethod.logOut();
        testMethod.closeBrowser();

    }

}
