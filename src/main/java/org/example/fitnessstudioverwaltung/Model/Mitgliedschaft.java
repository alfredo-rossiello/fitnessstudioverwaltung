package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


// kann gerade noch nicht von BaseType erben
@Entity
public class Mitgliedschaft{
    @Id
    private String bezeichnung;

    public Mitgliedschaft(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Mitgliedschaft() {

    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
