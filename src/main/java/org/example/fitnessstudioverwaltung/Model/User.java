package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;
import org.example.fitnessstudioverwaltung.Repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class User extends BaseType{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Person person;

    private String username;
    private String password;

    public User () {}

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
