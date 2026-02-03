package org.example.fitnessstudioverwaltung.Domain;

import org.example.fitnessstudioverwaltung.Helper.Alter;
import org.example.fitnessstudioverwaltung.Helper.PwdHash;

public class Login {
    // User
    private String username;
    private String password;
    private String password1;

    // Person
    private String vorname;
    private String nachname;

    // könnte auch als Date übergeben werden
    private String gebDatum;

    private String tel;

    // Adresse
    private String strasse;
    private String nummer;
    private String ort;
    private String land;
    private String plz;

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

    public String getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(String gebDatum) {
        this.gebDatum = gebDatum;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return PwdHash.hashPassword(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return PwdHash.hashPassword(password1);
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    // Alters überprüfung
    public boolean isAdult() {
        return Alter.isAdult(getGebDatum());
    }
}
