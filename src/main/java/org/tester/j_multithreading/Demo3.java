package org.tester.j_multithreading;

import java.util.Date;

/**
 * @created : 27/03/2026,14:22,ven.
 **/
public class Demo3 implements Runnable{
    @Override
    public void run() {

            for (int i = 0; i < 100; i++) {
                Date d2 = new Date();
                System.out.println(d2+" "+Thread.currentThread().getName()+"...exucuté"+i);
            }
        }
    }


