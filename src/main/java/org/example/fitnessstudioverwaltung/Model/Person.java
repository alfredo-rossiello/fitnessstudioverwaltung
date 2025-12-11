package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

// cascade Typ definieren

@Entity
public class Person extends BaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy="person", cascade=CascadeType.ALL)
    private Mitglied mitglied;

    @OneToOne(mappedBy="person", cascade=CascadeType.ALL)
    private Trainer trainer;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "adress_id")
    private Adresse adresse;

    private String vorname;
    private String nachname;
    // Date um in der Datenbank den Datentyp Date zu haben oder mit Localdate
    private String geburtsdatum;
    private String tel;

    public Person() {
    }

    public Person(String vorname, String nachname, String geburtsdatum, String tel) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.tel = tel;
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

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
