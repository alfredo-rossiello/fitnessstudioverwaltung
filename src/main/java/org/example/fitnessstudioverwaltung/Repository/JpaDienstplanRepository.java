package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fitnessstudioverwaltung.Model.Dienstplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaDienstplanRepository extends BaseTypeRepository{
    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public JpaDienstplanRepository() {
        super();
    }

    @Transactional
    public Dienstplan save(Dienstplan d) {
        super.setEntityManager(this.em);
        return (Dienstplan) super.save(d);
    }
}
