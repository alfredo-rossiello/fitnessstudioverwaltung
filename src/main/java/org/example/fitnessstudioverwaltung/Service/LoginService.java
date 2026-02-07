package org.example.fitnessstudioverwaltung.Service;

import org.example.fitnessstudioverwaltung.Helper.PwdHash;
import org.example.fitnessstudioverwaltung.Model.Person;
import org.example.fitnessstudioverwaltung.Model.User;
import org.example.fitnessstudioverwaltung.Repository.JpaPersonRepository;
import org.example.fitnessstudioverwaltung.Repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private JpaUserRepository jpaUserRepository;
    private JpaPersonRepository jpaPersonRepository;

    @Autowired
    public void setJpaUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Autowired
    public void setJpaPersonRepository(JpaPersonRepository jpaPersonRepository) {
        this.jpaPersonRepository = jpaPersonRepository;
    }

    public void saveUser(User user) {
        jpaUserRepository.save(user);
    }

    public void savePerson(Person person) {
        jpaPersonRepository.save(person);
    }

    public String findUserByUsername(String username) {
        try {
            return jpaUserRepository.findByUsername(username).getUsername();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public String getPasswordByUsername(String username) {
        // nur für den Fall der Fälle aber hier brauche ich das eigentlich nicht!!!
        try {
            return jpaUserRepository.findByUsername(username).getPassword();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean usernameExists(String username) {
        return findUserByUsername(username) != null;
    }

    public boolean passwordIsValid(String username, String password) {
        return getPasswordByUsername(username).equals(PwdHash.hashPassword(password));
    }

}
