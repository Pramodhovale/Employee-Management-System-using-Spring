package com.company.notification;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService{

    @Value("${notification.email.from:noreply@company.local}")
    private String from;

    @PostConstruct
    public void init() {
        System.out.println("[EmailNotificationService] Initialised (@PostConstruct), from=" + from);
    }

    @PreDestroy
        public void destroy() {
            System.out.println("[EmailNotificationService] Destroyed (@PreDestroy)");
        }

        @Override
        public void sendNotification(String message) {
            System.out.println("[EMAIL from=" + from + "] " + message);
        }
}
