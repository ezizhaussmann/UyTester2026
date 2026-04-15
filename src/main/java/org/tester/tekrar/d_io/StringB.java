package org.tester.tekrar.d_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @created : 29/03/2026,17:00,dim.
 **/
public class StringB {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ce code Java définit une classe `WTFM` avec une méthode `wtf` dont le rôle principal est de **créer un dossier (si nécessaire) et d'y écrire un fichier texte** avec un contenu spécifique.\n" +
                "\n" +
                "Voici une décomposition étape par étape de ce que fait ce script :\n" +
                "\n" +
                "### 1. Préparation du chemin d'accès\n" +
                "* **`System.getProperty(\"user.dir\")`** : Récupère le chemin du répertoire de travail actuel (là où le programme est exécuté).\n" +
                "* **`File.separator`** : Utilise le séparateur de fichier correct selon votre système d'exploitation (`\\` pour Windows, `/` pour Linux/Mac).\n" +
                "* Le code construit ainsi un chemin complet vers un dossier cible nommé `foldN`.\n" +
                "\n" +
                "### 2. Gestion du dossier\n" +
                "```java\n" +
                "if (!folder.exists()){\n" +
                "    folder.mkdir();\n" +
                "    System.out.println(String.format(\"%s folder is created\",foldN));\n" +
                "}\n" +
                "```\n" +
                "* Le programme vérifie si le dossier existe déjà.\n" +
                "* S'il n'existe pas, il le crée avec `mkdir()`.\n" +
                "\n" +
                "### 3. Création et écriture du fichier\n" +
                "* Il assemble le chemin final du fichier en combinant le dossier, le nom du fichier (`fileN`) et son extension (`exte`).\n" +
                "* **`FileWriter`** et **`BufferedWriter`** : Ces classes sont utilisées pour ouvrir un flux d'écriture vers le fichier. Le `BufferedWriter` est particulièrement efficace car il met les données en mémoire tampon avant de les écrire physiquement sur le disque.\n" +
                "* **`bufferedWriter.write(mezmun)`** : Écrit la chaîne de caractères contenue dans la variable `mezmun` à l'intérieur du fichier.\n" +
                "* **`bufferedWriter.close()`** : Ferme le flux, ce qui est crucial pour s'assurer que toutes les données sont bien enregistrées et que les ressources système sont libérées.\n" +
                "\n" +
                "---\n" +
                "\n");
        stringBuilder.append(" +\n" +
                "                \"### Points d'attention et améliorations\\n\" +\n" +
                "                \"Bien que fonctionnel, ce code présente quelques aspects qui pourraient être optimisés :\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"* **Gestion des exceptions** : Le code utilise plusieurs blocs `try-catch` qui relancent des `RuntimeException`. Dans un environnement professionnel, on préfère souvent utiliser un bloc **try-with-resources** pour fermer automatiquement les fichiers, même en cas d'erreur.\\n\" +\n" +
                "                \"* **Nommage** : Les noms de variables comme `mezmun` ou `foldN` sont peu explicites. Utiliser `content` ou `folderName` rendrait le code plus lisible.\\n\" +\n" +
                "                \"* **Importations** : Notez que pour que ce code compile, vous devez importer `java.io.*`.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"### Exemple d'utilisation\\n\" +\n" +
                "                \"Si vous appelez la méthode ainsi :\\n\" +\n" +
                "                \"`wtf(\\\"Documents\\\", \\\"notes\\\", \\\".txt\\\", \\\"Bonjour le monde\\\");`\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Le programme créera un dossier **Documents** et un fichier nommé **notes.txt** contenant le texte \\\"**Bonjour le monde**\\\".\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Souhaitez-vous que je vous montre une version plus moderne et sécurisée de ce code\" +\n" +
                "                \" utilisant le \\\"try-with-resources\\\" ?");
        File file = new File("Gemini1"+File.separator+"gemini2.doc");
        System.out.println("Folder et file est crée");
        try {
            FileUtils.writeStringToFile(file,stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
