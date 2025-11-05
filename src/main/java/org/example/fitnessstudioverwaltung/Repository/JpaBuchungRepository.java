package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fitnessstudioverwaltung.Model.Buchung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBuchungRepository extends BaseTypeRepository{
    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public JpaBuchungRepository() {
        super();
    }

    @Transactional
    public Buchung save(Buchung b) {
        super.setEntityManager(em);
        return (Buchung) super.save(b);
    }
}
