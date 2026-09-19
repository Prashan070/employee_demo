package com.example.employeeDemo.Configuration.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MockNotificationService implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("[DEV MOCK] Would send notification: " + message);
    }

}
