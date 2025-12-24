package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dienstplan extends BaseType{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private boolean Montag;
    private boolean Dienstag;
    private boolean Mittwoch;
    private boolean Donnerstag;
    private boolean Freitag;
    private boolean Samstag;
    private boolean Sonntag;

    public Dienstplan() {
    }

    public Dienstplan(boolean montag, boolean dienstag, boolean mittwoch, boolean donnerstag, boolean freitag, boolean samstag, boolean sonntag) {
        Montag = montag;
        Dienstag = dienstag;
        Mittwoch = mittwoch;
        Donnerstag = donnerstag;
        Freitag = freitag;
        Samstag = samstag;
        Sonntag = sonntag;
    }

    @Override
    public long getId() {
        return Id;
    }

    public boolean isMontag() {
        return Montag;
    }

    public void setMontag(boolean montag) {
        Montag = montag;
    }

    public boolean isDienstag() {
        return Dienstag;
    }

    public void setDienstag(boolean dienstag) {
        Dienstag = dienstag;
    }

    public boolean isMittwoch() {
        return Mittwoch;
    }

    public void setMittwoch(boolean mittwoch) {
        Mittwoch = mittwoch;
    }

    public boolean isDonnerstag() {
        return Donnerstag;
    }

    public void setDonnerstag(boolean donnerstag) {
        Donnerstag = donnerstag;
    }

    public boolean isFreitag() {
        return Freitag;
    }

    public void setFreitag(boolean freitag) {
        Freitag = freitag;
    }

    public boolean isSamstag() {
        return Samstag;
    }

    public void setSamstag(boolean samstag) {
        Samstag = samstag;
    }

    public boolean isSonntag() {
        return Sonntag;
    }

    public void setSonntag(boolean sonntag) {
        Sonntag = sonntag;
    }

}
