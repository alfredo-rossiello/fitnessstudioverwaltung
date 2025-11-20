package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;
import org.example.fitnessstudioverwaltung.Repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.fitnessstudioverwaltung.Repository.JpaUserRepository;

@Entity
public class User extends BaseType{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

    public User () {}

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
