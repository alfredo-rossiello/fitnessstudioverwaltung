package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

//soll von Person erben
@Entity
public class Mitglied extends BaseType{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "person_id")
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

    @Override
    public long getId() {
        return id;
    }
}
