package org.tester.aa_base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @created : 02/04/2026,18:16,jeu.
 **/
//@JsonIgnoreProperties
public class User {
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;
    public User() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
