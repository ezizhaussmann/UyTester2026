package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:46,ven.
 **/
public class Demo2 extends Thread {
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                System.out.println(getName() + " est en train de travailler...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " a été réveillé pendant son sommeil ! Arrêt en cours...");
                break;
            }
            System.out.println(getName() + " est officiellement terminé.");
        }
    }

}
