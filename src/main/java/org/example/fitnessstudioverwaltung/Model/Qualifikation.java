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
    
    
    @ManyToMany
    private List<Trainer> trainer;

    public Qualifikation() {
    }

    public Qualifikation(String name, Date gueltigBis) {
        this.name = name;
        this.gueltigBis = gueltigBis;
    }

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
}
