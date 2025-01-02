package com.idld.communicationservice.Email;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;


    // Méthode pour envoyer un email
    public void sendEmail(String to, String subject, String message) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("your_email@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(message);
        emailSender.send(mimeMessage);
    }

}


