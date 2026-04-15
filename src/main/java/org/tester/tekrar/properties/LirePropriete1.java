package org.tester.tekrar.properties;

/**
 * @created : 29/03/2026,18:47,dim.
 **/


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LirePropriete1 {

    public static String fFC(String cheminFichier, String cle) {
        Properties properties = new Properties();

        // Le try-with-resources ferme automatiquement le flux à la fin
        try (FileInputStream fis = new FileInputStream(cheminFichier)) {
            properties.load(fis);
            return properties.getProperty(cle);
        } catch (IOException e) {
            // Si le fichier n'est pas trouvé ou illisible
            System.err.println("Erreur : Impossible de lire le fichier à : " + cheminFichier);
            return null;
        }
    }
}
