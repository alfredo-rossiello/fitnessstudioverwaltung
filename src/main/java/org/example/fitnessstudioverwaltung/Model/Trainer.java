package org.example.fitnessstudioverwaltung.Model;

import jakarta.persistence.*;

import java.util.List;

//soll von Person erben
@Entity
public class Trainer extends BaseType{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany // (cascade = CascadeType.ALL)
    private List<Qualifikation> qualifikation;

    public Trainer() {
    }

    @Override
    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Qualifikation> getQualifikation() {
        return qualifikation;
    }

    public void setQualifikation(List<Qualifikation> qualifikation) {
        this.qualifikation = qualifikation;
    }
}
