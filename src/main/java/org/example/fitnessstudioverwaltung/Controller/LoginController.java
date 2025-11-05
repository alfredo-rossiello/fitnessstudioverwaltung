package org.example.fitnessstudioverwaltung.Controller;

import org.example.fitnessstudioverwaltung.Interface.JpaBaseRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController{

    @GetMapping("/registerTemplate")
    public String registerTemplate(){
        return "register";
    }

    @PostMapping("/personalData")
    public String persoehnlicheDaten(Model model) {
        // übergebene Daten müssen noch gespeichert werden
        return "personalData";
    }

    @PostMapping("/eingabeformularKontaktdaten")
    public String eingabeformularKontaktdaten(){
        // übergebene Daten müssen noch gespeichert werden
        return "kontaktdaten";
    }

    @PostMapping("/loginTemplate")
    public String loginTemplate() {

        Person newPerson = new Person("test@test.de", "1234");//, Date.parse("10-10-1999"));
        JpaPersonRepository repo =  new JpaPersonRepository();
        repo.save(newPerson);

        return "login";
    }
}
