package org.tester.j_multithreading;

/**
 * @created : 27/03/2026,16:25,ven.
 **/
public class Test1 extends Thread {


    @Override
    public void run() {
        AmazonTest amazonTest = new AmazonTest();
        amazonTest.setUp();




    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.start();
    }
}
