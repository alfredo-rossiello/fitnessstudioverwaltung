package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Adresse extends  BaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String strasse;

    @Column(name = "Nummer_Adresszusatz")
    private String nummer;

    private String plz;
    private String ort;

    @Column(name = "laenderkuerzel")
    private String land;

    @OneToMany(mappedBy="adresse", cascade=CascadeType.ALL)
    private List<Person> person;

    public Adresse(String strasse, String nummer, String plz, String ort, String land) {
        this.strasse = strasse;
        this.nummer = nummer;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
    }

    public Adresse() {
    }

    public long getId() {
        return Id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}