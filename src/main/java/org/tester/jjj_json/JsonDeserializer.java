package org.tester.jjj_json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Classe utilitaire pour la désérialisation de fichiers JSON
 * @created : 23/04/2026
 **/
public class JsonDeserializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Désérialise un fichier JSON Customers en objet CustomersWrapper
     * @param filePath Chemin vers le fichier JSON
     * @return CustomersWrapper contenant la liste des clients
     * @throws IOException En cas d'erreur de lecture du fichier
     */
    public static CustomersWrapper deserializeCustomers(String filePath) throws IOException {
        File jsonFile = new File(filePath);
        return objectMapper.readValue(jsonFile, CustomersWrapper.class);
    }

    /**
     * Désérialise un fichier JSON Customers et retourne directement la liste des clients
     * @param filePath Chemin vers le fichier JSON
     * @return Liste des clients
     * @throws IOException En cas d'erreur de lecture du fichier
     */
    public static List<Customer> getCustomersList(String filePath) throws IOException {
        CustomersWrapper wrapper = deserializeCustomers(filePath);
        return wrapper.getCustomers();
    }

    /**
     * Exemple d'utilisation pour désérialiser le fichier Customers.json
     */
    public static void main(String[] args) {
        try {
            // Chemin vers le fichier JSON
            String filePath = "jsonfiles" + File.separator + "Customers.json";

            // Désérialisation complète
            CustomersWrapper customersWrapper = deserializeCustomers(filePath);
            System.out.println("Désérialisation complète:");
            System.out.println(customersWrapper);

            // Récupération directe de la liste
            List<Customer> customers = getCustomersList(filePath);
            System.out.println("\nListe des clients:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }

            // Exemple d'accès aux données individuelles
            if (!customers.isEmpty()) {
                Customer firstCustomer = customers.get(0);
                System.out.println("\nPremier client:");
                System.out.println("Nom: " + firstCustomer.getFirstName() + " " + firstCustomer.getLastName());
                System.out.println("Email: " + firstCustomer.getEmail());
                System.out.println("Téléphone: " + firstCustomer.getPhoneNumber());
                System.out.println("Code postal: " + firstCustomer.getPstCode());
                System.out.println("Ville: " + firstCustomer.getCity());
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la désérialisation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
