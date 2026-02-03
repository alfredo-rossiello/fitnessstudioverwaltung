package org.example.fitnessstudioverwaltung.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.fitnessstudioverwaltung.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// fitnessstudioverwaltung
// wie wird zwischen volljährig und nicht volljährig unterschieden
//  -> (DB eintrag?, Methode die dein alter ausrechnet und dir anhand dessen deine Zugriffsrechte erteilt?, ...)
// Werte sollen zurück in inputfelder geschrieben werden

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
        return "neueTemplates/register";
    }

    // wird vielleicht nicht gebraucht
    /*@PostMapping("/personalData")
    public String persoehnlicheDaten(@ModelAttribute Login user, HttpSession session) {

        // passwort hashen, mit salt
        // bestätigungs email an email adresse!
        if (!user.getPassword().isEmpty() && !user.getUsername().isEmpty()){
            session.setAttribute("user", user.getUsername());
            session.setAttribute("password", user.getPassword());
        } else {
            // zurück leiten
            return "neueTemplates/register";
        }

        return "personaldata";
    }*/

    @RequestMapping(path = "/eingabeTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public String eingabeformular(@ModelAttribute Login login, Model model){

        // überprüfung ob werte gesetzt/übergeben wurden ist noch nicht ausgereift!!!
        if (login.getUsername() != null && login.getPassword() != null) {
            Adresse adresse = new Adresse(login.getStrasse(), login.getNummer(), login.getPlz(), login.getOrt(), login.getLand());
            Person person = new Person(login.getVorname(), login.getNachname(), login.getGebDatum(), login.getTel());
            User user = new User(login.getUsername(), login.getPassword());

            // Fremdschlüssel wird gesetzt, jetzt weiß db welcher Wert eingetragen werden soll
            person.setAdresse(adresse);
            person.setUser(user);

            // Daten werden in DB gespeichert
            jpaUserRepository.save(user);
            // jpaPersonRepository.save(person);

            // gesetzte sessions löschen
            // session.removeAttribute("user");
            // session.removeAttribute("password");

            // überprüfung ob Person 18 ist
            if (!login.isAdult()) {
                // wenn noch nicht 18 dann fehlermeldung über das Model
                model.addAttribute("issue", "");
                return "neueTemplates/register";
            }
        }

        // neue Methode die eingegebene Werte auch verarbeitet
        return "neueTemplates/login";
    }

    // bei erfolgreichem einloggen wird zu Profil weitergeleitet!
    @PostMapping("/eingeloggtTemplate")
    public String eingeloggt() {
        // ist noch nicht das Profil, soll aber zum Profil weiter leiten
        // überprüfung ob der benutzername übereinstimmt -> sql query, oder abfangen von Fehlermeldung
        return "eingeloggt";
    }
}
