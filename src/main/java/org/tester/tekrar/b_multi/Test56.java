package org.tester.tekrar.b_multi;

/**
 * @created : 28/03/2026,00:07,sam.
 **/
public class Test56 {
    public static void main(String[] args) {
        D5 d5 = new D5();
        d5.setName("kaka");
        D6 d6 = new D6();
        d6.setName("messi");
        d5.setDaemon(true);
        d5.start();
        d6.start();
    }
}
