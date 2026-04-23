package org.tester.jjj_json;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Tests pour la sérialisation JSON
 * @created : 23/04/2026
 **/
public class JsonSerializerTest {

    @Test
    public void testSerializeCustomers() {
        try {
            // Création de données de test
            Customer customer1 = new Customer("Alice", "Dubois", "alice.dubois@test.com",
                    "+33111111111", "75002", "Paris");
            Customer customer2 = new Customer("Bob", "Lemoine", "bob.lemoine@test.com",
                    "+33222222222", "13001", "Marseille");

            List<Customer> customers = List.of(customer1, customer2);
            CustomersWrapper wrapper = new CustomersWrapper(customers);

            // Chemin du fichier de test
            String testFilePath = "jsonfiles" + File.separator + "TestCustomers.json";

            // Sérialisation
            JsonSerializer.serializeCustomers(wrapper, testFilePath);

            // Vérification que le fichier existe
            File outputFile = new File(testFilePath);
            assertTrue(outputFile.exists(), "Le fichier de sortie devrait exister");

            // Vérification du contenu en désérialisant
            CustomersWrapper deserialized = JsonDeserializer.deserializeCustomers(testFilePath);
            assertNotNull(deserialized);
            assertEquals(2, deserialized.getCustomers().size());

            Customer firstCustomer = deserialized.getCustomers().get(0);
            assertEquals("Alice", firstCustomer.getFirstName());
            assertEquals("Dubois", firstCustomer.getLastName());
            assertEquals("alice.dubois@test.com", firstCustomer.getEmail());

            System.out.println("Test de sérialisation réussi!");

            // Nettoyage
            outputFile.delete();

        } catch (IOException e) {
            fail("Erreur lors du test de sérialisation: " + e.getMessage());
        }
    }

    @Test
    public void testSerializeCustomersList() {
        try {
            // Création de données de test
            List<Customer> customers = List.of(
                new Customer("Charlie", "Garcia", "charlie.garcia@test.com",
                    "+33333333333", "33000", "Bordeaux")
            );

            String testFilePath = "jsonfiles" + File.separator + "TestCustomersList.json";

            // Sérialisation directe de la liste
            JsonSerializer.serializeCustomersList(customers, testFilePath);

            // Vérification
            File outputFile = new File(testFilePath);
            assertTrue(outputFile.exists());

            CustomersWrapper deserialized = JsonDeserializer.deserializeCustomers(testFilePath);
            assertEquals(1, deserialized.getCustomers().size());
            assertEquals("Charlie", deserialized.getCustomers().get(0).getFirstName());

            System.out.println("Test de sérialisation de liste réussi!");

            // Nettoyage
            outputFile.delete();

        } catch (IOException e) {
            fail("Erreur lors du test de sérialisation de liste: " + e.getMessage());
        }
    }

    @Test
    public void testToJsonString() {
        try {
            // Création de données de test
            Customer customer = new Customer("David", "Roux", "david.roux@test.com",
                    "+33444444444", "06000", "Nice");
            List<Customer> customers = List.of(customer);
            CustomersWrapper wrapper = new CustomersWrapper(customers);

            // Conversion en chaîne JSON
            String jsonString = JsonSerializer.toJsonString(wrapper);

            assertNotNull(jsonString);
            assertTrue(jsonString.contains("David"));
            assertTrue(jsonString.contains("Roux"));
            assertTrue(jsonString.contains("david.roux@test.com"));

            System.out.println("Test de conversion en chaîne JSON réussi!");
            System.out.println("JSON généré: " + jsonString);

        } catch (IOException e) {
            fail("Erreur lors du test de conversion en chaîne: " + e.getMessage());
        }
    }

    // Méthode main pour exécuter manuellement les tests
    public static void main(String[] args) {
        JsonSerializerTest test = new JsonSerializerTest();
        try {
            System.out.println("Exécution des tests de sérialisation...");
            test.testSerializeCustomers();
            test.testSerializeCustomersList();
            test.testToJsonString();
            System.out.println("Tous les tests de sérialisation sont passés avec succès!");
        } catch (Exception e) {
            System.err.println("Échec du test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
