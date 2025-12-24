package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// kann gerade noch nicht von BaseType erben
@Entity
public class Mitgliedschaft extends BaseType{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String bezeichnung;

    public Mitgliedschaft(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Mitgliedschaft() {

    }

    @Override
    public long getId() {
        return id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
