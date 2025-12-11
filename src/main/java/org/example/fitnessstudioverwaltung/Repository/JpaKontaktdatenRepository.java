package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaKontaktdatenRepository extends BaseTypeRepository{

    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public JpaKontaktdatenRepository() {
        super();
    }

    @Transactional
    public Kontaktdaten save (Kontaktdaten k) {
        super.setEntityManager(em);
        return (Kontaktdaten) super.save(k);
    }

}
