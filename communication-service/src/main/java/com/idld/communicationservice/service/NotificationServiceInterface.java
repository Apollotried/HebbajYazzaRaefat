package com.idld.communicationservice.service;

import com.idld.communicationservice.Entity.Notification;

import java.util.List;

public interface NotificationServiceInterface {
    public void sendNotifications(String recipients, String subject, String message);
    public Notification sendNotification(String recipient, String subject, String message);
    public List<Notification> getAllNotifications();
}
