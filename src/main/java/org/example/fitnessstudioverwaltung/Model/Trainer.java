package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//soll von Person erben
@Entity
public class Trainer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Trainer() {
    }
    public long getId() {
        return id;
    }
}
