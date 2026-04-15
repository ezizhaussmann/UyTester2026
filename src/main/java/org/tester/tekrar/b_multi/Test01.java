package org.tester.tekrar.b_multi;

/**
 * @created : 27/03/2026,23:27,ven.
 **/
public class Test01 {
    public static void main(String[] args) {
        // 3. Créer un objet de notre classe de thread personnalisée
        MaThread t1 = new MaThread();

        // 4. Appeler la méthode start()
        // Cela active le thread et la JVM appelle automatiquement la méthode run()
        t1.start();

        // Tâche du thread principal (main) pour comparer l'exécution
        for (int i = 0; i < 10; i++) {
            System.out.println("Le thread MAIN s'exécute : " + i);
        }
    }
}
