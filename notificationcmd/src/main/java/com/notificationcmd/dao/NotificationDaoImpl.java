package com.notificationcmd.dao;


import com.notificationcmd.entities.Notification;
import com.notificationcmd.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class NotificationDaoImpl implements NotificationDao{

    @Autowired
    NotificationRepository notificationRepository;



    @Override
    public Notification getNotifications(Integer notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if(notification.isPresent())
            return notification.get();

        return null;
    }
}
