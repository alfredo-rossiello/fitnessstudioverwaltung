package org.example.fitnessstudioverwaltung.Controller;

import jakarta.mail.MessagingException;
//import org.example.fitnessstudioverwaltung.Service.MailService;
import org.example.fitnessstudioverwaltung.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 1. Email verschicken zur bestätigung der
// Identität nach registrierung
// 2. Email verschicken wenn Passwort gewechselt
// wird oder vergessen wurde

// brauche in den jeweiligen Klassen auch noch eine update methode
// welche die veränderten Werte in die DB schreibt

// unterscheidung zuwischen forward und redirect

// email per event und event listener versenden
// beim registrieren eine wilkommen email, beim kurs buchen eine bestätigungs email, etc.


// alfredo_rossiello@web.de
// - für Email vielleicht nicht die email nehmen mit der man angesprochen wird, sondern mit dem Vornamen
// aber dafür brauche ich vermutlich einen Join, aber das ist zukunftsmusik
@Controller
public class EmailController {

    private EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }


    // email eingabe um email zu bekommen mit der man das Passwort aendern kann
    @GetMapping("/aktuallisierungTemplate")
    public String benutzerNameEingeben (Model model) {
        return "neueTemplates/emailVersendenPwdVergabe";
    }


    // RequestParameter erwartet immer einen Wert
    @PostMapping("/nutzerVerifizierung")
    public String ueberpruefungVonUser(
            @RequestParam(value = "username", required = false) String username,
            RedirectAttributes redirectAttributes) {

        if (username != null) {
            try {
                // 1. überprüfung ob der username existiert
                if (emailService.userIsValid(username)) {
                    // 2. einfügen von username
                    String htmlBody = emailService.htmlBodyThWert(
                            "src/main/resources/templates/neueTemplates/emailTemplate",
                            username);

                    // 3. versenden der Email
                    emailService.sendHtmlEmail(username, "Passwort aendern", htmlBody);

                    // 4. Message wenn Email gefunden
                    // model.addAttribute("message", "Die Email wurde erfolgreich versand!");
                    redirectAttributes.addFlashAttribute(
                            "message", "Die Email wurde erfolgreich versand!");
                } else {
                    // 5. Message wenn Email nicht gefunden
                    // model.addAttribute("message", "Der Username existiert nicht!");
                    redirectAttributes.addFlashAttribute(
                            "message", "Der Username existiert nicht!");
                }
            } catch (MessagingException _) {
                // model.addAttribute("message", "Das versenden der Email ist fehlgeschlagen!");
                redirectAttributes.addFlashAttribute(
                        "message", "Das versenden der Email ist fehlgeschlagen!");
            }
        }

        return "redirect:/aktuallisierungTemplate";
    }


    // wenn auf link in email geklickt dann passwort aendern möglich
    // soll bei erfolgreichem aendern auf login mappen
    @GetMapping("/pwdAendernTemplate")
    public String pwdAendern() {
        return "/neueTemplates/pwdAendern";
    }


    // wenn pwd aenderung nicht erfolgreich dann auf die aktuelle Seite zurück!!!
    @PostMapping("pwdValidTemplate")
    public String pwdGeaendert() {
        // bei erfolgreichem Aendern das neue Passwort
        // in der DB speichern ( Update )
        // bei nicht erfolgreichem Aendern zurück mappen

        return "redirect:/eingabeTemplate";
    }

}
