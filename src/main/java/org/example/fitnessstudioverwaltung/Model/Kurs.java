package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kurs extends BaseType{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String titel;
    private String inhalt;
    private int teilnehmerzahl;
    private int anzahlTermine;
    private int intervall;
    private int anzahlIntervall;

    public Kurs() {
    }

    public Kurs(String titel, String inhalt, int teilnehmerzahl, int anzahlTermine, int intervall, int anzahlIntervall) {
        this.titel = titel;
        this.inhalt = inhalt;
        this.teilnehmerzahl = teilnehmerzahl;
        this.anzahlTermine = anzahlTermine;
        this.intervall = intervall;
        this.anzahlIntervall = anzahlIntervall;
    }

    public long getId() {
        return Id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public int getTeilnehmerzahl() {
        return teilnehmerzahl;
    }

    public void setTeilnehmerzahl(int teilnehmerzahl) {
        this.teilnehmerzahl = teilnehmerzahl;
    }

    public int getAnzahlTermine() {
        return anzahlTermine;
    }

    public void setAnzahlTermine(int anzahlTermine) {
        this.anzahlTermine = anzahlTermine;
    }

    public int getIntervall() {
        return intervall;
    }

    public void setIntervall(int intervall) {
        this.intervall = intervall;
    }

    public int getAnzahlIntervall() {
        return anzahlIntervall;
    }

    public void setAnzahlIntervall(int anzahlIntervall) {
        this.anzahlIntervall = anzahlIntervall;
    }
}
