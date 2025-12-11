package org.example.fitnessstudioverwaltung.Controller;

import org.example.fitnessstudioverwaltung.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// wie schaffe ich es das die richtige Controller methode aufgerufen wird?
// kann jetzt vermutlich zwischen volljährig und nicht volljährig unterscheiden
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

        // hashen des Passworts nicht vergessen
        // ändern des Passwortes anbieten
        // email per zusenden von email überprüfen
        if (login.getPassword().equals(login.getPassword1())) {
            User user = jpaUserRepository.save(new User(login.getUsername(), login.getPassword()));
        }

        return "personaldata";
    }

    // übergeben von urls über thymleaf
    @PostMapping("/eingabeformular")
    public String eingabeformular(@ModelAttribute Login login, Model model){
        // die Objekte werden für das model benötigt
        Adresse adresse = jpaAdressRepository.save(new Adresse(login.getStrasse(), login.getNummer(), login.getPlz(), login.getOrt(), login.getLand()));
        Person person = jpaPersonRepository.save(new Person(login.getVorname(), login.getNachname(), String.join("-", String.valueOf(login.getJahr()), String.valueOf(login.getMonat()), String.valueOf(login.getTag())), login.getTel()));

        // überprüfung ob Person 18 ist
        if (login.isAdult()) {
            return "login";
        } else {
            // fehlermeldung wenn noch nicht 16
            model.addAttribute("error",
                    "Du bist noch nicht 16! Deine Eltern müssen sich für dich anmelden");
            return "personaldata";
        }
    }

    // hier erwartet es Werte
    @PostMapping("/loginTemplate")
    public String loginTemplate(@ModelAttribute Login login) {
        return "login";
    }

    // ohne das es Werte erwartet
    @GetMapping("/loginSheet")
    public String loginSheet(){
        return "login";
    }

    // bei erfolgreichem einloggen
    @PostMapping("/eingeloggtTemplate")
    public String eingeloggt() {
        return "eingeloggt";
    }
}
