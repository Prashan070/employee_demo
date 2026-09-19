package com.example.employeeDemo.Configuration.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class RealNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("[PROD] Would send notification: " + message);
    }
}
