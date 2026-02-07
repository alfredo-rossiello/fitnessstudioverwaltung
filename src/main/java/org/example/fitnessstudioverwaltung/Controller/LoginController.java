package org.example.fitnessstudioverwaltung.Controller;

import org.example.fitnessstudioverwaltung.Domain.*;
import org.example.fitnessstudioverwaltung.Helper.PwdHash;
import org.example.fitnessstudioverwaltung.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.fitnessstudioverwaltung.Model.*;
import org.example.fitnessstudioverwaltung.Repository.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// fitnessstudioverwaltung
// 1. Werte sollen zurück in inputfelder geschrieben werden -> optional (nicht sehr wichtig)

// 2. salt in Tabelle speichern oder einen Algorithmus nehmen der automatisch einen
// salt generiert den man nicht extra in der Datenbank speichert

// 3. das mit dem forward habe ich noch nicht ganz überrissen ( funktioniert noch nicht )

@Controller
public class LoginController{

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/registerTemplate")
    public String registerTemplate(){
        // es wird nur zum RegisterTemplate gemapped wenn auch eine Mitgliedschaft ausgewählt wurde
        // account wird nur nach bestätigung der Identität (vorzeigen des Ausweises und validierung der Email aktiviert
        return "neueTemplates/register";
    }


    /*
    // die übergebenen Werte sind nicht mehr gespeichert und deswegen gibt es eine nullpointer exeption
    // in der Methode werden alle anderen Fehlermeldungen ignoriert wenn eine zutrifft
    // ausgeben der Fehlermeldung
    @GetMapping("/errorRegisterTemplate")
    public String redirectedRegisterTemplate(@ModelAttribute Login login, Model model){

        // vielleicht muss ich hier eine session setzten
        if (loginService.usernameExists(login.getUsername())) {
            model.addAttribute("issue", "Wähle einen anderen usernamen!");
        }

        if (!login.pwdEqualsPwd1()) {
            model.addAttribute("issue", "Deine Passwörter stimmen nicht überein!");
        }

        // hier dann noch eine überprüfung ob das Passwort
        // auch den vorraussetzungen entsprochen hat
        return "neueTemplates/register";
    }*/


    @RequestMapping(path = "/eingabeTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public String eingabeformular(@ModelAttribute Login login, Model model){

        // überprüfung ob passwort den Anforderungen etspricht (&& login.pwdIsValid())
        if (login.isNotNull()) {

            Adresse adresse = new Adresse(login.getStrasse(), login.getNummer(), login.getPlz(), login.getOrt(), login.getLand());
            Person person = new Person(login.getVorname(), login.getNachname(), login.getGebDatum(), login.getTel());
            User user = new User(login.getUsername(), PwdHash.hashPassword(login.getPassword()));

            // Fremdschlüssel wird gesetzt, jetzt weiß db welcher Wert eingetragen werden soll
            person.setAdresse(adresse);
            person.setUser(user);


            // bei forward gleiches RequestObejekt und Server intern -> URL bleibtgleich/redirect neues RequestObejekt
            // Fehlermeldungen funktionieren noch nicht!!!
            // vielleicht eigentliche Fehlerüberpüfung dann in der FehlerRegisterTemplate() Methode
            if (!login.isAdult()) {
                return "redirect:/registerTemplate";

            } else if (!login.pwdEqualsPwd1()) {
                return "redirect:/registerTemplate";

            } else if (loginService.findUserByUsername(login.getUsername()) != null) {
                return "redirect:/registerTemplate";
            }

            loginService.saveUser(user);
            loginService.savePerson(person);
        }

        return "neueTemplates/login";
    }


    @GetMapping("/errorLoginTemplate")
    public String redirectLoginTemplate(Model model){
        model.addAttribute("error", "Dein Username oder Passwort ist falsch");
        return "/neueTemplates/login";
    }


    // bei erfolgreichem einloggen wird zu Profil weitergeleitet!
    @PostMapping("/anmeldeTemplate")
    public String profile(@ModelAttribute Login login) {
        // soll ich den Hashwert überprüfen oder den enthashten wert?
        if(loginService.usernameExists(login.getUsername())) {
            if (loginService.passwordIsValid(login.getUsername(), login.getPassword())) {
                return "/neueTemplates/profile";
            } else {
                return "redirect:/errorLoginTemplate";
            }
        } else {
            return "redirect:/errorLoginTemplate";
        }
    }
}
