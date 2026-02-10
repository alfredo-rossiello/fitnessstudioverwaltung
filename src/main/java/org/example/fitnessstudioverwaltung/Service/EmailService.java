package org.example.fitnessstudioverwaltung.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.example.fitnessstudioverwaltung.Repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Map;

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
        message.setFrom("alfredorossiello4@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);
    }


    // html email
    public void sendHtmlEmail(String to, String subject, String body) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        try {
            helper.setFrom("alfredorossiello4@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            emailSender.send(message);

            // exception darf nicht leer sein sonst wird Fehler ignoriert
        } catch (MessagingException _) {
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

        return templateEngine.process(path, context);
    }


    // überprüfung ob user existiert
    public boolean userIsValid(String username) {
        return jpaUserRepository.findByUsername(username) != null;
    }
}
