package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Person extends BaseType implements Comparable<Person>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    // private String username;
    // private String password;

    public Person() {
    }

    public Person(String vorname, String nachname, LocalDate geburtsdatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    @Override
    public int compareTo(Person o) {
        return this.geburtsdatum.compareTo(o.getGeburtsdatum());
    }
}
