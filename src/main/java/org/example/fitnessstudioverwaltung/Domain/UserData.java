package org.example.fitnessstudioverwaltung.Domain;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    private String username;
    private String password;

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
