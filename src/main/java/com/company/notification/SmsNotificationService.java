package com.company.notification;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("smsNotificationService")
public class SmsNotificationService implements NotificationService{

    @Value("${notification.sms.sender:COMPANY}")
    private String sender;

    @PostConstruct
    public void init() {
        System.out.println("[SmsNotificationService] Initialised (@PostConstruct), sender=" + sender);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[SmsNotificationService] Destroyed (@PreDestroy)");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS sender=" + sender + "] " + message);
    }
}
