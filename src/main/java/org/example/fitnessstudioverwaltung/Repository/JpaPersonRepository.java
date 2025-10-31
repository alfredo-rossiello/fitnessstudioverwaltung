package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.example.fitnessstudioverwaltung.Model.*;

@Repository
public class JpaPersonRepository extends BaseTypeRepository{

    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public JpaPersonRepository() {
        super();
    }

    @Transactional
    public Person save (Person person) {
        super.setEntityManager(this.em);
        return (Person) super.save(person);
    }
}
