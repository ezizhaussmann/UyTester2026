package org.tester.j_multithreading;

import java.util.Date;

/**
 * @created : 27/03/2026,14:22,ven.
 **/
public class Demo2 {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("Charlotte lin lin");
//        demo1.run();
        demo1.start();

        for (int i = 0; i < 10; i++) {
            Date d1 = new Date();
            System.out.println(d1+"  main multiThreas..........excuté" + i);
        }

    }
}
