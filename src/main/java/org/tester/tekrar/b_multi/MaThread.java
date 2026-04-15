package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:15,ven.
 **/
// 1. Définir une classe qui hérite de Thread
public class MaThread extends Thread {

    // 2. Redéfinir la méthode run
    @Override
    public void run() {
        // Définition de la tâche de ce thread (ce qu'il doit faire concrètement)
        for (int i = 0; i < 10; i++) {
            System.out.println("Le thread personnalisé s'exécute : " + i);
        }
    }
}
