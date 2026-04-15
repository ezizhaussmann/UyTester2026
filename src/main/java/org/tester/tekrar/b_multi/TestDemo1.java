package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:37,ven.
 **/
public class TestDemo1 {
    public static void main(String[] args) {
        Demo1 d1 = new Demo1();
        d1.setName("kaltekshah");
        d1.start();
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()+"....owchi... oldi.."+i);
        }
    }

}
