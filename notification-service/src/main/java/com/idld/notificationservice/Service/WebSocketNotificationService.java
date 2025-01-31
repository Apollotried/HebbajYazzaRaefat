/* package com.idld.notificationservice.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebSocketNotificationService {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketNotificationService.class);
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketNotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendNotificationToUser(Long userId, String message) {
        logger.info("Sending WebSocket notification to user {}: {}", userId, message);
        Map<String, String> payload = new HashMap<>();
        payload.put("message", message);
        messagingTemplate.convertAndSendToUser(userId.toString(), "/queue/notifications", payload);
    }


    public void sendNotificationToAll(String message) {
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }

}
*/
