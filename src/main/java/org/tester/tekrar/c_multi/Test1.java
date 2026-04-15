package org.tester.tekrar.c_multi;

/**
 * @created : 28/03/2026,13:00,sam.
 **/
public class Test1 {
    public static void main(String[] args) {
        Tickets t = new Tickets();
        Thread t1 = new Thread(t,"luffy");
        Thread t2 = new Thread(t,"katakuri");
        Thread t3 = new Thread(t,"Sabo");
        Thread t4 = new Thread(t,"Ace");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
