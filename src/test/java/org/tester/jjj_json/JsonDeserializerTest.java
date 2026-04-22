package org.tester.jjj_json;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

/**
 * Tests pour la désérialisation JSON
 * @created : 23/04/2026
 **/
public class JsonDeserializerTest {

    @Test
    public void testDeserializeCustomers() {
        try {
            // Test de désérialisation du fichier Customers.json
            String filePath = "jsonfiles/Customers.json";
            CustomersWrapper wrapper = JsonDeserializer.deserializeCustomers(filePath);

            assertNotNull(wrapper);
            assertNotNull(wrapper.getCustomers());
            assertFalse(wrapper.getCustomers().isEmpty());

            // Vérifier le premier client
            Customer firstCustomer = wrapper.getCustomers().get(0);
            assertNotNull(firstCustomer.getFirstName());
            assertNotNull(firstCustomer.getLastName());
            assertNotNull(firstCustomer.getEmail());

            System.out.println("Test réussi! Premier client: " + firstCustomer);

        } catch (IOException e) {
            fail("Erreur lors de la désérialisation: " + e.getMessage());
        }
    }

    @Test
    public void testGetCustomersList() {
        try {
            String filePath = "jsonfiles/Customers.json";
            List<Customer> customers = JsonDeserializer.getCustomersList(filePath);

            assertNotNull(customers);
            assertFalse(customers.isEmpty());
            assertTrue(customers.size() >= 2); // Le fichier contient au moins 2 clients

            System.out.println("Test réussi! Nombre de clients: " + customers.size());

        } catch (IOException e) {
            fail("Erreur lors de la récupération de la liste: " + e.getMessage());
        }
    }

    // Méthode main pour exécuter manuellement les tests
    public static void main(String[] args) {
        JsonDeserializerTest test = new JsonDeserializerTest();
        try {
            System.out.println("Exécution du test de désérialisation...");
            test.testDeserializeCustomers();
            test.testGetCustomersList();
            System.out.println("Tous les tests sont passés avec succès!");
        } catch (Exception e) {
            System.err.println("Échec du test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
