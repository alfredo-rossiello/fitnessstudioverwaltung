package org.example.fitnessstudioverwaltung.Controller;

import org.example.fitnessstudioverwaltung.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.web.bind.annotation.*;

///  FUNKTIONIERT NOCH NICHT!!!
///  DATEN WERDEN NICHT IN DATENBANK GESPEICHERT

@Controller
public class LoginController{

    private JpaUserRepository jpaUserRepository;

    @Autowired
    public void setJpaUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @GetMapping("/registerTemplate")
    public String registerTemplate(){
        return "register";
    }


    @PostMapping("/personalData")
    public String persoehnlicheDaten(@ModelAttribute Login login) {

        // hashen des Passworts
        //
        User user = jpaUserRepository.save(new User(login.getUsername(), login.getPassword()));

        return "personaldata";
    }


    @PostMapping("/formularKontaktdaten")
    public String eingabeformularKontaktdaten(@ModelAttribute Login login){
        // übergebene Daten müssen noch gespeichert werden
        return "kontaktdaten";
    }

    @GetMapping("/loginTemplate")
    public String loginTemplate() {
        return "login";
    }

    @GetMapping("/loginSheet")
    public String loginSheet() {
        return "login";
    }
}
