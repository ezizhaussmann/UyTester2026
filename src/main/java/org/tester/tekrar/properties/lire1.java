

/**
 * @created : 29/03/2026,18:48,dim.
 **/

package org.tester.tekrar.properties;

import java.io.File;

public class lire1 {
    public static void main(String[] args) {
        // 1. On définit le chemin (relatif à la racine du projet)
        String chemin = "f_config"+ File.separator+"config1.properties";

        // 2. On appelle la méthode en précisant la CLÉ (ex: "url") entre guillemets
        String resultat = LirePropriete1.fFC(chemin, "url");

        // 3. On affiche le résultat
        if (resultat != null) {
            System.out.println("La valeur trouvée est : " + resultat);
        } else {
            System.out.println("La clé ou le fichier n'a pas été trouvé.");
        }
    }
}