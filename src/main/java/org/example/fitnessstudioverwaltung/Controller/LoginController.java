package org.example.fitnessstudioverwaltung.Controller;

import org.example.fitnessstudioverwaltung.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// fitnessstudioverwaltung
// wie wird zwischen volljährig und nicht volljährig unterschieden
//  -> (DB eintrag?, Methode die dein alter ausrechnet und dir anhand dessen deine Zugriffsrechte erteilt?, ...)
// model Objekte müssen auch noch mit einbezogen werden damit Fehlermeldungen angezeigt werden können
// der user wird noch nicht in der DB gespeichert!
@Controller
public class LoginController{

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

    @GetMapping("/registerTemplate")
    public String registerTemplate(){
        return "register";
    }

    @PostMapping("/personalData")
    public String persoehnlicheDaten(@ModelAttribute UserData user, Model model) {

        // passwort hashen, mit salt
        // bestätigungs email an email adresse!
        //User user = new User(login.getUserData().get(0), login.getUserData().get(1));
        model.addAttribute("user", new User(user.getUsername(), user.getPassword()));

        return "personaldata";
    }

    // übergeben von urls über thymleaf
    @PostMapping("/eingabeformular")
    public String eingabeformular(@ModelAttribute Login login, @ModelAttribute("user") UserData userData, Model model){

        // jpaAdressRepository.save(new Adresse(login.getStrasse(), login.getNummer(), login.getPlz(), login.getOrt(), login.getLand()));
        Adresse adresse = new Adresse(login.getStrasse(), login.getNummer(), login.getPlz(), login.getOrt(), login.getLand());
        Person person = new Person(login.getVorname(), login.getNachname(), String.join("-", String.valueOf(login.getJahr()), String.valueOf(login.getMonat()), String.valueOf(login.getTag())), login.getTel());
        User user = new User(userData.getUsername(), userData.getPassword());

        // Fremdschlüssel wird gesetzt, jetzt weiß db welcher Wert eingetragen werden soll
        person.setAdresse(adresse);
        person.setUser(user);

        // Daten werden in DB gespeichert
        jpaUserRepository.save(user);
        jpaPersonRepository.save(person);

        // überprüfung ob Person 18 ist
        if (login.isAdult()) {
            return "login";
        } else {
            // fehlermeldung wenn noch nicht 16
            // mitarbeiterin muss mit Muttizettel bestätigung Daten eintragen
            // oder Eltern tragen daten ein
            return "personaldata";
        }
    }

    // hier erwartet es Werte
    //@PostMapping("/loginTemplate")
    @RequestMapping(path = "/loginTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginTemplate(@ModelAttribute Login login) {
        return "login";
    }

    // bei erfolgreichem einloggen
    @PostMapping("/eingeloggtTemplate")
    public String eingeloggt() {
        return "eingeloggt";
    }
}
