package org.example.fitnessstudioverwaltung.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 1. Email verschicken zur bestätigung der
// Identität nach registrierung
// 2. Email verschicken wenn Passwort gewechselt
// wird oder vergessen wurde

// brauche in den jeweiligen Klassen auch noch eine update methode
// welche die veränderten Werte in die DB schreibt

// unterscheidung zuwischen forward und redirect

@Controller
public class EmailController {

    // email eingabe um email zu bekommen mit der man das Passwort aendern kann
    @GetMapping("/benutzerTemplate")
    public String benutzerNameEingeben () {
        return "/neueTemplates/emailVersendenZuPwdVergabe";
    }


    // wenn auf link in email geklickt dann passwort aendern möglich
    // soll bei erfolgreichem aendern auf login mappen
    @GetMapping("/pwdTemplate")
    public String passwortAendern() {
        return "/neueTemplates/pwdAendern";
    }

    // wenn pwd aenderung nicht erfolgreich dann auf die aktuelle Seite zurück!!!
    @PostMapping("pwdTemplateValid")
    public String pwdGeaendert() {
        // bei erfolgreichem Aendern das neue Passwort
        // in der DB speichern (Update)
        // bei nicht erfolgreichem Aendern zurück mappen

        return "redirect:/eingabeTemplate";
    }

}
