package org.tester.j_multithreading;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @created : 27/03/2026,14:22,ven.
 **/
public class Demo1 extends Thread {

    private String message;

    public Demo1(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            Date date = new Date();
            System.out.println(date+" "+message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
