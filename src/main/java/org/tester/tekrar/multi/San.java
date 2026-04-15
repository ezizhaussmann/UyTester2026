package org.tester.tekrar.multi;

/**
 * @created : 27/03/2026,18:10,ven.
 **/
public class San {
    public static void main(String[] args) {
        ikki iko = new ikki();
        Thread t1 = new Thread(iko);
        Thread t2 = new Thread(iko);
        t1.start();
        t2.start();

    }
}
