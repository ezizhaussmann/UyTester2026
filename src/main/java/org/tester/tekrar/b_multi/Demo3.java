package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:58,ven.
 **/
public class Demo3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " s'exécute ... " + i);
        }
    }
}
