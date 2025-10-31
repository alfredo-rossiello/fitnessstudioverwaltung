package org.example.fitnessstudioverwaltung.Helper;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DB {
    private EntityManager em;

    @Autowired
    public DB(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return this.em;
    }
}
