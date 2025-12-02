package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

//soll von Person erben
@Entity
public class Trainer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Trainer() {
    }
    public long getId() {
        return id;
    }
}
