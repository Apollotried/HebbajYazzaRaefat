/* package com.idld.notificationservice.Service;

import com.idld.notificationservice.Repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final WebSocketNotificationService webSocketNotificationService;

    public NotificationService(NotificationRepository notificationRepository, WebSocketNotificationService webSocketNotificationService) {
        this.webSocketNotificationService = webSocketNotificationService;
    }

    public void sendNotificationToUser(Long userId, String message) {
        try {
            webSocketNotificationService.sendNotificationToUser(userId, message);
        } catch (Exception e) {
            System.err.println("Failed to send notification to user: " + e.getMessage());
        }
    }

    public void sendNotificationToAll(String message) {
        try {
            webSocketNotificationService.sendNotificationToAll(message);
        } catch (Exception e) {
            System.err.println("Failed to send notification to all users: " + e.getMessage());
        }
    }
}

 */