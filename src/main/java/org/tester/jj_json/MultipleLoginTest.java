package org.tester.jj_json;

/**
 * @created : 02/04/2026,18:59,jeu.
 **/


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.tester.aa_base.BaseClass;
import org.tester.aa_base.User;
import org.tester.aa_base.UsersObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MultipleLoginTest extends BaseClass {

    public static void main(String[] args) throws InterruptedException {
        // 1. Configuration de l'ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // SECURITÉ : Empêche le crash si le JSON contient des champs en trop
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UsersObject usersData = null;

        try {
            // CORRECTION : Utilisation de UsersObject.class (pas de .getClass() sur null)
            File jsonFile = new File("jsonfiles/users.json");
            usersData = objectMapper.readValue(jsonFile, UsersObject.class);

            System.out.println("Fichier JSON chargé avec succès !");
        } catch (IOException e) {
            System.err.println("ERREUR : Impossible de lire le fichier JSON. Vérifiez le chemin ou la structure.");
            e.printStackTrace();
            return; // On arrête le programme si le fichier est illisible
        }

        // 2. Récupération de la liste
        List<User> loginUsers = usersData.getUser();

        // 3. Automatisation Selenium
        setBrowser("https://demo.cubecart.com/admin_5xArPd.php");

        for (User user : loginUsers) {
            // VERIFICATION : On vérifie que les données ne sont pas nulles avant d'envoyer à Selenium
            if (user.getUserName() != null && user.getPassword() != null) {
                System.out.println("Tentative de connexion pour : " + user.getUserName());

                login(user.getUserName(), user.getPassword());

                tryForBrowser(); // Tes méthodes de BaseClass
                ccAlert();
                logOut();

            } else {
                System.out.println("Saut d'un utilisateur car les données sont vides dans le JSON.");
            }
        }

        closeBrowser();
    }
}
