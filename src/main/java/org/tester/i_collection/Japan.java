package org.tester.i_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @created : 26/03/2026,22:37,jeu.
 **/
public class Japan {
    public static void main(String[] args) {
        // 1. Création de la liste
        List<MotJaponais> lexique = new ArrayList<>();

        // 2. Ajout de plusieurs contenus en même temps
        lexique.add(new MotJaponais("猫", "ねこ (Neko)", "Chat"));
        lexique.add(new MotJaponais("日本語", "にほんご (Nihongo)", "Japonais"));
        lexique.add(new MotJaponais("食べる", "たべる (Taberu)", "Manger"));

        // 3. Utilisation de l'Iterator pour le "Quiz"
        Iterator<MotJaponais> it = lexique.iterator();

        System.out.println("--- DÉBUT DU QUIZ ---");

        while (it.hasNext()) {
            MotJaponais  actuel = it.next();

            System.out.println("Comment dit-on '" + actuel.traduction + "' ?");
            System.out.println("Réponse : " + actuel.kanji + " [" + actuel.lecture + "]");
            System.out.println("---------------------");
        }
    }
}
