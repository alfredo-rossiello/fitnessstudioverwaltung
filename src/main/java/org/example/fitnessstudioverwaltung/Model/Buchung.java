package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Buchung extends BaseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String von;
    private String bis;

    public Buchung() {
    }

    public Buchung(String von, String bis) {
        this.von = von;
        this.bis = bis;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getBis() {
        return bis;
    }

    public void setBis(String bis) {
        this.bis = bis;
    }


}
