package org.tester.tekrar.c_multi;

/**
 * @created : 28/03/2026,12:57,sam.
 **/
public class Tickets implements Runnable{
//    Object lock=new Object();
    int ticket=100;

    @Override
    public void run() {
        while (ticket>0){
            vendreBillet();
        }


    }

    public synchronized void vendreBillet() {
        if (ticket>0){
            System.out.println(Thread.currentThread().getName() + " achète le billet n°" + ticket);
            ticket--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    @Override
//    public void run() {
//        while (true) {
//            // Seul le thread qui possède le jeton 'lock' peut entrer ici
//            synchronized (lock) {
//                if (ticket > 0) {
//                    // Petite pause simulée pour forcer le CPU à essayer de changer de thread
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(Thread.currentThread().getName() + " a acheté le billet n°" + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
//            } // Le verrou est libéré ici automatiquement
//        }
//    }
//
    }

//    @Override
//    public void run() {
//        while (true){
//            if (ticket>0){
//                System.out.println(Thread.currentThread().getName() + " a acheté de billet numero" + ticket);
//                ticket--;
//            }else {
//                break;
//            }
//        }
//
//    }
//}
