package org.tester.jjj_json;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Exemple d'utilisation des classes de sérialisation et désérialisation JSON
 * @created : 23/04/2026
 **/
public class JsonExample {

    public static void main(String[] args) {
        try {
            System.out.println("=== Exemple de Sérialisation et Désérialisation JSON ===\n");

            // 1. Création de données de test
            System.out.println("1. Création de clients de test...");
            Customer customer1 = new Customer("Pierre", "Durand", "pierre.durand@email.com",
                    "+33123456789", "75001", "Paris");

            Customer customer2 = new Customer("Sophie", "Leroy", "sophie.leroy@email.com",
                    "+33987654321", "69001", "Lyon");

            Customer customer3 = new Customer("Michel", "Moreau", "michel.moreau@email.com",
                    "+33555666777", "33000", "Bordeaux");

            List<Customer> customers = Arrays.asList(customer1, customer2, customer3);
            CustomersWrapper wrapper = new CustomersWrapper(customers);

            // 2. Sérialisation vers fichier JSON
            System.out.println("2. Sérialisation vers fichier JSON...");
            String outputFilePath = "jsonfiles" + java.io.File.separator + "ExampleCustomers.json";
            JsonSerializer.serializeCustomers(wrapper, outputFilePath);
            System.out.println("✓ Fichier créé: " + outputFilePath);

            // 3. Sérialisation vers chaîne JSON
            System.out.println("\n3. Conversion en chaîne JSON...");
            String jsonString = JsonSerializer.toJsonString(wrapper);
            System.out.println("✓ JSON généré:");
            System.out.println(jsonString);

            // 4. Désérialisation du fichier créé
            System.out.println("4. Désérialisation du fichier...");
            CustomersWrapper deserializedWrapper = JsonDeserializer.deserializeCustomers(outputFilePath);
            List<Customer> deserializedCustomers = deserializedWrapper.getCustomers();

            System.out.println("✓ " + deserializedCustomers.size() + " clients désérialisés:");
            for (int i = 0; i < deserializedCustomers.size(); i++) {
                Customer c = deserializedCustomers.get(i);
                System.out.println("  " + (i+1) + ". " + c.getFirstName() + " " + c.getLastName() +
                                 " (" + c.getEmail() + ") - " + c.getCity());
            }

            // 5. Modification et sauvegarde
            System.out.println("\n5. Modification d'un client et sauvegarde...");
            deserializedCustomers.get(0).setCity("Marseille");
            JsonSerializer.serializeCustomersList(deserializedCustomers, outputFilePath);
            System.out.println("✓ Modifications sauvegardées");

            // 6. Vérification des modifications
            System.out.println("6. Vérification des modifications...");
            CustomersWrapper finalWrapper = JsonDeserializer.deserializeCustomers(outputFilePath);
            Customer modifiedCustomer = finalWrapper.getCustomers().get(0);
            System.out.println("✓ Ville modifiée: " + modifiedCustomer.getFirstName() + " habite maintenant à " + modifiedCustomer.getCity());

            System.out.println("\n=== Exemple terminé avec succès! ===");

        } catch (IOException e) {
            System.err.println("Erreur lors de l'exemple: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
