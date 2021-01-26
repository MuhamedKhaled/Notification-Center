package com.demo.service;

import com.demo.entities.Notification;
import com.demo.request.NotificationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NotificationService {

    Integer sendNotification(NotificationRequest notificationRequest);
    List<Notification>getNotification();
}
