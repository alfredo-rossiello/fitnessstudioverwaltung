package org.example.fitnessstudioverwaltung.Controller;

import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/registerTemplate")
    public String registerTemplate(){
        return "register";
    }

    @PostMapping("/loginTemplate")
    public String login() {

        Person newPerson = new Person("test@test.de", "1234");//, Date.parse("10-10-1999"));
        JpaPersonRepository repository = new JpaPersonRepository();
        repository.save(newPerson);

        return "login";
    }

}
