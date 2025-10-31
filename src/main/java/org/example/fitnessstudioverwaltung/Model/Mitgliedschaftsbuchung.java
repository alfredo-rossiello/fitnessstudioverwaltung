package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//soll von Buchung erben
@Entity
public class Mitgliedschaftsbuchung extends Buchung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Mitgliedschaftsbuchung() {
    }

    public long getId() {
        return id;
    }
}
