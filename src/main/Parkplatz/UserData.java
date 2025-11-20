public class UserData {

    private String vorname;
    private String nachname;
    private String geb;
    private String strasse;
    private String nummer;
    private String ort;
    private String land;
    private String plz;
    private String email;
    private String tel;

    /*
    public UserData(String vorname, String nachname, String geb) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geb = geb;
    }

    public UserData(String email, String tel) {
        this.email = email;
        this.tel = tel;
    }

    public UserData(String strasse, String land, String ort, String nummer) {
        this.strasse = strasse;
        this.land = land;
        this.ort = ort;
        this.nummer = nummer;
    } */

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

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
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
