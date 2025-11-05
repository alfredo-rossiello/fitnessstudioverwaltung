package org.example.fitnessstudioverwaltung.Repository;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fitnessstudioverwaltung.Model.Qualifikation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaQualifiktionRepository extends BaseTypeRepository{

    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public JpaQualifiktionRepository() {
        super();
    }

    @Transactional
    public Qualifikation save(Qualifikation q) {
        super.setEntityManager(em);
        return (Qualifikation) super.save(q);
    }
}
