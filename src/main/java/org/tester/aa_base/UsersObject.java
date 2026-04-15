package org.tester.aa_base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @created : 02/04/2026,18:22,jeu.
 **/
public class UsersObject {
    @JsonProperty("users")
    private List<User> users;

    public UsersObject() {
    }

    public UsersObject(List<User> user) {
        this.users = user;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUser() {
        return users;
    }
}
