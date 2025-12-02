package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

//soll von Person erben
@Entity
public class Mitglied {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    private boolean istMinderjaehrig;

    public Mitglied() {
    }

    // muss mir die altersüberprüfung noch anders überlegen
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
