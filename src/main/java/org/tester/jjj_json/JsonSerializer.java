package org.tester.jjj_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Classe utilitaire pour la sérialisation d'objets Java vers JSON
 * @created : 23/04/2026
 **/
public class JsonSerializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // Configuration pour une sortie JSON formatée
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Sérialise un objet CustomersWrapper vers un fichier JSON
     * @param wrapper L'objet wrapper contenant les clients
     * @param filePath Chemin du fichier de destination
     * @throws IOException En cas d'erreur d'écriture
     */
    public static void serializeCustomers(CustomersWrapper wrapper, String filePath) throws IOException {
        File outputFile = new File(filePath);
        objectMapper.writeValue(outputFile, wrapper);
    }

    /**
     * Sérialise une liste de clients vers un fichier JSON
     * @param customers Liste des clients à sérialiser
     * @param filePath Chemin du fichier de destination
     * @throws IOException En cas d'erreur d'écriture
     */
    public static void serializeCustomersList(List<Customer> customers, String filePath) throws IOException {
        CustomersWrapper wrapper = new CustomersWrapper(customers);
        serializeCustomers(wrapper, filePath);
    }

    /**
     * Convertit un objet CustomersWrapper en chaîne JSON
     * @param wrapper L'objet wrapper à convertir
     * @return Chaîne JSON formatée
     * @throws IOException En cas d'erreur de conversion
     */
    public static String toJsonString(CustomersWrapper wrapper) throws IOException {
        return objectMapper.writeValueAsString(wrapper);
    }

    /**
     * Convertit une liste de clients en chaîne JSON
     * @param customers Liste des clients à convertir
     * @return Chaîne JSON formatée
     * @throws IOException En cas d'erreur de conversion
     */
    public static String customersListToJsonString(List<Customer> customers) throws IOException {
        CustomersWrapper wrapper = new CustomersWrapper(customers);
        return toJsonString(wrapper);
    }

    /**
     * Exemple d'utilisation pour sérialiser des clients
     */
    public static void main(String[] args) {
        try {
            // Création d'exemples de clients
            Customer customer1 = new Customer("Jean", "Dupont", "jean.dupont@email.com",
                    "+33123456789", "75001", "Paris");

            Customer customer2 = new Customer("Marie", "Martin", "marie.martin@email.com",
                    "+33987654321", "69001", "Lyon");

            List<Customer> customers = List.of(customer1, customer2);
            CustomersWrapper wrapper = new CustomersWrapper(customers);

            // Sérialisation vers fichier
            String outputFilePath = "jsonfiles" + File.separator + "NewCustomers.json";
            serializeCustomers(wrapper, outputFilePath);
            System.out.println("Fichier JSON créé avec succès: " + outputFilePath);

            // Sérialisation vers chaîne
            String jsonString = toJsonString(wrapper);
            System.out.println("JSON généré:");
            System.out.println(jsonString);

            // Vérification en désérialisant
            CustomersWrapper deserialized = JsonDeserializer.deserializeCustomers(outputFilePath);
            System.out.println("Vérification - Nombre de clients désérialisés: " + deserialized.getCustomers().size());

        } catch (IOException e) {
            System.err.println("Erreur lors de la sérialisation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
