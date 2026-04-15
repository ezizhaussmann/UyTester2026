package org.tester.tekrar.b_multi;

/**
 * @created : 28/03/2026,00:06,sam.
 **/
public class D6 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " s'exécute ... " + i);
        }
    }
}
