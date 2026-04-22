package org.tester.jjj_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Classe wrapper pour la désérialisation du fichier JSON Customers
 * @created : 23/04/2026
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomersWrapper {
    @JsonProperty("Customers")
    private List<Customer> customers;

    // Constructeur par défaut requis pour Jackson
    public CustomersWrapper() {
    }

    // Constructeur avec paramètres
    public CustomersWrapper(List<Customer> customers) {
        this.customers = customers;
    }

    // Getter et Setter
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomersWrapper{" +
                "customers=" + customers +
                '}';
    }
}
