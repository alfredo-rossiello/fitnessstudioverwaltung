package org.example.fitnessstudioverwaltung.Domain;

import org.example.fitnessstudioverwaltung.Model.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;

    // Person
    private String vorname;
    private String nachname;
    private String geb;

    // Adresse
    private String strasse;
    private String nummer;
    private String ort;
    private String land;
    private String plz;

    // Kontaktdaten wenn person über 18
    private String email;
    private String tel;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setEmail(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getGeb() {
        return geb;
    }

    public void setGeb(String geb) {
        this.geb = geb;
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

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // Methode zur Speicherung von Adressen
    public List<Adresse> addToArrayListAdresse(Adresse adr) {
        List<Adresse> adressen = new ArrayList<>();
        adressen.add(adr);
        return adressen;
    }

    // Methode zur Speicherung von
    public List<Kontaktdaten> addToArrayListKontaktdaten(Kontaktdaten kd) {
        List<Kontaktdaten> data = new ArrayList<>();
        data.add(kd);
        return data;
    }
}
