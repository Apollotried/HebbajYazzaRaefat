package com.idld.communicationservice.service;


import com.idld.communicationservice.Email.EmailService;
import com.idld.communicationservice.Entity.Notification;
import com.idld.communicationservice.Repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService implements NotificationServiceInterface{

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailService emailService;

    // Méthode pour un destinataire unique
    @Override
    public Notification sendNotification(String recipient, String subject, String message){
        try {
            Notification notification = new Notification(recipient, message, subject, "SENT", LocalDateTime.now());
            notificationRepository.save(notification);
            emailService.sendEmail(recipient, subject, message);
            return notification;
        } catch (Exception e) {
            logger.error("Error while sending notification to " + recipient, e);
        }
        return null;
    }

    // Méthode pour plusieurs destinataires (séparés par des espaces)
    @Override
    public void sendNotifications(String recipients, String subject, String message) {
        String[] recipientArray = recipients.split(" ");
        for (String recipient : recipientArray) {
            try {
                sendNotification(recipient, subject, message);
            } catch (Exception e) {
                logger.error("Failed to send notification to: " + recipient, e);
            }
        }
    }

    // Récupérer toutes les notifications
    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
