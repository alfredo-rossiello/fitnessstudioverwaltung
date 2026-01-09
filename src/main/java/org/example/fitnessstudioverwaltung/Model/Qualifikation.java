package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Qualifikation extends BaseType{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Date gueltigBis;

    @ManyToMany (mappedBy = "qualifikation")
    private List<Trainer> trainer;

    @ManyToMany(mappedBy = "qualifikation")
    private List<Kurs> kurs;

    public Qualifikation() {
    }

    public Qualifikation(String name, Date gueltigBis) {
        this.name = name;
        this.gueltigBis = gueltigBis;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public List<Trainer> getTrainer() {
        return trainer;
    }

    public void setTrainer(List<Trainer> trainer) {
        this.trainer = trainer;
    }

    public List<Kurs> getKurs() {
        return kurs;
    }

    public void setKurs(List<Kurs> kurs) {
        this.kurs = kurs;
    }
}
