package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fitnessstudioverwaltung.Model.Kurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaKursRepository extends BaseTypeRepository{

    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public JpaKursRepository() {
        super();
    }

    @Transactional
    public Kurs save(Kurs k) {
        super.setEntityManager(em);
        return (Kurs) super.save(k);
    }
}
