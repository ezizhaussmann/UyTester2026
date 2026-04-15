package org.tester.tekrar.c_multi;

/**
 * @created : 28/03/2026,12:48,sam.
 **/
public class Demo1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName()+"......executé..."+i);
                }
            }
        },"luffy").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName()+"......executé..."+i);

            }}
        },"Kata").start();
    }
}
