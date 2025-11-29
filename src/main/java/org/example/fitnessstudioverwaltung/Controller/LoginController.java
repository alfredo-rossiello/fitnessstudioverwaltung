package org.example.fitnessstudioverwaltung.Controller;

import org.example.fitnessstudioverwaltung.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.web.bind.annotation.*;


// model Objekte müssen auch noch mit einbezogen werden damit Fehlermeldungen angezeigt werden können
@Controller
public class LoginController{

    private JpaUserRepository jpaUserRepository;
    private JpaPersonRepository jpaPersonRepository;
    private JpaAdressRepository jpaAdressRepository;
    private JpaKontaktdatenRepository jpaKontaktdatenRepository;

    @Autowired
    public void setJpaUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Autowired
    public void setJpaPersonRepository(JpaPersonRepository jpaPersonRepository) {
        this.jpaPersonRepository = jpaPersonRepository;
    }

    @Autowired
    public void setJpaAdressRepository(JpaAdressRepository jpaAdressRepository) {
        this.jpaAdressRepository = jpaAdressRepository;
    }

    @Autowired
    public void setJpaKontaktdatenRepository(JpaKontaktdatenRepository jpaKontaktdatenRepository) {
        this.jpaKontaktdatenRepository = jpaKontaktdatenRepository;
    }

    @GetMapping("/registerTemplate")
    public String registerTemplate(){
        return "register";
    }


    @PostMapping("/personalData")
    public String persoehnlicheDaten(@ModelAttribute Login login) {

        // hashen des Passworts
        if (login.getPassword().equals(login.getPassword1())) {
            User user = jpaUserRepository.save(new User(login.getUsername(), login.getPassword()));
        }
        return "personaldata";
    }

    @PostMapping("/formularKontaktdaten")
    public String eingabeformularKontaktdaten(@ModelAttribute Login login){
        // die Objekte werden für das model benötigt
        Person person = jpaPersonRepository.save(new Person(login.getVorname(), login.getNachname(), String.join("-", String.valueOf(login.getJahr()), String.valueOf(login.getMonat()), String.valueOf(login.getTag()))));
        Adresse adresse = jpaAdressRepository.save(new Adresse(login.getStrasse(), login.getNummer(), login.getPlz(), login.getOrt(), login.getLand()));

        return "kontaktdaten";
    }

    @PostMapping("/loginTemplate")
    public String loginTemplate(@ModelAttribute Login login) {
        //Kontaktdaten kontaktdaten =
        jpaKontaktdatenRepository.save(new Kontaktdaten(login.getTel(), login.getEmail()));

        return "login";
    }

    @GetMapping("/loginSheet")
    public String loginSheet() {
        return "login";
    }
}
