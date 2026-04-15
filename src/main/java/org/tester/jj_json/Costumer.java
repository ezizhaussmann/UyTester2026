package org.tester.jj_json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @created : 02/04/2026,16:56,jeu.
 **/
public class Costumer {
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty ("LastName")
    private String  lastName;
    @JsonProperty("Email")
    private String  email;
    @JsonProperty("PhoneNumber")
    private String  phonNumber;
    @JsonProperty("PostCode")
    private String   postCode;
    @JsonProperty("City")
    private String    city;

    public Costumer() {
    }

    public Costumer(String firstName, String lastName, String email, String phonNumber, String postCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phonNumber = phonNumber;
        this.postCode = postCode;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
