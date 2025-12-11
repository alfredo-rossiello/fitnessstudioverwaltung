package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

import java.util.List;

//soll von Person erben
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany
    private List<Qualifikation> qualifikation;

    public Trainer() {
    }

    public long getId() {
        return id;
    }
}
