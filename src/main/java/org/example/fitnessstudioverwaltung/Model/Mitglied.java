package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//soll von Person erben
@Entity
public class Mitglied extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean istMinderjaehrig;

    public Mitglied() {
    }

    public boolean isIstMinderjaehrig() {
        return istMinderjaehrig;
    }

    public void setIstMinderjaehrig(boolean istMinderjaehrig) {
        this.istMinderjaehrig = istMinderjaehrig;
    }

    public long getId() {
        return id;
    }
}
