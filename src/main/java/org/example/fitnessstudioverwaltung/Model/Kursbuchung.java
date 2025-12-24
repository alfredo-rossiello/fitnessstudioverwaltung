package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

// vielleicht wird diese weggelassen!
// soll von Buchung erben
@Entity
public class Kursbuchung extends BaseType{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Kursbuchung() {
    }

    @Override
    public long getId() {
        return id;
    }
}
