package org.tester.j_multithreading;

/**
 * @created : 27/03/2026,15:05,ven.
 **/
public class Demo4 {
    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        Thread t1 = new Thread(demo3);
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"...执行了"+i);
        }
    }
}
