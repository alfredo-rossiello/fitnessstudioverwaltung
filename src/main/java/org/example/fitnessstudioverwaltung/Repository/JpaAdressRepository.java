package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fitnessstudioverwaltung.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAdressRepository extends BaseTypeRepository{
    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public JpaAdressRepository() {super();}

    @Transactional
    public Adresse save (Adresse adr) {
        super.setEntityManager(em);
        return (Adresse) super.save(adr);
    }
}
