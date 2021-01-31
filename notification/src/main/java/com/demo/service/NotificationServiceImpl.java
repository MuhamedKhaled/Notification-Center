package com.demo.service;

import com.demo.dao.NotificationDao;
import com.demo.dto.MessageDto;
import com.demo.entities.Notification;
import com.demo.rabbitMq.MessagingConfig;
import com.demo.request.NotificationRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    NotificationDao notificationDao;

    @Autowired
    private RabbitTemplate template;

    @Override
    public Notification sendNotification(NotificationRequest notificationRequest) {

        // save notification in DB
        Notification notification = notificationDao.saveNotificationToDatabase(notificationRequest);
        MessageDto messageDto = new MessageDto(notification.getId());
        //publish message with notification id
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, messageDto);
           return notification;
    }

    @Override
    public List<Notification> getNotification() {
        return notificationDao.getNotifications();
    }


}
