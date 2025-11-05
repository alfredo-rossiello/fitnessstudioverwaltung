package org.example.fitnessstudioverwaltung.Domain;

public class UserData {

    private String vorname;
    private String nachname;
    private String geb;
    private String adr;
    private String ort;
    private String land;
    private String email;
    private String tel;

    public UserData(String vorname, String nachname, String geb, String adr, String ort, String land) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geb = geb;
        this.adr = adr;
        this.ort = ort;
        this.land = land;
    }

    public UserData(String email, String tel) {
        this.email = email;
        this.tel = tel;
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

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
