package com.demo.dao;

import com.demo.entities.Notification;
import com.demo.request.NotificationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface NotificationDao {

    Integer saveNotificationToDatabase(NotificationRequest notificationRequest);
    List<Notification> getNotifications();

}
