package org.tester.tekrar.b_multi;

/**
 * @created : 28/03/2026,00:05,sam.
 **/
public class D5 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " s'exécute ... " + i);
        }
    }
}
