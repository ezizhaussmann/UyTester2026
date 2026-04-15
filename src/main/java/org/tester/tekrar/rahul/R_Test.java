package org.tester.tekrar.rahul;

/**
 * @created : 24/03/2026,22:54,mar.
 **/
public class R_Test {
    public static void main(String[] args) {
        R_method rMethod = new R_method();
        rMethod.setBrowser("https://rahulshettyacademy.com/loginpagePractise/");
        rMethod.login("rahulshettyacademy","Learning@830$3mK2");
        rMethod.closeBrowser();
    }
}
