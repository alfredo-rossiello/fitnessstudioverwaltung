package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Interface.*;

import java.util.List;

public abstract class BaseTypeRepository {//import JpaBaseRepositoryInteface{

    private EntityManager em;

    public BaseTypeRepository() {}

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public BaseType save(BaseType b) {
        if (b.getId() == 0L) {
            this.em.persist(b);
            return b;
        }

        return this.em.merge(b);
    }

    @Transactional
    public BaseType findById(Class c, long id) {
        return (BaseType) this.em.find(c, id);
    }

    @Transactional
    public List<BaseType> findAll(Class c) {
        List<BaseType> result = null;

        switch (c.getSimpleName()) {
            case "Person": {
                result = this.em.createQuery("from Person c", c).getResultList();
            }
        }
        return result;
    }

    @Transactional
    public void deleteById(Class c, Long id) {
        BaseType basetype = (BaseType) this.em.find(c, id);
        this.em.remove(basetype);
    }

    @Transactional
    public void delete(BaseType basetype) {
        em.remove(basetype);
    }
}
