package com.demo.dao;

import com.demo.entities.Notification;
import com.demo.repository.NotificationRepository;
import com.demo.request.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationDaoImpl implements NotificationDao{

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public Notification saveNotificationToDatabase(NotificationRequest notificationRequest) {
        Notification notification = new Notification();

        notification.setTitle(notificationRequest.getTitle());
        notification.setBody(notificationRequest.getBody());
        notification.setProviders(notificationRequest.getProviders());
        notification.setKind(notificationRequest.getKind());
        notification.setConsumers(notificationRequest.getConsumers());
        notification.setProviders(notificationRequest.getProviders());


        notification = notificationRepository.save(notification);

        return notification;
    }

    @Override
    public List<Notification> getNotifications() {
        return notificationRepository.findAll();
    }
}
