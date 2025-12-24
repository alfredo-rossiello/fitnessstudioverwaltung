package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Buchung extends BaseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date von;
    private Date bis;

    public Buchung() {
    }

    public Buchung(Date von, Date bis) {
        this.von = von;
        this.bis = bis;
    }

    @Override
    public long getId() {
        return id;
    }

    public Date getVon() {
        return von;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public Date getBis() {
        return bis;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }


}
