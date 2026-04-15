package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:59,ven.
 **/
public class Test3 {
    public static void main(String[] args) {
        Demo3 d3 = new Demo3();
        d3.setName("Luffy");
        Demo3 d4 = new Demo3();
        d4.setName("Zoro");
//        d3.setPriority(5);
//        d4.setPriority(6);
        d3.setDaemon(true);
        d3.start();
        d4.start();
    }
}
