package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:50,ven.
 **/
public class TestDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Demo2 d2 = new Demo2();
        d2.setName("Charlotte");
        d2.start();
        Thread.sleep(3000);
        System.out.println("Main : Je demande l'arrêt de " + d2.getName());
        d2.interrupt();
    }
}
