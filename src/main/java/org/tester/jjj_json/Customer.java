package org.tester.jjj_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe représentant un client pour la désérialisation JSON
 * @created : 23/04/2026
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("pstCode")
    private String pstCode;

    @JsonProperty("City")
    private String city;

    // Constructeur par défaut requis pour Jackson
    public Customer() {
    }

    // Constructeur avec paramètres
    public Customer(String firstName, String lastName, String email, String phoneNumber, String pstCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pstCode = pstCode;
        this.city = city;
    }

    // Getters et Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPstCode() {
        return pstCode;
    }

    public void setPstCode(String pstCode) {
        this.pstCode = pstCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pstCode='" + pstCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
