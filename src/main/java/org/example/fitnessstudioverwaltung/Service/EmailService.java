package org.example.fitnessstudioverwaltung.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.example.fitnessstudioverwaltung.Repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Map;

// n.dummie@web.de
// 1234TestPasswor

@Service
public class EmailService {

    private JavaMailSender emailSender;
    private SpringTemplateEngine templateEngine;
    private JpaUserRepository jpaUserRepository;

    @Autowired
    public void setMailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Autowired
    public void setTemplateEngine(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Autowired
    public void setJpaUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    // reine Text email
    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);
    }


    // html email
    public void sendHtmlEmail(String to, String subject, String body) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            emailSender.send(message);

            // exception darf nicht leer sein sonst wird Fehler ignoriert
        } catch (MessagingException e) {
            // mit einem Logging error abgefangen werden
            e.fillInStackTrace();
        } catch (MailSendException e) {
            // auch logging benötigt
            e.fillInStackTrace();
        }
    }


    // für mehr als einen Wert
    public String htmlBodyThMap(String path, Map<String, String> tymleaf) {
        Context context = new Context();

        // vielleicht ist das zu umständlich
        for (String key : tymleaf.keySet()) {
            context.setVariable(key, tymleaf.get(key));
        }

        return templateEngine.process(path, context);
    }


    // für genau einen Wert
    public String htmlBodyThWert(String path, String value) {
        Context context = new Context();
        context.setVariable("greeting", value);

        // links im Template müssen url enthalten!
        return templateEngine.process(path, context);
    }


    // überprüfung ob user existiert
    public boolean userIsValid(String username) {
        return jpaUserRepository.findByUsername(username) != null;
    }
}
