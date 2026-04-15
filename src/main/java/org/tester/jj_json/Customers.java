package org.tester.jj_json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @created : 02/04/2026,17:09,jeu.
 **/
public class Customers {
    @JsonProperty("Customers")
    private List<Costumer> customers;

    public Customers(List<Costumer> customers) {
        this.customers = customers;
    }
}
