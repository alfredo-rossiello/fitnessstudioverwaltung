package org.example.fitnessstudioverwaltung.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// für email logic im email controller für das versenden/empfangen

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // reine text email
    public void sendPlainText(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    // email die wie eine html seite gestylt werden kann innerhalb der email
    public void sendHtml(String to, String subject, String htmlBody) {
        try {
            // Java Object für Emails
            MimeMessage message = mailSender.createMimeMessage();
            // wrapper zum erstellen von komplexen emails
            MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);
            mailSender.send(message);

        } catch (MessagingException | MailSendException _) {
        }
    }

}
