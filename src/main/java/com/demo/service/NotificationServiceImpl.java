package com.demo.service;

import com.demo.dao.NotificationDao;
import com.demo.entities.Notification;
import com.demo.request.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    NotificationDao notificationDao;

    @Override
    public Integer sendNotification(NotificationRequest notificationRequest) {
           return notificationDao.saveNotificationToDatabase(notificationRequest);
    }

    @Override
    public List<Notification> getNotification() {
        return notificationDao.getNotifications();
    }


}
