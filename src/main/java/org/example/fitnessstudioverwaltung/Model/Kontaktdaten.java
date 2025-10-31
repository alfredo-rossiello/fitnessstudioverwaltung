package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kontaktdaten extends BaseType{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String telefonnummer;
    private String email;

    public Kontaktdaten() {
    }

    public Kontaktdaten(String telefonnummer, String email) {
        this.telefonnummer = telefonnummer;
        this.email = email;
    }

    public long getId() {
        return Id;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
