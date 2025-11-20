package org.example.fitnessstudioverwaltung.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fitnessstudioverwaltung.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository extends BaseTypeRepository{
    private EntityManager em;

    @Autowired
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public JpaUserRepository() {
        super();
    }

    @Transactional
    public User save(User user) {
        super.setEntityManager(em);
        return (User) super.save(user);
    }
}
