package org.example.fitnessstudioverwaltung.Controller;

import org.example.fitnessstudioverwaltung.Domain.*;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


///  FUNKTIONIERT NOCH NICHT!!!
///  DATEN WERDEN NICHT IN DATENBANK GESPEICHERT


@Controller
public class LoginController{

    @GetMapping("/registerTemplate")
    public String registerTemplate(){
        return "register";
    }

    @PostMapping("/personalData")
    public String persoehnlicheDaten(@ModelAttribute User user, Model model) {
        // übergebene Daten müssen noch gespeichert werden
        boolean disabled;

        user.addToArrayListAdresse(new Adresse(user.getStrasse(), user.getNummer(), user.getPlz(), user.getOrt(), user.getLand()));
        user.addToArrayListKontaktdaten(new Kontaktdaten());

        if (user.getStrasse() == null || user.getNummer() == null || user.getPlz() == null || user.getOrt() == null || user.getLand() == null) {
            model.addAttribute("errorMassage", "Please fill out all Fields!");
            disabled = true;
        } else {
            disabled = false;
        }

        model.addAttribute("disabled", disabled);

        return "personalData";
    }

    @PostMapping("/eingabeformularKontaktdaten")
    public String eingabeformularKontaktdaten(@ModelAttribute User user){
        // übergebene Daten müssen noch gespeichert werden

        Person newPerson = new Person("test@test.de", "1234", LocalDate.of(1999, 9, 22));//, Date.parse("10-10-1999"));
        JpaPersonRepository repo =  new JpaPersonRepository();
        repo.save(newPerson);

        return "kontaktdaten";
    }

    @PostMapping("/loginTemplate")
    public String loginTemplate() {

        return "login";
    }
}
