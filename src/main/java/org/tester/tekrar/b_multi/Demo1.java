package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:35,ven.
 **/
public class Demo1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"....executé.."+i);
        }
    }
}
