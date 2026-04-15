package org.tester.cc_amazon;

/**
 * @created : 27/03/2026,17:31,ven.
 **/
public class MainApp {
    public static void main(String[] args) {
        // 1. On crée nos deux objets de test (les "missions")
        AmazonTest mission1 = new AmazonTest("iphone 16");
        AmazonTest mission2 = new AmazonTest("ps5");

        // 2. On crée les "ouvriers" (Threads) en leur donnant les missions
        Thread t1 = new Thread(mission1);
        Thread t2 = new Thread(mission2);

        // 3. On lance les moteurs
        t1.start();
        t2.start();

        System.out.println("Les deux tests sont lancés en parallèle !");
    }
}
